package uk.specsavers.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSenderService {

	@Autowired
	private JavaMailSenderImpl mailSender;

	public void sendEmail() throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
		messageHelper.setSubject("Dummy Subject");
		messageHelper.setTo("specsavers.hackathon@gmail.com");
		messageHelper.setText("Test message!!!", true);

		mailSender.send(message);

	}
}
