package com.enterprise.management.persistence.repository;

import com.enterprise.management.persistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Javi on 27/6/17.
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
}
