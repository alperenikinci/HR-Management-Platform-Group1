package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.companydirector.RegisterCompanyDirectorRequestDto;
import com.bilgeadam.group1.dto.response.websitemanager.RegisterResponseDto;
import com.bilgeadam.group1.exception.AuthManagerException;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.manager.ICompanyDirectorManager;
import com.bilgeadam.group1.mapper.ICompanyDirectorMapper;
import com.bilgeadam.group1.repository.ICompanyDirectorRepository;
import com.bilgeadam.group1.repository.entity.CompanyDirector;
import com.bilgeadam.group1.utility.CodeGenerator;
import com.bilgeadam.group1.utility.JwtTokenManager;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyDirectorService extends ServiceManager<CompanyDirector,Long> {

    private final ICompanyDirectorRepository companyDirectorRepository;
    private final ICompanyDirectorManager companyDirectorManager;

    public CompanyDirectorService(ICompanyDirectorRepository companyDirectorRepository, JwtTokenManager jwtTokenManager, ICompanyDirectorManager companyDirectorManager) {
        super(companyDirectorRepository);
        this.companyDirectorRepository = companyDirectorRepository;
        this.companyDirectorManager = companyDirectorManager;
    }

    @Transactional
    public RegisterResponseDto registerCompanyDirector(RegisterCompanyDirectorRequestDto dto){
        if(companyDirectorRepository.findOptionalByEmail(dto.getEmail()).isPresent()){
            throw new AuthManagerException(ErrorType.DUPLICATE_EMAIL_ERROR);
        }
        try {
            CompanyDirector companyDirector = new CompanyDirector();
            companyDirector.setEmail(dto.getEmail());
            companyDirector.setPassword(CodeGenerator.generateCode());
            save(companyDirector);
            companyDirectorManager.createCompanyManagerProfile(ICompanyDirectorMapper.INSTANCE.fromCompanyDirectorToCompanyDirectorProfileCreateRequestDto(companyDirector));
            return ICompanyDirectorMapper.INSTANCE.fromCompanyDirectorToResponse(companyDirector);
        } catch (Exception e){
            throw new AuthManagerException(ErrorType.INTERNAL_ERROR);
        }
    }
    public List<CompanyDirector> findAll(){
        return companyDirectorRepository.findAll();
    }
    public Optional<CompanyDirector> findByToken(String token){
        return companyDirectorRepository.findOptionalByToken(token);
    }
}
