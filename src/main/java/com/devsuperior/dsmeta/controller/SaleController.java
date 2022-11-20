package com.devsuperior.dsmeta.controller;

import com.devsuperior.dsmeta.domain.Sale;
import com.devsuperior.dsmeta.service.SaleService;

import com.devsuperior.dsmeta.service.SmsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService service;
    private final SmsService smsService;

    public SaleController(SaleService service, SmsService smsService) {
        this.service = service;
        this.smsService = smsService;
    }

    @GetMapping
    public Page<Sale> findAll(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable){
        return service.findAll(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public ResponseEntity<String> sendSms(@PathVariable Long id) {
        smsService.sendSms(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("SMS sent!");
    }
}
