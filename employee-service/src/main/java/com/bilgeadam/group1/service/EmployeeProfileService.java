package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.CreateEmployeeProfileRequest;
import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.response.FindAllEmployeeByBriefResponse;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.exception.EmployeeException;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.mapper.IEmployeeProfileMapper;
import com.bilgeadam.group1.repository.IEmployeeProfileRepository;
import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProfileService extends ServiceManager<EmployeeProfile,Long> {

    private final IEmployeeProfileRepository employeeProfileRepository;
    private final IEmployeeProfileMapper employeeProfileMapper;

    public EmployeeProfileService(IEmployeeProfileRepository employeeProfileRepository, IEmployeeProfileMapper employeeProfileMapper) {
        super(employeeProfileRepository);
        this.employeeProfileRepository = employeeProfileRepository;
        this.employeeProfileMapper = employeeProfileMapper;
    }

    public List<FindAllEmployeeByBriefResponse> findAllWithBriefInformation(){
        List<FindAllEmployeeByBriefResponse> briefResponseList = IEmployeeProfileMapper.INSTANCE.fromEmployeeListToBriefResponse(employeeProfileRepository.findAll());
        if(briefResponseList.isEmpty()){
            return Collections.emptyList();
        }
        return briefResponseList;
    }
    public List<EmployeeProfile> findAll(){
        return employeeProfileRepository.findAll();
    }

    public boolean createEmployeeProfile(CreateEmployeeProfileRequest request){
        try{
            EmployeeProfile profile = IEmployeeProfileMapper.INSTANCE.fromCreateRequestToEmployeeProfile(request);
            employeeProfileRepository.save(profile);
            return true;
        } catch (Exception e){
            throw new RuntimeException();
        }
        //TODO exceptionu yazılacak.
    }
    public Optional<UpdateTokenResponseDto> updateTokenByEmail(UpdateTokenRequestDto dto){
        Optional<EmployeeProfile> profile = employeeProfileRepository.findOptionalByEmail(dto.getEmail());
        if(!profile.isPresent()){
            throw new EmployeeException(ErrorType.EMAIL_NOT_FOUND);
        }
        profile.get().setToken(dto.getToken());
        employeeProfileRepository.save(profile.get());
        return Optional.ofNullable(employeeProfileMapper.INSTANCE.fromTokenRequestToResponse(dto));
    }
}

