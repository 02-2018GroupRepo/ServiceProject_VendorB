package bootcamp.dao;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import bootcamp.model.inventory.InventoryItem;
import bootcamp.model.payment.Payment;

@Component
public class PaymentDao {
	
	private final String CHECK_MONEY_AMOUNT = "SELECT id, retail_price, number_available FROM invoice where id = ?";
	private final String UPDATE_QTY = "UPDATE inventory SET number_available = ? where id = ?";
    private final String GET_INVENTORY_QTY_BY_ID = "SELECT number_available FROM inventory where id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Payment properties;
	
	private static final Logger log = LoggerFactory.getLogger(PaymentDao.class);

	public Boolean getPayment(Payment pay) {
		InventoryItem invoice = jdbcTemplate.queryForObject(CHECK_MONEY_AMOUNT, new Object[] {pay.getId()}, new BeanPropertyRowMapper<>(InventoryItem.class));
		BigDecimal retail_price = invoice.getRetail_price();
		int count = invoice.getnumber_available();
		if(pay.getMoney().equals(retail_price.multiply(new BigDecimal(count)))) {
			BigDecimal amount = properties.getMoney();
			amount = amount.add(pay.getMoney());
			properties.setMoney(amount);
			log.info("Enough money, Payment Complete $" + properties.getMoney());
			subtractQtyFromDB(invoice.getId(), invoice.getnumber_available());
			log.info("Reducing inventory count for requested product");
			return true;
		}
		else {
			log.info("Not enough money, Payment canceled");
			return false;
		}
	}
	
	public int subtractQtyFromDB(int id, int qty) {
		int newAmount = 0;
		InventoryItem p = jdbcTemplate.queryForObject(GET_INVENTORY_QTY_BY_ID, new Object[] {id}, new BeanPropertyRowMapper<>(InventoryItem.class));
		newAmount = p.getnumber_available() - qty;
		jdbcTemplate.update(UPDATE_QTY, newAmount, id);
		return newAmount;
	}

}
