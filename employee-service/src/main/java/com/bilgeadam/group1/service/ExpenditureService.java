package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.AdvanceStatusChangeRequest;
import com.bilgeadam.group1.dto.request.ExpenditureRequestDto;
import com.bilgeadam.group1.dto.request.ExpenditureStatusChangeRequest;
import com.bilgeadam.group1.dto.response.ExpenditureResponseDto;
import com.bilgeadam.group1.mapper.IExpenditureMapper;
import com.bilgeadam.group1.repository.IExpenditureRepository;
import com.bilgeadam.group1.repository.entity.Advance;
import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import com.bilgeadam.group1.repository.entity.Expenditure;
import com.bilgeadam.group1.repository.entity.Permission;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenditureService extends ServiceManager<Expenditure,Long> {
    private final IExpenditureRepository expenditureRepository;
    private final EmployeeProfileService employeeProfileService;

    public ExpenditureService(IExpenditureRepository expenditureRepository, EmployeeProfileService employeeProfileService) {
        super(expenditureRepository);
        this.expenditureRepository = expenditureRepository;
        this.employeeProfileService = employeeProfileService;
    }

    public ExpenditureResponseDto createExpenditure(ExpenditureRequestDto dto){
        Optional<EmployeeProfile> employee = employeeProfileService.findById(dto.getEmployeeId());
        if(employee.isPresent()){
            try {
                Expenditure expenditure = new Expenditure();
                expenditure.setExpenditureType(dto.getExpenditureType());
                expenditure.setPrice(dto.getPrice());
                expenditure.setConfirmationType(dto.getExpenditureConfirmationType());
                expenditure.setPriceType(dto.getPriceType());
                expenditure.setFileUrl(dto.getFileUrl());
                expenditure.setEmployeeProfile(employee.get());
                expenditure.setCreateRequestDate(System.currentTimeMillis());
                expenditureRepository.save(expenditure);
                employee.get().getExpenditureList().add(expenditure);
                employeeProfileService.save(employee.get());
                return IExpenditureMapper.INSTANCE.fromExpenditureToExpenditureResponse(expenditure);
            } catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }else {
            throw new RuntimeException();
        }
    }

    public List<Expenditure> findAllByEmployeeId(Long id){
        return expenditureRepository.findOptionalByEmployeeId(id);
    }

    public Optional<Expenditure> findById(Long id){
        return expenditureRepository.findById(id);
    }
    public Boolean changeStatus(ExpenditureStatusChangeRequest request){
        Optional<EmployeeProfile> employee = employeeProfileService.findById(request.getEmployeeId());
        if(employee.isPresent()){
            Optional<Expenditure> expenditure = expenditureRepository.findById(request.getExpenditureId());
            expenditure.get().setConfirmationType(request.getConfirmationType());
            expenditure.get().setEmployeeProfile(employee.get());
            expenditure.get().setResponseDate(System.currentTimeMillis());
            expenditureRepository.save(expenditure.get());
            employeeProfileService.save(employee.get());

        }else {
            throw new RuntimeException();
        }
        return true;
    }
}
