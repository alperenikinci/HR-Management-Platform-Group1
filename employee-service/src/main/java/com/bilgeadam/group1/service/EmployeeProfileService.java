package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.CreateEmployeeProfileRequest;
import com.bilgeadam.group1.dto.response.FindAllEmployeeByBriefResponse;
import com.bilgeadam.group1.mapper.IEmployeeProfileMapper;
import com.bilgeadam.group1.repository.IEmployeeProfileRepository;
import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeProfileService extends ServiceManager<EmployeeProfile,Long> {

    private final IEmployeeProfileRepository employeeProfileRepository;

    public EmployeeProfileService(IEmployeeProfileRepository employeeProfileRepository) {
        super(employeeProfileRepository);
        this.employeeProfileRepository = employeeProfileRepository;
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

    public String createEmployeeProfile(CreateEmployeeProfileRequest request){
        try{
            EmployeeProfile profile = IEmployeeProfileMapper.INSTANCE.fromCreateRequestToEmployeeProfile(request);
            employeeProfileRepository.save(profile);
            return request.getName()+" "+request.getSurname() + " Employee created";
        } catch (Exception e){
            throw new RuntimeException();
        }
        //TODO exceptionu yazılacak.
    }
}

