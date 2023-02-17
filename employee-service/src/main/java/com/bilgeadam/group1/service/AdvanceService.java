package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.AdvanceRequestDto;
import com.bilgeadam.group1.dto.request.AdvanceStatusChangeRequest;
import com.bilgeadam.group1.dto.response.AdvanceResponseDto;
import com.bilgeadam.group1.exception.EmployeeException;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.mapper.IAdvanceMapper;
import com.bilgeadam.group1.repository.IAdvanceRepository;
import com.bilgeadam.group1.repository.entity.Advance;
import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvanceService extends ServiceManager<Advance,Long> {

    private final EmployeeProfileService employeeProfileService;
    private final IAdvanceRepository advanceRepository;

    public AdvanceService(EmployeeProfileService employeeProfileService, IAdvanceRepository advanceRepository) {
        super(advanceRepository);
        this.employeeProfileService = employeeProfileService;
        this.advanceRepository = advanceRepository;
    }

    public AdvanceResponseDto createAdvance(AdvanceRequestDto dto){
        Optional<EmployeeProfile> employee = employeeProfileService.findById(dto.getEmployeeId());
        if(dto.getSalaryCount()>3){
            throw new EmployeeException(ErrorType.SALARY_COUNT_ERROR);
        }
        if(employee.isPresent()){
            try {
                Advance advance = new Advance();
                advance.setAdvanceType(dto.getAdvanceType());
                advance.setSalaryCount(dto.getSalaryCount());
                advance.setDetails(dto.getDetails());
                advance.setEmployeeProfile(employee.get());
                advance.setConfirmationType(dto.getAdvanceConfirmationType());
                advance.setPriceType(dto.getPriceType());
                advance.setCreateRequestDate(System.currentTimeMillis());
                advanceRepository.save(advance);
                employee.get().getAdvanceList().add(advance);
                employeeProfileService.save(employee.get());
                return IAdvanceMapper.INSTANCE.fromAdvanceToResponse(advance);
            } catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }else {
            throw new RuntimeException();
        }
    }
    public List<Advance> findAllByEmployeeId(Long id){
        return advanceRepository.findOptionalByEmployeeId(id);
    }
    public Optional<Advance> findById(Long id){
        return advanceRepository.findById(id);
    }

    public Boolean changeStatus(AdvanceStatusChangeRequest request){
        Optional<EmployeeProfile> employee = employeeProfileService.findById(request.getEmployeeId());
        if(employee.isPresent()){
            Optional<Advance> advance = advanceRepository.findById(request.getAdvanceId());
            advance.get().setConfirmationType(request.getConfirmationType());
            advance.get().setEmployeeProfile(employee.get());
            advance.get().setResponseDate(System.currentTimeMillis());
            advanceRepository.save(advance.get());
            employeeProfileService.save(employee.get());

        }else {
            throw new RuntimeException();
        }
        return true;
    }
}
