package com.banepali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.banepali.controller.dto.EmployeeDTO;
import com.banepali.service.EmployeeService;

@Controller
public class DataTableController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/deletePerson")
	public String deleteData(@RequestParam String email) {
		employeeService.deleteByEmail(email);
		return "redirect:/showAllEmployees";
	}

	@GetMapping("/editPerson")
	public String editData(@RequestParam String userId, Model model) {
		EmployeeDTO employeeDTO = employeeService.employeeByUserId(userId);
		model.addAttribute("message", "Please edit the fields you like to update.");
		model.addAttribute("employeeEntity", employeeDTO);
		return "editEmploeeData";
	}

	@GetMapping("/updateEmployeeData")
	public String updateData(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
		System.out.println("DataTableController " + employeeDTO);
		

		employeeService.updateEmployee(employeeDTO);
		model.addAttribute("message", "You have successfully updated.");
		return "redirect:/showAllEmployees";

	}
}
