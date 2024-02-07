package com.combox.commerce.service;

import com.combox.commerce.model.product.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleService {
    // Get sale by ID
    Optional<Sale> getById(Long id);

    // Get all sales
    List<Sale> getAll();

    // Save a new sale
    Sale save(Sale sale);

    // Update an existing sale
    Sale update(Long id, Sale updatedSale);

    // Search sales
    List<Sale> search(String keyword);

    // Delete sale
    boolean delete(Long id);
}
