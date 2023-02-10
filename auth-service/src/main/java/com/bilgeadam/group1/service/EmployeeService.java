package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.RegisterEmployeeRequestDto;
import com.bilgeadam.group1.dto.response.websitemanager.RegisterResponseDto;
import com.bilgeadam.group1.exception.AuthManagerException;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.manager.IEmployeeManager;
import com.bilgeadam.group1.mapper.IEmployeeMapper;
import com.bilgeadam.group1.repository.IEmployeeRepository;
import com.bilgeadam.group1.repository.entity.Employee;
import com.bilgeadam.group1.utility.CodeGenerator;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService extends ServiceManager<Employee,Long> {

    private final IEmployeeRepository employeeRepository;
    private final IEmployeeManager employeeManager;
    private final CompanyDirectorService companyDirectorService;

    public EmployeeService(IEmployeeRepository employeeRepository, IEmployeeManager employeeManager, CompanyDirectorService companyDirectorService) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
        this.employeeManager = employeeManager;
        this.companyDirectorService = companyDirectorService;
    }




    @Transactional
    public RegisterResponseDto registerEmployeeWithToken(RegisterEmployeeRequestDto dto){
        if(employeeRepository.findOptionalByEmail(dto.getEmail()).isPresent()){
            throw new AuthManagerException(ErrorType.DUPLICATE_EMAIL_ERROR);
        }
        try {
            Employee employee = IEmployeeMapper.INSTANCE.fromRequestToEmployee(dto);
            employee.setPassword(CodeGenerator.generateCode());
            save(employee);
            employeeManager.createEmployeeProfile(IEmployeeMapper.INSTANCE.fromEmployeeToEmployeeCreateRequest(employee));
            return IEmployeeMapper.INSTANCE.fromEmployeeToResponse(employee);
        } catch (Exception e){
            System.out.println(e.toString());
            throw new AuthManagerException(ErrorType.DUPLICATE_EMAIL_ERROR);
        }
    }




}
