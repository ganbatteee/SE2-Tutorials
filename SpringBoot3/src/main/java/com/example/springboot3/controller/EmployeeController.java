package com.example.springboot3.controller;

import com.example.springboot3.model.Company;
import com.example.springboot3.model.Employee;
import com.example.springboot3.repository.CompanyRepository;
import com.example.springboot3.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping(value = "/list")
    public String getAllEmployee(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employeeList";
    }
    @RequestMapping(value = "/list/{id}")
    public String getEmployeeId(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeRepository.getReferenceById(id);
        model.addAttribute("employee", employee);
        return "employeeDetail";
    }

    @RequestMapping(value = "/add")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        model.addAttribute("employee", employee);
        return "addEmployee";
    }

    @RequestMapping(value = "/edit{id}", method = RequestMethod.GET)  //method = RequestMethod.GET
    public String editEmployee(@RequestParam(value = "id") Long id, Model model) {
        Optional<Employee> employeeEdit = employeeRepository.findById(id);
        employeeEdit.ifPresent(employee -> model.addAttribute("employee", employee));
        return "editEmployee";
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.GET)  //method = RequestMethod.GET
    public String deleteEmployee(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeRepository.getById(id);
        employeeRepository.delete(employee);
        return "redirect:/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST) //method = RequestMethod.POST
    public String save(@RequestParam(value = "id", required = false)Long id, @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            if (id == null)
                return "addEmployee";
            return "editEmployee";
        }
            employee.setId(id);
            employeeRepository.save(employee);

        return "redirect:/list";
    }

    @RequestMapping("/search")
    public String searchEmployee(Model model, @RequestParam(value = "name") String name) {
        List<Employee> employees = employeeRepository.findByNameContaining(name);
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    @RequestMapping("/sort/asc")
    public String sortEmployeeAsc(Model model) {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    @RequestMapping("/sort/desc")
    public String sortEmployeeDesc(Model model) {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        model.addAttribute("employees", employees);
        return "employeeList";
    }
}
