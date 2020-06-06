package com.banepali.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banepali.service.EmployeeService;
import com.banepali.service.EmployeeServiceImpl;

@Controller
public class PasswordUpdateController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getNewPasswords")
	public String getNewPasswords() {
		return "getNewPasswords";
	}
	@PostMapping("/getNewPasswords")
	public String getNewPasswords(@RequestParam String password1, @RequestParam String password2, @RequestParam String email, HttpSession session, Model model) {
		if (password1.equals(password2)) {

			employeeService = new EmployeeServiceImpl();
			String result = employeeService.updatePassword(email, password1);

			if (result.equals("Update Successful")) {
				model.addAttribute("message", "Password changed successfully.");
				return "index";
			} else {
				model.addAttribute("message", "Server Connection problem. Please Try Again.");
				return "getNewPasswords";
			}

		} else {
			model.addAttribute("message", "Passwords do not match.");
			return "getNewPasswords";
		}
	}

}
