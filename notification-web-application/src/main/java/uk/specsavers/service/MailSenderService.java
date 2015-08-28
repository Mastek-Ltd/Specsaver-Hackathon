package uk.specsavers.service;

import java.io.IOException;

import javax.activation.FileTypeMap;
import javax.activation.MimetypesFileTypeMap;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSenderService {

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Value("${specsavers.email.default.subject}")
	private String defaultEmailSubject;

	@Value("${specsavers.email.default.toAddress}")
	private String defaultEmailToAddress;

	@Value("${specsavers.email.default.messageText}")
	private String defaultEmailMessageText;

	public void sendEmail(String subject, String toAddress, String messageText) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
		messageHelper.setSubject(subject);
		messageHelper.setTo(toAddress);
		messageHelper.setText(messageText, true);
		mailSender.send(message);
	}

	public void sendEmail(String toAddress, String messageText) throws MessagingException {
		this.sendEmail(defaultEmailSubject, toAddress, messageText);
	}

	public void sendEmail(String toAddress) throws MessagingException {
		this.sendEmail(toAddress, defaultEmailMessageText);
	}

	public void sendEmail() throws MessagingException {
		this.sendEmail(defaultEmailToAddress);
	}
}
