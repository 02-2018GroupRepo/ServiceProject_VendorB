package bootcamp

import bootcamp.model.invoice.Invoice
import bootcamp.model.order.Order
import bootcamp.service.InventoryService
import spock.lang.Specification

class TestSpec extends Specification {
	
	def "Test returning an invoice"(){
		
		given: "an order"
		Order order = new Order();
		order.setId(2);
		order.setNumber_available(20);
		println order.getId();
		
		and: "a InventoryService"
		InventoryService iServ = Mock(InventoryService.class);
		
		when: "an order is passed to the controller"
		iServ.getOrder(order)>>order;
		
		then: "an invoice is received"
		//invoice.getId() == 2
		//invoice.getCount() == 20
	}
}
