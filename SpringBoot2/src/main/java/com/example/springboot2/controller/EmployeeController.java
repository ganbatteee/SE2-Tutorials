package com.example.springboot2.controller;

import com.example.springboot2.model.Employee;
import com.example.springboot2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employee")
    public String getAllEmployee(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employeeList";
    }
    @RequestMapping(value = "/employee/{id}")
    public String getEmployeeId(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeRepository.getReferenceById(id);
        model.addAttribute("employee", employee);
        return "employeeDetail";
    }

    @RequestMapping(value = "/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @RequestMapping(value = "/edit{id}", method = RequestMethod.GET)
    public String editEmployee(@RequestParam(name = "id") Long id, Model model) {
        Optional<Employee> employeeEdit = employeeRepository.findById(id);
        employeeEdit.ifPresent(employee -> model.addAttribute("employee", employee));
        return "editEmployee";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Long id, Model model) {
        employeeRepository.deleteById(id);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

}
