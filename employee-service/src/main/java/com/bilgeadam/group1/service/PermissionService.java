package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.ExpenditureStatusChangeRequest;
import com.bilgeadam.group1.dto.request.PermissionRequestDto;
import com.bilgeadam.group1.dto.request.PermissionStatusChangeRequest;
import com.bilgeadam.group1.dto.response.PermissionResponseDto;
import com.bilgeadam.group1.mapper.IPermissionMapper;
import com.bilgeadam.group1.repository.IPermissionRepository;
import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import com.bilgeadam.group1.repository.entity.Expenditure;
import com.bilgeadam.group1.repository.entity.Permission;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionService extends ServiceManager<Permission,Long> {

    private final IPermissionRepository permissionRepository;
    private final EmployeeProfileService employeeProfileService;

    public PermissionService(IPermissionRepository permissionRepository, EmployeeProfileService employeeProfileService) {
        super(permissionRepository);
        this.permissionRepository = permissionRepository;
        this.employeeProfileService = employeeProfileService;
    }


    public PermissionResponseDto createPermission(PermissionRequestDto dto){
//        Permission permission = IPermissionMapper.INSTANCE.fromPermRequestToPermission(dto);
        Optional<EmployeeProfile> employee = employeeProfileService.findById(dto.getEmployeeId());
        if(employee.isPresent()) {
            try {
                Permission permission = new Permission();
                permission.setEmployeeProfile(employee.get());
                permission.setPermissionType(dto.getPermissionType());
                permission.setPermissionConfirmationType(dto.getPermissionConfirmationType());
                permission.setStartedDate(dto.getStartedDate());
                permission.setFinishedDate(dto.getFinishedDate());
                permission.setCreateRequestDate(System.currentTimeMillis());
//                permission.setPermissionRequestDate(System.currentTimeMillis());
                permission.setPermissionDay(Duration.between(dto.getStartedDate().atStartOfDay(),dto.getFinishedDate().atStartOfDay()).toDays());
                permissionRepository.save(permission);
                employee.get().getPermissionList().add(permission);
                employeeProfileService.save(employee.get());
                return IPermissionMapper.INSTANCE.fromPermissionToPermResponse(permission);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }else {
            throw new RuntimeException();
        }
    }
    public List<Permission> findAll(){
        return permissionRepository.findAll();
    }

    public List<Permission> findAllByEmployeeId(Long id){
        return permissionRepository.findOptionalByEmployeeId(id);
    }
    public Optional<Permission> findById(Long id){
        return permissionRepository.findById(id);
    }
    public Boolean changeStatus(PermissionStatusChangeRequest request){
        Optional<EmployeeProfile> employee = employeeProfileService.findById(request.getEmployeeId());
        if(employee.isPresent()){
            Optional<Permission> permission = permissionRepository.findById(request.getPermissionId());
            permission.get().setPermissionConfirmationType(request.getConfirmationType());
            permission.get().setEmployeeProfile(employee.get());
            permission.get().setResponseDate(System.currentTimeMillis());
            permissionRepository.save(permission.get());
            employeeProfileService.save(employee.get());

        }else {
            throw new RuntimeException();
        }
        return true;
    }

}
