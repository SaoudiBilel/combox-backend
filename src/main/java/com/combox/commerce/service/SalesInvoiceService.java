package com.combox.commerce.service;

import com.combox.commerce.model.invoice.SalesInvoice;

import java.util.List;

public interface SalesInvoiceService {
    SalesInvoice getById(Long id);

    List<SalesInvoice> getAll();

    SalesInvoice save(SalesInvoice salesInvoice);

    SalesInvoice update(SalesInvoice salesInvoice);

    List<SalesInvoice> search(String keyword);

    boolean delete(Long id);
}
