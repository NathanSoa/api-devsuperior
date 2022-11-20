package com.devsuperior.dsmeta.controller;

import com.devsuperior.dsmeta.domain.Sale;
import com.devsuperior.dsmeta.service.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sale> findAll(){
        return service.findAll();
    }
}
