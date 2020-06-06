package com.banepali.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

import com.banepali.controller.dto.EmployeeDTO;
import com.banepali.service.EmployeeService;



@Controller
public class DashboardController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/showAllContactInfo")
	public String contactUsPost(Model model) {
		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
		employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		return "showAllContacts";	
	}
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * binder.registerCustomEditor(Date.class, new CustomDateEditor(new
	 * SimpleDateFormat("yyyy-MM-dd"), true, 10)); }
	 */



@GetMapping("/logout")
public String logout(HttpSession session,Model model) {
	//session = model.addAttribute(attributeValue)
	/*
	 * doing "false" --> do not make a new session here, rather gives me the old session.-->
	 * but if you do not have an old session, it will automatically make a new
	 * session for you, but still it keeps the value of the
	 *  variable "session" --> NULL
	 */
	//if(session != null) {
		session.invalidate();
	//}
	return "logout";
}

@GetMapping("/showProfile")
public String showProfile(@RequestParam String email, HttpSession session,Model model) {

	EmployeeDTO employeeDTO = new EmployeeDTO();
	employeeDTO = employeeService.employeeByEmail(email);
	model.addAttribute("entity", employeeDTO);
	return "showProfile";

}
@InitBinder
public void initBinder(WebDataBinder binder) {
	binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
}

@GetMapping("/showAllEmployees")
public String showAllEmployees(Model model) {

	List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
	employeeDTOs = employeeService.findAll();
	model.addAttribute("employeeList", employeeDTOs);
	return "showAllData";

}

@GetMapping("/showAllEmployeesBlockTime")
public String showAllEmployeesBlockTime(Model model) {
	List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
	employeeList = employeeService.findAll();
	model.addAttribute("employeeList", employeeList);
	return "showAllDataBlockTime";

}


}