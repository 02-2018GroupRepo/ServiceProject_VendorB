package bootcamp.model.invoice;

import java.util.List;

import bootcamp.model.products.Product;

public class Invoice {
	
	private int id;
	
	private Product p = new Product();
	
	private int count;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return p;
	}

	public void setProduct(Product p) {
		this.p = p;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}
	
}
