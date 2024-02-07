package com.combox.commerce.service;

import com.combox.commerce.model.product.Purchase;
import com.combox.commerce.repository.PurchaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    // Method to get a purchase by its ID
    @Override
    public Optional<Purchase> getById(Long id) {
        return purchaseRepository.findById(id);
    }

    // Method to get all purchases
    @Override
    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }

    // Method to save a new purchase
    @Override
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    // Method to update an existing purchase
    @Override
    public Purchase update(Long id, Purchase purchaseDetails) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);
        if (optionalPurchase.isPresent()) {
            Purchase existingPurchase = optionalPurchase.get();
            existingPurchase.setProductPurchase(purchaseDetails.getProductPurchase());
            existingPurchase.setQuantity(purchaseDetails.getQuantity());
            existingPurchase.setAmount(purchaseDetails.getAmount());
            return purchaseRepository.save(existingPurchase);
        } else {
            throw new IllegalArgumentException("Purchase with ID " + id + " not found");
        }
    }

    // Method to search purchases
    @Override
    public List<Purchase> search(String keyword) {
        List<Purchase> purchases = purchaseRepository.searchByProductName(keyword);
        return purchases;
    }

    // Delete purchase
    @Override
    public boolean delete(Long id) {
        if (purchaseRepository.existsById(id)) {
            purchaseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

