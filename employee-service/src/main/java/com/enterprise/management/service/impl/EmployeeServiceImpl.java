package com.enterprise.management.service.impl;

import com.enterprise.management.persistence.entity.Employee;
import com.enterprise.management.persistence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by javimora on 3/8/17.
 */
@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeList() {
        return (List<Employee>) employeeRepository.findAll();
    }
}
