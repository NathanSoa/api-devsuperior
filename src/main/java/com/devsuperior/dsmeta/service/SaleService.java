package com.devsuperior.dsmeta.service;

import com.devsuperior.dsmeta.domain.Sale;
import com.devsuperior.dsmeta.repository.SaleRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Page<Sale> findAll(String minDate, String maxDate, Pageable pageable){
        LocalDate today = LocalDate.now(Clock.systemDefaultZone());
        LocalDate min = minDate.equals("") ? today.minusYears(1L) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        return saleRepository.findAll(min, max, pageable);
    }
}
