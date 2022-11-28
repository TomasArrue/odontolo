package com.digitalhouse.odontologo.controller;

import com.digitalhouse.odontologo.service.impl.DomicilioServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@AllArgsConstructor
@RestController("/domicilio")
public class DomicilioController {
    private final DomicilioServiceImpl domicilioService;














}
