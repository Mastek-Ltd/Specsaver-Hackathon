package uk.specsavers.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.specsavers.service.RetrieveCustomerDetailsService;
import uk.specsavers.ui.CustomerDetails;

@Controller
public class CustomerDetailsController {

	final static Logger logger = Logger.getLogger(CustomerDetailsController.class);

	@Autowired
	private RetrieveCustomerDetailsService retrieveCustomerDetailsService; 
	

	@RequestMapping(value = "/customerdetails", method = RequestMethod.GET)
	public ModelAndView validateUser(HttpServletRequest request,HttpServletResponse httpServletResponses) {
		

		ModelAndView modelAndView = new ModelAndView();
		
		List<CustomerDetails>   customerDetails=   retrieveCustomerDetailsService.fetchAllCustomers();
		
		modelAndView.addObject("customers", customerDetails);

		modelAndView.setViewName("customerdetails");

		return modelAndView;
	}
	
	@RequestMapping(value = "/processNotifications", method = RequestMethod.POST)
	public void processNotifications(HttpServletRequest request,HttpServletResponse httpServletResponses) {
		
		retrieveCustomerDetailsService.processNotifications();
		
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView dashboard(HttpServletRequest request,HttpServletResponse httpServletResponses) {
		

		ModelAndView modelAndView = new ModelAndView();
	
		modelAndView.setViewName("home");

		return modelAndView;
	}

}
