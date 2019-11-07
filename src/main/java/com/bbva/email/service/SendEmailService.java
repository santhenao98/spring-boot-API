package com.bbva.email.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bbva.email.model.EmailSimpleModel;

/**
 * 
 * @author SantiagoTH
 *
 */
@Service
public class SendEmailService {

	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	Environment env;

	@Autowired
	public SendEmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * This method is used to send mail that contains attachments.
	 * 
	 * @param User         user
	 * @param String       affair
	 * @param String       body
	 * @param List<String> nameAttachment
	 * @throws MailException
	 * @throws MessagingException
	 * @throws IOException
	 */


	public void getMimeMessage(EmailSimpleModel emailSimpleModel) throws MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("mensajeria.online.prueba@gmail.com");
		helper.setTo(emailSimpleModel.getReceiverEmail());
		helper.setSubject(emailSimpleModel.getSubject());
		helper.setText(emailSimpleModel.getBody(), true);
		javaMailSender.send(mimeMessage);

	}
	
	public void buildEmail(EmailSimpleModel emailSimpleModel) throws MessagingException {

		getMimeMessage(emailSimpleModel);
		
	}
	
}
