package com.enterprise.management.controller;

import com.enterprise.management.repository.EmployeeRepository;
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
@Controller
@RequestMapping(path="/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //TODO: Pendiente de implementar HATEOAS y usar Swagger para las pruebas
    //TODO: Cambiar GetMapping por RequestMapping
    @RequestMapping(method = RequestMethod.POST, path="/add", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public @ResponseBody
        ResponseEntity<?> addEmployee (@RequestParam String name, @RequestParam String email) {

        Employee employee = new Employee(name,email);
        employee = employeeRepository.save(employee);
        Resource resource = new Resource<>(employee);
        resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(EmployeeController.class).addEmployee(name,email)).withSelfRel());
        return ResponseEntity.ok(resource);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, path="/all", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public @ResponseBody
    ResponseEntity<?> getAllEmployees() {
        List<Employee> currentAgreemnts = (List<Employee>) employeeRepository.findAll();
        Resources resources = new Resources<>(currentAgreemnts);
        resources.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(EmployeeController.class).getAllEmployees()).withSelfRel());

        return ResponseEntity.ok(resources);
    }
}
