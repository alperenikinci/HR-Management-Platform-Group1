package com.bilgeadam.group1.service;

import com.bilgeadam.group1.repository.IEmployeeRepository;
import com.bilgeadam.group1.repository.entity.Employee;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService extends ServiceManager<Employee,Long> {

    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
    }


}
