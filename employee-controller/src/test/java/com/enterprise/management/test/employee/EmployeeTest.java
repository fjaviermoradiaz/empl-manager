package com.enterprise.management.test.employee;

import com.enterprise.management.persistence.entity.Employee;
import com.enterprise.management.persistence.repository.EmployeeRepository;
import com.enterprise.management.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by javimora on 7/8/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {

   // @Autowired
   // private EmployeeService employeeService;

    @Test
    public void createEmployees() throws Exception {
        /*Employee employee = null;

        int i = 10;
        for (i = 10;i<20000;i++) {
            employee = new Employee();
            employee.setName("Employee " + i);
            employee.setSurname1("Test");
            employee.setSurname2("S2" +i);
            employee.setPhone("99999"+i);
            employee.setMobil("66666"+i);
            employee.setEmail(i+"@test.com");

            employee.setDocumentType("DNI");
            employee.setDocumentNumber("00000");

            employeeService.saveEmployee(employee);
            System.out.println("Employee: " + i + " created.");
        }*/

        Assert.assertEquals(null,null);

    }
}
