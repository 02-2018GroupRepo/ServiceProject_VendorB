package bootcamp.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.model.products.Product;
import bootcamp.service.PaymentService;
import bootcamp.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PaymentService PService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id) {
		log.debug("Retreiving product " + id);
    	return productService.getProductById(id); 
    }
	
	@RequestMapping("/product")
	public List<Product> getProductList(){
		return productService.getProducts();
	}
	
}
