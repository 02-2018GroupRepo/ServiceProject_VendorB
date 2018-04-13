package bootcamp

import bootcamp.model.inventory.InventoryItem
import bootcamp.model.products.Product
import bootcamp.service.InventoryService
import spock.lang.Specification


class InventoryServiceSpec extends Specification {
	
	def "Adding a Product List to the Inventory List"(){
		
		given: "An InventoryService"
		InventoryService inventoryService = new InventoryService()
		
		and: "an empty inventory list"
		
		inventoryService.inventoryList = new ArrayList<Product>();
		
		and: "A list of 1 product"
		List<Product> productList = new ArrayList<>();
		Product p1 = new Product();
		productList.add(p1);

		when: "inventory is received"
		inventoryService.receiveInventory(productList);
		
		then: "The inventory list count should be 1"
		inventoryService.inventoryList.size() == 1;
		
		and: "The inventorylist should contain the product p1"
		inventoryService.inventoryList.contains(p1) == true;
		
	}
	   
	
	def "Looking through an inventory list"(){
		given: "An inventory item list"
		List<InventoryItem> list = new ArrayList<InventoryItem>();
		list.add(new InventoryItem(1, 1.50, 15));
		list.add(new InventoryItem(2, 2.0, 3));
		list.add(new InventoryItem(3, 1.0, 5));
		
		when: "the database is low on something"
		int id = 2;
		
		then: "look through the list for the item"
		double price = 0.0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id)
				price = list.get(i).getRetail_price();
		}
		
		double test = 2.0;
		test == price;
	}

}
