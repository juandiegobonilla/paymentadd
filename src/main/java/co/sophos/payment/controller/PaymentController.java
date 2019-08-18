package co.sophos.payment.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sophos.payment.controller.client.ClientCustomerQuery;
import co.sophos.payment.controller.client.Customer;
import co.sophos.payment.controller.entities.Payment;
import co.sophos.payment.controller.entities.PaymentResponse;
import co.sophos.payment.controller.entities.Status;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@PostMapping("/add")
	public ResponseEntity<PaymentResponse> pay(
			String UUID,
			String channel,
			int amt,
			String bankCode,
			String id
	){
		
		PaymentResponse response = new PaymentResponse();
		
		response.setChannel(channel);
		response.setServerDate(new Date());
		response.setUUID(UUID);
		
		ClientCustomerQuery client = new ClientCustomerQuery();
		Customer customer = client.call(UUID, channel, id);
		customer.setId(id);
		response.setCustomer(customer);
		
		Payment payment = new Payment();
		payment.setAmt(amt);
		payment.setDesc("PAGOD DE TARJETA");
		payment.setFee(1000);
		payment.setVendor("MASTER CARD");
		payment.setBankCode(bankCode);
		response.setPayment(payment);

		Status status = new Status();
		status.setDescCode("OK");
		status.setSeverity("INFO");
		status.setStatusCode(0);
		response.setStatus(status);

		return ResponseEntity.ok(response);

	}
	
}
