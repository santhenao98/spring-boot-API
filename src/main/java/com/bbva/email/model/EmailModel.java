package com.bbva.email.model;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Date :September 25,2019
 * 
 * @author SantiagoTH
 * @version 1.0
 *
 */

@Component
public class EmailModel {


	public EmailModel() {

	}


	private String body;
	private List<String> receiverEmail;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public List<String> getReceiverEmail() {
		return receiverEmail;
	}
	public void setReceiverEmail(List<String> receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	
	
	@Override
	public String toString() {
		return "EmailModel [body=" + body + ", receiverEmail=" + receiverEmail + "]";
	}
	
	


	

}
