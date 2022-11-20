package com.devsuperior.dsmeta.service;

import com.devsuperior.dsmeta.domain.Sale;
import com.devsuperior.dsmeta.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> findAll(){
        return saleRepository.findAll();
    }
}
