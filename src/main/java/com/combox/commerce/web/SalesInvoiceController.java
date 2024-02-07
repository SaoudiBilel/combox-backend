package com.combox.commerce.web;

import com.combox.commerce.model.invoice.SalesInvoice;
import com.combox.commerce.service.SalesInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/salesInvoices")
@CrossOrigin("*")
public class SalesInvoiceController {

    @Autowired
    private SalesInvoiceService salesInvoiceService;

    @GetMapping("/{id}")
    public ResponseEntity<SalesInvoice> getById(@PathVariable Long id) {
        SalesInvoice salesInvoice = salesInvoiceService.getById(id);
        if (salesInvoice != null) {
            return ResponseEntity.ok(salesInvoice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<SalesInvoice>> getAll() {
        List<SalesInvoice> salesInvoices = salesInvoiceService.getAll();
        return ResponseEntity.ok(salesInvoices);
    }

    @PostMapping
    public ResponseEntity<SalesInvoice> save(@RequestBody SalesInvoice salesInvoice) {
        SalesInvoice savedSalesInvoice = salesInvoiceService.save(salesInvoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSalesInvoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesInvoice> update(@PathVariable Long id, @RequestBody SalesInvoice salesInvoice) {
        if (!id.equals(salesInvoice.getId())) {
            return ResponseEntity.badRequest().build();
        }
        SalesInvoice updatedSalesInvoice = salesInvoiceService.update(salesInvoice);
        if (updatedSalesInvoice != null) {
            return ResponseEntity.ok(updatedSalesInvoice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<SalesInvoice>> searchSalesInvoices(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<SalesInvoice> salesInvoices = salesInvoiceService.search(keyword);
        return new ResponseEntity<>(salesInvoices, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesInvoice(@PathVariable Long id) {
        boolean deleted = salesInvoiceService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

