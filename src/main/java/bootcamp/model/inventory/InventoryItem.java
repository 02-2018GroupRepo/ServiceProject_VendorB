package bootcamp.model.inventory;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InventoryItem {
	
	private int id;
	private BigDecimal retail_price;
	private int number_available;
	
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public InventoryItem() {}
	
	public InventoryItem(int id, BigDecimal retail_price, int number_available) {
		this.id = id;
		this.retail_price = retail_price;
		this.number_available = number_available;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getRetail_price() {
		return retail_price;
	}
	public void setRetail_price(BigDecimal retail_price) {
		this.retail_price = retail_price;
	}
	public int getnumber_available() {
		return number_available;
	}
	public void setnumber_available(int number_available) {
		this.number_available = number_available;
	}
	
}
