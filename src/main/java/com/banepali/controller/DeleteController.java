/*
 * package com.banepali.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.banepali.service.EmployeeService;
 * 
 * 
 * 
 * @Controller public class DeleteController {
 * 
 * @Autowired private EmployeeService employeeService;
 * 
 * @GetMapping("/delete") public String deleteUser(@RequestParam String email,
 * Model model) {
 * 
 * 
 * employeeService.deleteByEmail(email);
 * return"redirect:/showAllEmployeesServlet"; }
 * 
 * }
 */