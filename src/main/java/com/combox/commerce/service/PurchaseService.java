package com.combox.commerce.service;

import com.combox.commerce.model.product.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    // Method to get a purchase by its ID
    Optional<Purchase> getById(Long id);

    // Method to get all purchases
    List<Purchase> getAll();

    // Method to save a new purchase
    Purchase save(Purchase purchase);

    // Method to update an existing purchase
    Purchase update(Long id, Purchase purchaseDetails);

    // Method to search purchases
    List<Purchase> search(String keyword);

    // Delete purchase
    boolean delete(Long id);
}
