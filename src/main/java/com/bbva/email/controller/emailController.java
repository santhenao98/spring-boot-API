package com.bbva.email.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbva.email.model.EmailModel;
import com.bbva.email.service.BuildEmailService;



@Controller
@RequestMapping(value = "/CustomerLakeNotification")
public class emailController {
	
	/*
	 * 200
	 * 409
	 * 500
	 * 404
	 * 
	 * */
	
	@Autowired
	private BuildEmailService buildEmailService;
	
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseEntity persistPerson(@RequestBody EmailModel emailModel) throws MailException, MessagingException, IOException, URISyntaxException {
		
       System.out.println("llegue al post: "+emailModel.toString());
       buildEmailService.buildEmail(emailModel);
       
       
       return new ResponseEntity(HttpStatus.OK);
    }
	
	

}
