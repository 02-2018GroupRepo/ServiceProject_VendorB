package bootcamp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import bootcamp.dao.ProductDao;
import bootcamp.model.inventory.InventoryItem;
import bootcamp.model.invoice.Invoice;
import bootcamp.model.order.Order;
import bootcamp.model.products.Product;

@Component
public class InventoryService {
	
	@Autowired
	private List<Product> inventoryList;
	@Autowired
	private List<InventoryItem> list;
	
	private int id;
	
	private static final Logger log = LoggerFactory.getLogger(InventoryService.class);
	 
	 @Autowired
	 private SimpleDateFormat dateFormat;
	 
	 @Autowired
	 private ProductDao PDao;
	
	public void receiveInventory(List<Product> products) {
		inventoryList.addAll(products);
	}

	public List<InventoryItem> getInventory(){
		list = PDao.getListOfProductsInInventory();
		return list;
	}
	
	@Scheduled(cron = "${inventory.status.schedule}")
    public void inventoryStatus() {
        log.info("Checking on inventory status at {}", dateFormat.format(new Date()));
        log.debug("Debug goes here");
    }

	public Invoice getOrder(Order order) {
		Product c = PDao.getProductById(order.getId());
		Invoice invoice = new Invoice();
		id += 1;
		invoice.setId(id);
		invoice.setProduct(c);
		invoice.setCount(order.getQty());
		PDao.putInvoiceInDB(invoice.getId(), c.getRetail_price(), invoice.getCount());
		log.info("Adding invoice to database");
		//move subtract method to paymentDao -> subtract from data after true for payment
		return invoice;
	}
}