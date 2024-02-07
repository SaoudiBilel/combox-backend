package com.combox.commerce.service;

import com.combox.commerce.model.product.Sale;
import com.combox.commerce.repository.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    // Get sale by ID
    @Override
    public Optional<Sale> getById(Long id) {
        return saleRepository.findById(id);
    }

    // Get all sales
    @Override
    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    // Save a new sale
    @Override
    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    // Update an existing sale
    @Override
    public Sale update(Long id, Sale updatedSale) {
        Optional<Sale> optionalSale = saleRepository.findById(id);
        if (optionalSale.isPresent()) {
            updatedSale.setId(id); // Ensure the ID matches the entity being updated
            return saleRepository.save(updatedSale);
        } else {
            throw new IllegalArgumentException("Sale with ID " + id + " not found");
        }
    }

    // Search sales
    @Override
    public List<Sale> search(String keyword) {
        return saleRepository.searchByProductName(keyword);
    }

    // Delete sale
    @Override
    public boolean delete(Long id) {
        if (saleRepository.existsById(id)) {
            saleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

