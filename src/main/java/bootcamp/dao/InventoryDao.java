package bootcamp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import bootcamp.model.products.Product;
import bootcamp.model.inventory.*;

@Component
public class InventoryDao {
	
	private final String GET_PRODUCTS = "SELECT * FROM inventory";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<InventoryItem> getInventory() {
		return jdbcTemplate.query(GET_PRODUCTS, new BeanPropertyRowMapper<>(InventoryItem.class));
		//return null;
	}

}
