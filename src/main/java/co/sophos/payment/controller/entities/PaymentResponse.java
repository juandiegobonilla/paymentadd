package co.sophos.payment.controller.entities;

import java.io.Serializable;
import java.util.Date;

import co.sophos.payment.controller.client.Customer;


public class PaymentResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String UUID;
	private String channel;
	private Date serverDate;
	private Status status;
	private Payment payment;
	private Customer customer;
	

	public PaymentResponse() {}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Date getServerDate() {
		return serverDate;
	}
	public void setServerDate(Date serverDate) {
		this.serverDate = serverDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
