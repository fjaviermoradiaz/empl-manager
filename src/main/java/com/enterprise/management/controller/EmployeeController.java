package com.enterprise.management.controller;

import com.enterprise.management.entity.Employee;
import com.enterprise.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Javi on 26/6/17.
 */
@Controller
@RequestMapping(path="/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //TODO: Pendiente de implementar HATEOAS y usar Swagger para las pruebas
    //TODO: Cambiar GetMapping por RequestMapping
    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {

        Employee employee = new Employee(name,email);
        employeeRepository.save(employee);
        return "Saved employee: " + name;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
