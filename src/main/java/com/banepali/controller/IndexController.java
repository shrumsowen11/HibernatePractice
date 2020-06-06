package com.banepali.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banepali.controller.dto.EmployeeDTO;
import com.banepali.service.EmployeeService;
import com.banepali.service.EmployeeServiceImpl;

//@Repository(helloController)  //we can use this but, as this is a model, we must use the "@Controller"
@Controller
public class IndexController {

	@Autowired
	private EmployeeService employeeService;

	// Method = GET
	// Action = login //calling this in website
	@GetMapping({"/","index"})
	public String indexPage() {
		return "index";
		// here, you do not give the extension,
		// otherwise that will be depended upon
		// that specific extension, which is not good practice
		/*
		 * @PostMapping("/login") public String aclass() { return "index";
		 * 
		 * redirect:/ "; --> this is used to send you to the another action mapping,
		 * instead of the .jsp file
		 */
	}

	@GetMapping("/dashboard")
	public String openDashboard() {
		return "dashboard";
		
	}
	
	@PostMapping("/dashboard")
	public String openDashboardPost() {
		return "redirect:/login";
	}
	
	@PostMapping("/login") // these are the buttons made in the .jsp file before
	public String loginPost(@RequestParam String temail, @RequestParam String password, Model model,
			HttpSession session) {

		// public String loginPost(HttpServletRequest req) {
		// "Using HttpsServletRequest" like this in code in not a good practice, use
		// @Requestparam
		// Similarly, for setting the data and sending them, we use the Model

		/*
		 * EmployeeDTO optionalEmplDTO = empl oyeeService.employeeLogin(temail,
		 * password);
		 * 
		 * if (optionalEmplDTO != null) { session.setAttribute("userData",
		 * optionalEmplDTO); return "dashboard";
		 * 
		 * } else { model.addAttribute("message",
		 * "Sorry, Incorrect Email or password."); return "index";
		 * 
		 * }
		 */		
		EmployeeDTO optionalEmplDTO = employeeService.employeeLogin(temail, password);

		if (optionalEmplDTO != null) {
			session.setAttribute("userData", optionalEmplDTO);
			// session.setAttribute("isLoggedIn", true);
			return "dashboard";
		} else {
			model.addAttribute("message", "Sorry, Incorrect Email or password.");
			return "redirect:/index";
		}
	}

	@GetMapping("/register")
	public String registerUser() {
		return "register";
	}

	@PostMapping("/rregister")
	public String registerUserPost(@ModelAttribute EmployeeDTO employeeDTO, Model model) throws IOException {

		// MultipartFile into byte[]
		byte[] bPhoto = employeeDTO.getPhoto().getBytes();
		employeeDTO.setbPhoto(bPhoto);

		String check = "good";
		List<String> previousUserIds = employeeService.findAllUserId();
		System.out.println("From IndexController \n\n\n" + previousUserIds);
		if (previousUserIds.contains(employeeDTO.getUserId())) {

			System.out.println(employeeDTO.getUserId());
			check = "Sorry,      \"" + employeeDTO.getUserId() + "\"     is already taken.";
		}

		if (check != "good") {
			model.addAttribute("message", check);
			return "register";

		} else {
			employeeService.save(employeeDTO);
			model.addAttribute("message", "You have succcessfully registered..");
			return "index";
		}

	}

	// <img src="image?sid =1"
	@GetMapping("/image")
	public void showImage(@RequestParam int eid, HttpServletResponse httpServletResponse) throws IOException {
		byte[] photo = employeeService.findImageById(eid);
		ServletOutputStream outputStream = httpServletResponse.getOutputStream();
		if (photo != null) {
			httpServletResponse.setContentType("image/png");
			outputStream.write(photo);
		} else {
			outputStream.write(new byte[] {});
		}
		outputStream.flush();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@GetMapping("/validateEmail")
	public String forgotPassword() {
		return "validateEmail";
	}

	@PostMapping("/validateEmail")
	public String validateEmail(@RequestParam String email, HttpSession session, Model model) {
		employeeService = new EmployeeServiceImpl();
		Optional<EmployeeDTO> employeeDTO = employeeService.optionalEmployeeByEmail(email);
		System.out.println("From IndexController" + email);
		if (employeeDTO.isPresent()) {
			session.setAttribute("userData", employeeDTO.get());
			System.out.println(email + " found. --> From IndexController");
			// "req.setAttribut()"//this only gives to the forwarded page
			return "getNewPasswords";
		} else {
			model.addAttribute("message", "Sorry, Email not found. Try again");
			return "validateEmail";
		}
	}

}
