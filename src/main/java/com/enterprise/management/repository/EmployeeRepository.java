package com.enterprise.management.repository;

import com.enterprise.management.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Javi on 27/6/17.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
