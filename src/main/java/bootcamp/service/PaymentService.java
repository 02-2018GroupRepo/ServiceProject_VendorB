package bootcamp.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.dao.PaymentDao;
import bootcamp.model.payment.Payment;

@Component
public class PaymentService {
	
	@Autowired
	private PaymentDao PayDao;
	
	private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

	//change to take in an payment object
	public Boolean getPayment(Payment pay) {
		log.info("Payment Processing");
		return PayDao.getPayment(pay);
	}

	public boolean makePayment(int choice_supplier, double paymentTotal) {
		// TODO Auto-generated method stub
		return false;
	}

}
