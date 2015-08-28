package uk.specsavers.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import uk.specsavers.service.RetrieveCustomerDetailsService;
import uk.specsavers.ui.CustomerDetails;

@Controller
public class LoginController {

	final static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private RetrieveCustomerDetailsService customerDetailsService;

	@Autowired
	private JavaMailSenderImpl mailSender;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView initializeApplication(HttpServletRequest request,
			HttpServletResponse httpServletResponse) throws MessagingException {
		logger.debug("Redirecting to index page");

		ModelAndView modelAndView = new ModelAndView();

		sendEmail();

		modelAndView.setViewName("loginform");

		return modelAndView;
	}

	private void sendEmail() throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
		messageHelper.setSubject("Dummy Subject");
		messageHelper.setTo("specsavers.hackathon@gmail.com");
		messageHelper.setText("Test message!!!", true);

		mailSender.send(message);

	}

	@RequestMapping(value = "/validateUser", method = RequestMethod.POST)
	public ModelAndView validateUser(HttpServletRequest request,
			HttpServletResponse httpServletResponse,
			@RequestParam("username") String username,
			@RequestParam("password") String password, String roleType) {
		logger.debug("Redirecting to customer details page if audiologist else show user profile");

		ModelAndView modelAndView = new ModelAndView();

		if (roleType.equalsIgnoreCase("Audiologist")) {
			modelAndView.setViewName("redirect:/customerdetails");
		}

		else if (roleType.equalsIgnoreCase("Customer")) {
			CustomerDetails customerDetails = customerDetailsService
					.fetchCustomerDetailsById(username);
			modelAndView.addObject("customerDtl", customerDetails);
			modelAndView.setViewName("customerprofile");
		}

		else {
			modelAndView.setViewName("loginform");
		}

		return modelAndView;
	}

}
