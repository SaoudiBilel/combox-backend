package com.combox.commerce.service;

import com.combox.commerce.model.invoice.PurchaseInvoice;
import com.combox.commerce.repository.PurchaseInvoiceRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseInvoiceService {

    Optional<PurchaseInvoice> getById(Long id);

    List<PurchaseInvoice> getAll();

    PurchaseInvoice save(PurchaseInvoice purchaseInvoice);

    PurchaseInvoice update(Long id, PurchaseInvoice updatedPurchaseInvoice);

    // Method to search purchaseInvoices
    List<PurchaseInvoice> search(String keyword);

    // Delete purchaseInvoice
    boolean delete(Long id);
}
