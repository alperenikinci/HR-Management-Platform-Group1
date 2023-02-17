package com.bilgeadam.group1.controller;

import com.bilgeadam.group1.dto.request.AdvanceRequestDto;
import com.bilgeadam.group1.dto.request.AdvanceStatusChangeRequest;
import com.bilgeadam.group1.dto.response.AdvanceResponseDto;
import com.bilgeadam.group1.repository.entity.Advance;
import com.bilgeadam.group1.repository.entity.Expenditure;
import com.bilgeadam.group1.service.AdvanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/advance")
@RequiredArgsConstructor
public class AdvanceController {

    private final AdvanceService advanceService;

    @PostMapping("/createAdvance")
    public ResponseEntity<AdvanceResponseDto> createAdvance(AdvanceRequestDto dto){
        return ResponseEntity.ok(advanceService.createAdvance(dto));
    }
    @GetMapping("/findAllByEmployeeId")
    public ResponseEntity<List<Advance>> findAllByEmployeeId(Long id){
        return ResponseEntity.ok(advanceService.findAllByEmployeeId(id));
    }

    @PostMapping("/changestatus")
    public ResponseEntity<Boolean> changeStatus(AdvanceStatusChangeRequest request){
        return ResponseEntity.ok(advanceService.changeStatus(request));
    }
}
