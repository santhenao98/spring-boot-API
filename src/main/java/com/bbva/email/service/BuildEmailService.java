package com.bbva.email.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.bbva.email.model.EmailModel;
import com.bbva.email.model.EmailSimpleModel;

/**
 * 
 * @author SantiagoTH
 *
 */

@Service
public class BuildEmailService {

	@Autowired
	private SendEmailService sendEmailService;

	@Autowired
	private EmailSimpleModel emailSimpleModel;

	public BuildEmailService() {

	}

	public void buildEmail(EmailModel emailModel)
			throws MailException, MessagingException, IOException, URISyntaxException {

		emailModel.setBody(readTemplateHTML("template.html", StandardCharsets.UTF_8).replace("<%BODY%>",emailModel.getBody()));

		for (String email : emailModel.getReceiverEmail()) {
			emailSimpleModel.setReceiverEmail(email);
			emailSimpleModel.setBody(emailModel.getBody());
			emailSimpleModel.setSubject("Hackathon - BBVA Colombia");

			sendEmailService.buildEmail(emailSimpleModel);
		}

	}

	public static String readTemplateHTML(String path, Charset encoding) throws IOException, URISyntaxException {
		
		ClassLoader classLoader = new BuildEmailService().getClass().getClassLoader();

		File file = new File(classLoader.getResource(path).getFile());
		
		//File is found
        System.out.println("File Found : " + file.exists());

		byte[] encoded = Files.readAllBytes(file.toPath());

		return new String(encoded, encoding);
	}

}
