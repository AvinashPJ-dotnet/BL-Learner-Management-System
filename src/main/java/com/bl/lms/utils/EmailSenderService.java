package com.bl.lms.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bl.lms.model.HiringCandidate;
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
				+ "<p>For security reason, you're required to use the following " + "One Time Password to login:</p>"
				+ "<p><b>" + OTP + "</b></p>" + "<br>" + "<p>Note: this OTP is set to expire in 5 minutes.</p>";
		helper.setText(content, true);
		javaMailSender.send(message);

	}

	public void sendJobOffer(HiringCandidate user, String link) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(user.getEmailId());

		String subject = "Job offer Notification";
		helper.setSubject(subject);

		String content = "<p>Hello " + user.getFirstName() + "</p>" + "<p>Are you interested to join the course </p>"
				+ "<p>Reply to this mail by clicking the reply link below</p>" + "<p><a href=\"" + link
				+ "\">reply</a></p>";
		helper.setText(content, true);
		javaMailSender.send(message);

	}

//	public void sendEmail(String recipientEmail, String link)
//	        throws MessagingException, UnsupportedEncodingException {
//	    MimeMessage message = mailSender.createMimeMessage();              
//	    MimeMessageHelper helper = new MimeMessageHelper(message);
//	     
//	    helper.setFrom("contact@shopme.com", "Shopme Support");
//	    helper.setTo(recipientEmail);
//	     
//	    String subject = "Here's the link to reset your password";
//	     
//	    String content = "<p>Hello,</p>"
//	            + "<p>You have requested to reset your password.</p>"
//	            + "<p>Click the link below to change your password:</p>"
//	            + "<p><a href=\"" + link + "\">Change my password</a></p>"
//	            + "<br>"
//	            + "<p>Ignore this email if you do remember your password, "
//	            + "or you have not made the request.</p>";
//	     
//	    helper.setSubject(subject);
//	     
//	    helper.setText(content, true);
//	     
//	    mailSender.send(message);
//	}

}
