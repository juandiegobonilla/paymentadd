package co.sophos.payment.controller.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class ClientCustomerQuery {

	public Customer call(String UUID, String channel, String id) {
		String uri = "http://customerquery:9090/api/customer/query";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("UUID", UUID);
		params.put("clientDate", "12/12/2019");
		params.put("channel", channel);
		params.put("id", id);
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, CustomerResponse.class, params).getCustomer();
	}
}
