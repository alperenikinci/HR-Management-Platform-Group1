package com.bilgeadam.group1.controller;

import com.bilgeadam.group1.service.EmailSenderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmailController {

  /*  EmailSenderService emailSenderService;
    @PostMapping()
    @Operation(summary = "Kullanici kayit eden metot")
    public ResponseEntity<RegisterResponseDto> registerWithRabbitMq(@RequestBody @Valid RegisterRequestDto dto){
        return  ResponseEntity.ok( emailSenderService.registerWithRabbitMQ(dto));
    }*/
}
