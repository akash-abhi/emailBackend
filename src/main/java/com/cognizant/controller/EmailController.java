package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.cognizant.entity.Email;
import com.cognizant.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	 private EmailService senderService;
	
	
	@PostMapping("/send-html-email")
    public String sendHtmlEmail(@RequestBody Email email) {
        Context context = new Context();
        context.setVariable("message", email.getBody());

        senderService.sendEmailWithHtmlTemplate(email.getEmail_to(), email.getSubject(), "email-template", context);
        return "Email sent successfully!";
    }

}
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cognizant.service.EmailService;
//
//@RestController
//@RequestMapping("/email")
//public class EmailController {
//
//	@Autowired
//	private EmailService emailScheduler;
//
//	@PostMapping("/send")
//	public String sendScheduledEmailManually() {
//		emailScheduler.sendScheduledEmail(); // Call the method that sends the scheduled email
//		return "Scheduled email sent manually!";
//	}
//}