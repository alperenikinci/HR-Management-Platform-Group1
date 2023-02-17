package com.bilgeadam.group1.controller;

import com.bilgeadam.group1.dto.request.AdvanceStatusChangeRequest;
import com.bilgeadam.group1.dto.request.ExpenditureRequestDto;
import com.bilgeadam.group1.dto.request.ExpenditureStatusChangeRequest;
import com.bilgeadam.group1.dto.response.ExpenditureResponseDto;
import com.bilgeadam.group1.repository.entity.Expenditure;
import com.bilgeadam.group1.repository.entity.Permission;
import com.bilgeadam.group1.service.ExpenditureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expenditure")
@RequiredArgsConstructor
public class ExpenditureController {
    private final ExpenditureService expenditureService;

    @PostMapping
    public ResponseEntity<ExpenditureResponseDto> createExpenditure(ExpenditureRequestDto dto){
        return ResponseEntity.ok(expenditureService.createExpenditure(dto));
    }

    @GetMapping("/findAllByEmployeeId")
    public ResponseEntity<List<Expenditure>> findAllByEmployeeId(Long id){
        return ResponseEntity.ok(expenditureService.findAllByEmployeeId(id));
    }

    @PostMapping("/changestatus")
    public ResponseEntity<Boolean> changeStatus(ExpenditureStatusChangeRequest request){
        return ResponseEntity.ok(expenditureService.changeStatus(request));
    }
}
