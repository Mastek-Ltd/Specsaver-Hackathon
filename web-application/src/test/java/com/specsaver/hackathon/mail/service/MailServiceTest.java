package com.specsaver.hackathon.mail.service;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.specsaver.hackathon.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
public class MailServiceTest
{

	@Autowired
	private MailSenderService	mailSenderService;

	@Test
	public void testMailSend() throws MessagingException
	{
		String toAddr = "krishna.khandage@gmail.com";
		String fromAddr = "krishna.khandage@gmail.com";

		// email subject
		String subject = "Hello the first message of the application.";

		// email body
		String body = "There you go.. You got an email.. Great achievement.." + "" + " \nRegards" + "\nKK";
		mailSenderService.sendEmail(toAddr, fromAddr, subject, body);
	}
}