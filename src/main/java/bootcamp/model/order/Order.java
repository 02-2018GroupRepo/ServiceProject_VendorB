package bootcamp.model.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Order {
	
	int id;
	int qty;
	
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Order() {}
	
	public Order(int id, int qty) {
		this.id = id;
		this.qty = qty;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

}
