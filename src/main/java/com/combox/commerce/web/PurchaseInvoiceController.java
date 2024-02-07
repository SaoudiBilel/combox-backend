package com.combox.commerce.web;

import com.combox.commerce.model.invoice.PurchaseInvoice;
import com.combox.commerce.service.PurchaseInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchaseInvoices")
@CrossOrigin("*")
public class PurchaseInvoiceController {

    @Autowired
    private PurchaseInvoiceService purchaseInvoiceService;

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseInvoice> getById(@PathVariable Long id) {
        Optional<PurchaseInvoice> purchaseInvoiceOptional = purchaseInvoiceService.getById(id);
        return purchaseInvoiceOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PurchaseInvoice>> getAll() {
        List<PurchaseInvoice> purchaseInvoices = purchaseInvoiceService.getAll();
        return ResponseEntity.ok(purchaseInvoices);
    }

    @PostMapping
    public ResponseEntity<PurchaseInvoice> save(@RequestBody PurchaseInvoice purchaseInvoice) {
        PurchaseInvoice savedPurchaseInvoice = purchaseInvoiceService.save(purchaseInvoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPurchaseInvoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseInvoice> update(@PathVariable Long id, @RequestBody PurchaseInvoice updatedPurchaseInvoice) {
        PurchaseInvoice updatedInvoice = purchaseInvoiceService.update(id, updatedPurchaseInvoice);
        return updatedInvoice != null ? ResponseEntity.ok(updatedInvoice) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PurchaseInvoice>> searchPurchaseInvoices(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<PurchaseInvoice> purchaseInvoices = purchaseInvoiceService.search(keyword);
        return new ResponseEntity<>(purchaseInvoices, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseInvoice(@PathVariable Long id) {
        boolean deleted = purchaseInvoiceService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

