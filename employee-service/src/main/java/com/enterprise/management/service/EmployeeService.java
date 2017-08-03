package com.enterprise.management.service;

import com.enterprise.management.persistence.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList();
}
