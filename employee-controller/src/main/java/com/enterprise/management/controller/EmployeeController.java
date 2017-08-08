package com.enterprise.management.controller;

import com.enterprise.management.annotation.RestBaseController;
import com.enterprise.management.persistence.entity.Employee;
import com.enterprise.management.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Javi on 26/6/17.
 */
@RestBaseController(value = "/employee", description = "Operations about employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST, path="/employee/add", produces = "application/json")
    public @ResponseBody
        ResponseEntity<?> addEmployee (@RequestParam String name, @RequestParam String email) {

        Employee employee = new Employee(name,email);
      //  employee = employeeService.save(employee);
        Resource resource = new Resource<>(employee);
        resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(EmployeeController.class).addEmployee(name,email)).withSelfRel());
        return ResponseEntity.ok(resource);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, path="/employee/all", produces = "application/json")
    public @ResponseBody
    ResponseEntity<?> getAllEmployees() {
        List<Employee> currentAgreemnts = employeeService.getEmployeeList();
        Resources resources = new Resources<>(currentAgreemnts);
        resources.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(EmployeeController.class).getAllEmployees()).withSelfRel());

        return ResponseEntity.ok(resources);
    }
}
