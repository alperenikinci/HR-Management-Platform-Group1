package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.company.CreateCompanyRequestDto;
import com.bilgeadam.group1.dto.response.company.FindAllCompaniesByBriefResponse;
import com.bilgeadam.group1.mapper.ICompanyMapper;
import com.bilgeadam.group1.repository.ICompanyRepository;
import com.bilgeadam.group1.repository.entity.Company;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class CompanyService extends ServiceManager<Company,Long > {

    private final ICompanyRepository companyRepository;


    public CompanyService(ICompanyRepository companyRepository) {
        super(companyRepository);
        this.companyRepository = companyRepository;
    }

    public String createCompany(CreateCompanyRequestDto request){

        Company company = ICompanyMapper.INSTANCE.fromRequestToCompany(request);
        save(company);
        return company.getName() + " company has been successfully created";
    }

    public List<FindAllCompaniesByBriefResponse> findAllWithBriefInformation(){
        List<FindAllCompaniesByBriefResponse> briefResponseList = ICompanyMapper.INSTANCE.fromCompanyListToBriefResponse(companyRepository.findAll());
        if(briefResponseList.isEmpty()){
            return Collections.emptyList();
        }
        return briefResponseList;
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }


}
