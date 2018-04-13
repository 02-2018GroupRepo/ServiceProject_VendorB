package bootcamp.model.invoice;
import java.math.BigDecimal;
import bootcamp.model.products.Product;

public class InvoiceItem {
	
	private int id;
	private Product product;
	private int count;
	
	public InvoiceItem() {}
	
	public InvoiceItem(Integer id ,Product product, Integer count) {
		this.product = product;
		this.count = count;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
