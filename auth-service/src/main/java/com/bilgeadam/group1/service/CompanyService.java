package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.company.CreateCompanyRequestDto;
import com.bilgeadam.group1.mapper.ICompanyMapper;
import com.bilgeadam.group1.repository.ICompanyRepository;
import com.bilgeadam.group1.repository.entity.Company;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CompanyService extends ServiceManager<Company,Long > {

    private final ICompanyRepository companyRepository;


    public CompanyService(ICompanyRepository companyRepository) {
        super(companyRepository);
        this.companyRepository = companyRepository;
    }

    public String createCompany(CreateCompanyRequestDto request){

        Company company = ICompanyMapper.INSTANCE.fromRequestToCompany(request);
        company.setDateOfEstablishment(LocalDate.parse(request.getDateOfEstablishmentAsString()));
        company.setEffectiveDate(LocalDate.parse(request.getEffectiveDateAsLocalDateAsString()));
        company.setContactTerminationDate(LocalDate.parse(request.getContactTerminationDateAsLocalDateAsString()));
        save(company);
        return company.getName() + " company has been successfully created";
    }


}
