package com.combox.commerce.service;

import com.combox.commerce.model.invoice.PurchaseInvoice;
import com.combox.commerce.repository.PurchaseInvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseInvoiceServiceImpl implements PurchaseInvoiceService {
    private final PurchaseInvoiceRepository purchaseInvoiceRepository;

    public PurchaseInvoiceServiceImpl(PurchaseInvoiceRepository purchaseInvoiceRepository) {
        this.purchaseInvoiceRepository = purchaseInvoiceRepository;
    }

    @Override
    public Optional<PurchaseInvoice> getById(Long id) {
        return purchaseInvoiceRepository.findById(id);
    }

    @Override
    public List<PurchaseInvoice> getAll() {
        return purchaseInvoiceRepository.findAll();
    }

    @Override
    public PurchaseInvoice save(PurchaseInvoice purchaseInvoice) {
        return purchaseInvoiceRepository.save(purchaseInvoice);
    }

    @Override
    public PurchaseInvoice update(Long id, PurchaseInvoice updatedPurchaseInvoice) {
        Optional<PurchaseInvoice> existingPurchaseInvoice = purchaseInvoiceRepository.findById(id);
        if (existingPurchaseInvoice.isPresent()) {
            updatedPurchaseInvoice.setId(id);
            return purchaseInvoiceRepository.save(updatedPurchaseInvoice);
        } else {
            return null; // Or throw an exception indicating not found
        }
    }

    // Method to search purchaseInvoices
    @Override
    public List<PurchaseInvoice> search(String keyword) {
        return purchaseInvoiceRepository.searchByProviderName(keyword);
    }

    // Delete purchaseInvoice
    @Override
    public boolean delete(Long id) {
        if (purchaseInvoiceRepository.existsById(id)) {
            purchaseInvoiceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

