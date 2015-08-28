package com.specsaver.hackathon.mail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSenderService
{

	@Autowired
	private JavaMailSender	javaMailSender;

	public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) throws MessagingException
	{

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
		messageHelper.setSubject(subject);
		messageHelper.setTo(toAddress);
		messageHelper.setText(msgBody, true);

		javaMailSender.send(message);
	}
}