package com.enterprise.management.service;

import com.enterprise.management.persistence.entity.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> getEmployeeList();
}
