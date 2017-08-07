package com.enterprise.management.controller;

import com.enterprise.management.annotation.RestBaseController;
import com.enterprise.management.persistence.entity.Employee;
import com.enterprise.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Javi on 26/6/17.
 */
@RestBaseController(value = "/employee", description = "Operations about employee")
public class EmployeeController extends BaseController {

    @Autowired
    private EmployeeService employeeService;

    private static final String clientUrl = "http://localhost:3000";


    @RequestMapping(method = RequestMethod.POST, path="/employee/add", produces = applicationJson)
    public @ResponseBody
        ResponseEntity<?> saveEmployee (@RequestBody Employee employee) {

        employee = employeeService.saveEmployee(employee);
        Resource resource = new Resource<>(employee);
        resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(EmployeeController.class)
                .getEmployeeDetail(employee.getId())).withSelfRel());
        return ResponseEntity.ok(resource);
    }

    @CrossOrigin(origins = clientUrl)
    @RequestMapping(method = RequestMethod.GET, path="/employee/all", produces = applicationJson)
    public @ResponseBody
    ResponseEntity<?> getAllEmployees(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size",required = false, defaultValue = "100") Integer size) {

        Page<Employee> employeeListPaged = null;
        employeeListPaged = employeeService.getEmployeeList(page,size);

        Resources resources = new Resources<>(employeeListPaged);

        for(Employee employee : employeeListPaged) {
            Link detail = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(EmployeeController.class)
                    .getEmployeeDetail(employee.getId())).withSelfRel();
            employee.setLink(detail);

        }
        return ResponseEntity.ok(resources);
    }

    @CrossOrigin(origins = clientUrl)
    @RequestMapping(method = RequestMethod.GET, path="/employee/detail", produces = applicationJson)
    public @ResponseBody
    ResponseEntity<?> getEmployeeDetail(@RequestParam("id") Long employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        Resource resource = new Resource<>(employee);
        return ResponseEntity.ok(resource);

    }
}
