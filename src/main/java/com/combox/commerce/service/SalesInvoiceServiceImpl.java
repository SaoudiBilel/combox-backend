package com.combox.commerce.service;

import com.combox.commerce.model.invoice.SalesInvoice;
import com.combox.commerce.repository.SalesInvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SalesInvoiceServiceImpl implements SalesInvoiceService {

    @Autowired
    private SalesInvoiceRepository salesInvoiceRepository;

    @Override
    public SalesInvoice getById(Long id) {
        Optional<SalesInvoice> result = salesInvoiceRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<SalesInvoice> getAll() {
        return salesInvoiceRepository.findAll();
    }

    @Override
    public SalesInvoice save(SalesInvoice salesInvoice) {
        return salesInvoiceRepository.save(salesInvoice);
    }

    @Override
    public SalesInvoice update(SalesInvoice salesInvoice) {
        // Check if the salesInvoice exists
        if (!salesInvoiceRepository.existsById(salesInvoice.getId())) {
            return null;
        }
        return salesInvoiceRepository.save(salesInvoice);
    }

    @Override
    public List<SalesInvoice> search(String keyword) {
        return salesInvoiceRepository.searchByCustomerName(keyword);
    }

    @Override
    public boolean delete(Long id) {
        if (salesInvoiceRepository.existsById(id)) {
            salesInvoiceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
