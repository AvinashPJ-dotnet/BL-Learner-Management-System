package com.bl.lms.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bl.lms.model.User;

@Component
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendOtpMessage(User user, int OTP) throws MessagingException {
	
		MimeMessage message = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(message, true);

	        helper.setTo(user.getEmailId());

	        String subject = "Here's your One Time Password (OTP) - Expire in 5 minutes!";
	        helper.setSubject(subject);

	        String content = "<p>Hello " + user.getFirstName() + "</p>"
	                + "<p>For security reason, you're required to use the following "
	                + "One Time Password to login:</p>"
	                + "<p><b>" + OTP + "</b></p>"
	                + "<br>"
	                + "<p>Note: this OTP is set to expire in 5 minutes.</p>";
	        helper.setText(content, true);

	        javaMailSender.send(message);
   }
	
	  
}
