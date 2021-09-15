package com.nri.euth.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nri.euth.app.entities.User;
import com.nri.euth.app.service.OTPService;
import com.nri.euth.app.utility.EmailService;

/*
 * This Controller is responsible for Generate OTP 
 * send OTP with the help of EmailService Class Object
 * validate the OTP 
 * */

@Controller
public class OTPController {

	@Autowired
	public OTPService otpService;

	@Autowired
	public EmailService emailService;

	/*
	 * Generate OTP with the help of OTPService class Object
	 * Send OTP to verified user mail with the help of EmailService Calss
	 * */
	@GetMapping("/generateOtp")
	public String generateOTP(ModelMap modelMap ,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("username");
		
		int otp = otpService.generateOTP(userName);

		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("user", userName);
		replacements.put("otpnum", String.valueOf(otp));

		emailService.sendOtpMessage(userName, "OTP -NRI - Employee Portal"," OTP is  "+String.valueOf(otp) + ".  This OTP is valid only for 4 min . Do not reply ,This is Computer generated Mail .");
		modelMap.addAttribute("msg", "We have sent OTP in Your Registered Mail Id valid only for 4 min");
		return "login/otpValidationPage";
	}

	
	/*
	 * validate OTP
	 * if OTP is valid Landing to the Account
	 *  
	 * */
	
	@RequestMapping(value = "/validateOtp")
	public String validateOtp(@RequestParam("otpnum") int otpnum,HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("username");
		

		

		if (otpnum >= 0) {

			int serverOtp = otpService.getOtp(userName);
			System.out.println(serverOtp);
			if (serverOtp > 0) {
				if (otpnum == serverOtp) {
					otpService.clearOTP(userName);
					User profile = (User) session.getAttribute("profile");
					modelMap.addAttribute("profile", profile);
					return "login/dashboard";
				} else {

					modelMap.addAttribute("FAIL", "Entered Otp is NOT valid. Please Retry!");
					return "login/otpValidationPage";
				}
			} else {
				modelMap.addAttribute("FAIL", "Entered Otp is NOT valid. Please Retry!");
				return "login/otpValidationPage";
			}
		} else {
			modelMap.addAttribute("FAIL", "Entered Otp is NOT valid. Please Retry!");
			return "login/otpValidationPage";
		}
	}
}