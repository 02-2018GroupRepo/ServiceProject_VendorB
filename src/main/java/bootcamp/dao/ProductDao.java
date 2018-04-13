package bootcamp.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import bootcamp.model.inventory.InventoryItem;
import bootcamp.model.products.Product;

@Component
public class ProductDao {
	
	private final String GET_PRODUCTS = "SELECT id, name, description, retail_price, wholesale_price FROM product";
    private final String GET_PRODUCT_BY_ID_SQL = GET_PRODUCTS + " where id = ?";
    private final String GET_OUR_INVENTORY =  "SELECT inventory.id, number_available, retail_price FROM inventory JOIN product WHERE product.id = inventory.id";
    private final String PUT_INVOICE_IN_DB = "INSERT INTO invoice values (?, ?, ?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("#{'${listOfThings}'.split(',')}")
	private List<String> listOfThings;
	
	@Autowired
	private List<Product> items;
	@Autowired
	private List<InventoryItem> items2;
	
	public List<Product> getProducts() {
		return jdbcTemplate.query(GET_PRODUCTS, new BeanPropertyRowMapper<>(Product.class));
	}
	
	public Product getProductById(Integer id) {
		return jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID_SQL, new Object[] {id}, new BeanPropertyRowMapper<>(Product.class));
	}
	
	public List<String> getListOfThings(){
		return listOfThings;
	}
	
	public List<Product> getListOfProducts(){
		return items;
	}

	public List<InventoryItem> getListOfProductsInInventory() {
		items2 = jdbcTemplate.query(GET_OUR_INVENTORY, new BeanPropertyRowMapper<>(InventoryItem.class) );
		return items2;
	}

	public void putInvoiceInDB(int id, BigDecimal retail_price, int count) {
		jdbcTemplate.update(PUT_INVOICE_IN_DB, id, retail_price, count);
	}

}
