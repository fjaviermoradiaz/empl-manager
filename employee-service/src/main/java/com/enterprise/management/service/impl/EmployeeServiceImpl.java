package com.enterprise.management.service.impl;

import com.enterprise.management.persistence.entity.Employee;
import com.enterprise.management.persistence.repository.EmployeeRepository;
import com.enterprise.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by javimora on 3/8/17.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeList() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getEmployeeList(int page, int size) {
        return employeeRepository.findAll(new PageRequest(page,size));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findOne(id);
    }


}
