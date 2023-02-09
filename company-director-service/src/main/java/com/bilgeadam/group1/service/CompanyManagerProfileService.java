package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.CompanyManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.request.ProfileUpdateRequest;
import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.response.ProfileUpdateResponse;
import com.bilgeadam.group1.dto.response.SummarisedFindAllResponse;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.exception.CompanyManagerException;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.mapper.ICompanyDirectorProfileMapper;
import com.bilgeadam.group1.repository.ICompanyManagerProfileRepository;
import com.bilgeadam.group1.repository.entity.CompanyManagerProfile;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyManagerProfileService extends ServiceManager<CompanyManagerProfile,Long> {

    private final ICompanyManagerProfileRepository companyManagerProfileRepository;
    private final ICompanyDirectorProfileMapper companyManagerProfileMapper;

    public CompanyManagerProfileService(ICompanyManagerProfileRepository companyManagerProfileRepository, ICompanyDirectorProfileMapper companyManagerProfileMapper){
        super(companyManagerProfileRepository);
        this.companyManagerProfileRepository = companyManagerProfileRepository;
        this.companyManagerProfileMapper = companyManagerProfileMapper;
    }


    public boolean createCompanyManagerProfile (CompanyManagerProfileCreateRequestDto dto){
        try {
            CompanyManagerProfile profile = ICompanyDirectorProfileMapper.INSTANCE.fromRequestToCompanyManagerProfile(dto);
            companyManagerProfileRepository.save(profile);
            return true;
        }catch (Exception e){
            throw new CompanyManagerException(ErrorType.COMPANY_MANAGER_NOT_CREATED);
        }
    }

    public Optional<CompanyManagerProfile> findByEmail(String email){
        return companyManagerProfileRepository.findOptionalByEmail(email);
    }

    public Optional<UpdateTokenResponseDto> updateTokenByEmail(UpdateTokenRequestDto dto){
        Optional<CompanyManagerProfile> profile = companyManagerProfileRepository.findOptionalByEmail(dto.getEmail());
        if(!profile.isPresent()){
            throw new CompanyManagerException(ErrorType.EMAIL_NOT_FOUND);
        }
        profile.get().setToken(dto.getToken());
        companyManagerProfileRepository.save(profile.get());
        return Optional.ofNullable(companyManagerProfileMapper.INSTANCE.fromTokenRequestToResponse(dto));
    }

    public Optional<CompanyManagerProfile> findOptionalByToken(String token){
        return companyManagerProfileRepository.findOptionalByToken(token);
    }

    public Optional<ProfileUpdateResponse> updateProfileByToken(ProfileUpdateRequest request){
        Optional<CompanyManagerProfile> profile = companyManagerProfileRepository.findOptionalByToken(request.getToken());
        if(!profile.isPresent()){
            throw new CompanyManagerException(ErrorType.INVALID_TOKEN);
        }
        profile.get().setName(request.getName());
        profile.get().setPhotoUrl(request.getPhotoUrl());
        profile.get().setMiddleName(request.getMiddleName());
        profile.get().setSurname(request.getSurname());
        profile.get().setPhone(request.getPhone());
        profile.get().setAddress(request.getAddress());
        profile.get().setUpdateDate(System.currentTimeMillis());
        save(profile.get());
        return Optional.ofNullable(companyManagerProfileMapper.INSTANCE.fromCompanyManagerProfileToProfileUpdateResponse(profile.get()));
    }


    public List<CompanyManagerProfile> findAll(){
        return companyManagerProfileRepository.findAll();
    }

    public List<SummarisedFindAllResponse> findAllBySummarisedInformation(){
        List<CompanyManagerProfile> responseList = companyManagerProfileRepository.findAll();
        return ICompanyDirectorProfileMapper.INSTANCE.fromCompanyManagerProfileToResponse(responseList);
    }
}
