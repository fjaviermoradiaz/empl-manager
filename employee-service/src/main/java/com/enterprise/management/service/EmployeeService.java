package com.enterprise.management.service;

import com.enterprise.management.persistence.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList();

    Page<Employee> getEmployeeList(int page, int size);

    Employee saveEmployee(Employee employee);

    Employee findEmployeeById(Long id);
}
