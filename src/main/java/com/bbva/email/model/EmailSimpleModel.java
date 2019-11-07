package com.bbva.email.model;

import org.springframework.stereotype.Component;

/**
 * Date :September 25,2019
 * 
 * @author SantiagoTH
 * @version 1.0
 *
 */

@Component
public class EmailSimpleModel {


	public EmailSimpleModel() {

	}

	private int id;
	private String from;
	private String subject;
	private String body;
	private String receiverEmail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getReceiverEmail() {
		return receiverEmail;
	}
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	
	
	@Override
	public String toString() {
		return "EmailSimpleModel [id=" + id + ", from=" + from + ", subject=" + subject + ", body=" + body
				+ ", receiverEmail=" + receiverEmail + "]";
	}


	

}
