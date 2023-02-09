package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.RegisterRequestDto;
import com.bilgeadam.group1.dto.response.RegisterResponseDto;
import com.bilgeadam.group1.dto.response.SummarisedFindAllResponse;
import com.bilgeadam.group1.exception.CompanyManagerException;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.manager.IEmployeeManager;
import com.bilgeadam.group1.mapper.ICompanyManagerProfileMapper;
import com.bilgeadam.group1.repository.ICompanyProfileRepository;
import com.bilgeadam.group1.repository.entity.CompanyManagerProfile;
import com.bilgeadam.group1.utility.CodeGenerator;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyManagerProfileService extends ServiceManager<CompanyManagerProfile,Long> {

    private final ICompanyProfileRepository companyProfileRepository;
    private final ICompanyManagerProfileMapper companyManagerProfileMapper;
    private final IEmployeeManager employeeManager;

    public CompanyManagerProfileService(ICompanyProfileRepository companyProfileRepository, ICompanyManagerProfileMapper companyManagerProfileMapper, IEmployeeManager employeeManager){
        super(companyProfileRepository);
        this.companyProfileRepository = companyProfileRepository;
        this.companyManagerProfileMapper = companyManagerProfileMapper;
        this.employeeManager = employeeManager;
    }

    @Transactional
    public RegisterResponseDto registerEmployee(RegisterRequestDto dto){

        if (companyProfileRepository.findOptionalByName(dto.getName()).isPresent()){
            throw  new CompanyManagerException(ErrorType.NAME_DUPLICATE);
        }
        CompanyManagerProfile companyManagerProfile= ICompanyManagerProfileMapper.INSTANCE.toCompanyManager(dto);
        try {
            companyManagerProfile.setActivationCode(CodeGenerator.genarateCode());
            save(companyManagerProfile);
            employeeManager.createEmployee(ICompanyManagerProfileMapper.INSTANCE.toNewCreateEmployeeDto(companyManagerProfile));
            return ICompanyManagerProfileMapper.INSTANCE.toRegisterResponseDto(companyManagerProfile);
        }catch (Exception e){
            System.out.println(e.toString());
            throw  new CompanyManagerException(ErrorType.EMPLOYEE_NOT_CREATED);
        }

    }

    public List<CompanyManagerProfile> findAll(){
        return companyProfileRepository.findAll();
    }

    public List<SummarisedFindAllResponse> findAllBySummarisedInformation(){
        List<CompanyManagerProfile> responseList = companyProfileRepository.findAll();
        return ICompanyManagerProfileMapper.INSTANCE.fromCompanyManagerProfileToResponse(responseList);
    }
}
