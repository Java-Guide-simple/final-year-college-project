package com.nri.euth.app.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nri.euth.app.entities.User;
import com.nri.euth.app.service.UserService;

/*
 * This controller is responsible for 
 * Load Registration Form
 * new registration (save)
 * Load Login Form
 * login process (user validation) after landing to OTP generation Page
 * logout implementation
 * */

@Controller
public class UserController {
	
	
	
	
	@Autowired
	private UserService userService;
	
	
	/*
	 * Load Registration Page
	 * */
	@RequestMapping(path="/showReg")
	public String showRegistration(ModelMap modelMap) {
		
		
		modelMap.addAttribute("error", " ");
		return "login/newRegistration";
		
	}
	
	/*
	 * save registration Details 
	 * after successfully registration and landing to the registrationSuccess Page
	 * */
	
	@RequestMapping(path="/saveReg")
	public String saveNewRegistration(@ModelAttribute("user") User user,ModelMap modelMap) {
		
		User registeredNewUser = userService.registeredNewUser(user);
		if(registeredNewUser == null) {
			modelMap.addAttribute("error", ("Failed ! ......."+user.getEmailId() + "  mail Id already registered "));
			return "login/newRegistration";
		}else {
			modelMap.addAttribute("success","Registration Successfully !!!!! ....");
			modelMap.addAttribute("newUserName", registeredNewUser.getEmailId() +" is your username to login you account . We have generated Employee Id for you . To check your Employee Id Login your account .");
			return "login/registrationSuccess";
		}
		
	}
	
	/*Load Login form*/
	
	@RequestMapping(path="/showLogin")
	public String showLogin() {
		
		return "login/login";
		
	}
	
	
	/*
	 * verifying username and password
	 * if Credentials are valid then landing to generateOTP Page
	 * */
	
	@RequestMapping("/verifyLogin")
	public String  dashBoard(@RequestParam("email") String emailId,@RequestParam("password") String password ,ModelMap modelMap,HttpServletRequest request) throws Exception {
		User loginCredentials = userService.login(emailId, password);
		
		if(loginCredentials==null) {
			modelMap.addAttribute("error", "invalid credentials");
			return "login/login";
		}if(loginCredentials!=null && !(loginCredentials.getPassword().equals(password))) {
			modelMap.addAttribute("error", "incorrect password");
			return "login/login";
		}else {

            // session management
			HttpSession session = request.getSession(true);
			session.setAttribute("username", emailId);
			session.setAttribute("profile", loginCredentials);
			modelMap.addAttribute("proceed", "  Verify e-Authentication ");
			return "login/generateOTP";
		}
		
		
	}
	
	
	/*
	 * logout logged account
	 * after successful logout landing to login page.
	 * 
	 * */
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession(false);
	     

	     
	      if(session != null) {
	    	session.removeAttribute("username");
	        session.invalidate();
	      }
	
		return "login/login";
	}
}
