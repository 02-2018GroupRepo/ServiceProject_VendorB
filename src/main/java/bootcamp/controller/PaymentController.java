package bootcamp.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.model.payment.Payment;
import bootcamp.service.PaymentService;

@RestController
public class PaymentController {
	@Autowired
	private PaymentService PService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	//change this to take in a Payment object not a BigDecimal
	@RequestMapping(value = "/payment", method=RequestMethod.POST)
	public Boolean getPayment(@RequestBody Payment pay) {
		log.info("Adding money to total money");
		return PService.getPayment(pay);
	}
}
