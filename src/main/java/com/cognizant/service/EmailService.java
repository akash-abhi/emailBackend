package com.cognizant.service;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.cognizant.entity.Email;
import com.cognizant.repository.EmailRepo;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private  TemplateEngine templateEngine;
	
	@Autowired
	private EmailRepo emailRepo;

//	public void sendEmail(Email email) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email.getEmail_to());
//        message.setSubject(email.getSubject());
//        message.setText(email.getBody());
//
//	javaMailSender.send(message);
//	
//	email.setPublicationDate(java.time.LocalDate.now().toString());
//	
//	this.emailRepo.save(email);
	
//}

	public void sendEmailWithHtmlTemplate(String email_to, String subject, String templateName, Context context) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
        Email email= new Email();
        email.setEmail_to(email_to);
        email.setSubject(subject);
        email.setPublicationDate(LocalDate.now());
        email.setPublicationTime(LocalTime.now());
        try {
            helper.setTo(email_to);
            helper.setSubject(subject);
            String htmlContent = templateEngine.process(templateName, context);
            helper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
            this.emailRepo.save(email);
        } catch (MessagingException e) {
        	System.out.println("Failed to send scheduled email: " + e.getMessage());
        }
		
	}
	
}

//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.mail.javamail.JavaMailSender;
//
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import org.springframework.scheduling.annotation.Scheduled;
//
//import org.springframework.stereotype.Component;
//
//import org.thymeleaf.TemplateEngine;
//
//import org.thymeleaf.context.Context;
//
//import com.cognizant.entity.Email;
//import com.cognizant.repository.EmailRepo;
//
//import javax.mail.MessagingException;
//
//import javax.mail.internet.MimeMessage;
//import javax.security.auth.Subject;
//
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//
//@Component
//
//public class EmailService {
//
//	@Autowired
//
//	private JavaMailSender javaMailSender;
//
//	@Autowired
//
//	private TemplateEngine templateEngine;
//	
//	@Autowired
//	private EmailRepo emailRepo;
//	
//
//	@Scheduled(cron = "0 00 12 ? * THU") // Schedule every Thursday at 11:30 AM
//
//	public void sendScheduledEmail() {
//		
////		Email email= new Email();
////		email.setEmail_to(email_to);
////		email.setSubject(subject);
////		email.setPublicationDate(LocalDate.now());
////		email.setPublicationTime(LocalTime.now());
//
//		try {
//
//			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//
//			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//
//			// Load HTML email template using Thymeleaf
//
//			Context context = new Context();
//
//			context.setVariable("name", "John Doe");
//
//			context.setVariable("message", "This is an automated email.");
//
//			String htmlContent = templateEngine.process("email-template", context);
//
//			helper.setTo("yogirajmalipatil486@gmail.com");
//
//			helper.setSubject("subject");
//
//			helper.setText(htmlContent, true);
//
//			javaMailSender.send(mimeMessage);
//			
//			 Email sentEmail = new Email();
//	           sentEmail.setEmail_to("yogirajmalipatil486@gmail.com");
//	           sentEmail.setSubject("Scheduled Email");
//	           sentEmail.setPublicationDate(LocalDate.now());
//	   		   sentEmail.setPublicationTime(LocalTime.now());
//	           emailRepo.save(sentEmail);
//
//			System.out.println("Scheduled email sent successfully!");
//
//
//		} catch (MessagingException e) {
//
//			System.out.println("Failed to send scheduled email: " + e.getMessage());
//
//		}
//
//	}
//
//}
