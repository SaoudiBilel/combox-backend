package com.combox.commerce.web;

import com.combox.commerce.model.Customer;
import com.combox.commerce.model.product.Purchase;
import com.combox.commerce.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
@CrossOrigin("*")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // Get purchase by ID
    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getById(@PathVariable Long id) {
        Optional<Purchase> purchaseOptional = purchaseService.getById(id);
        return purchaseOptional.map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all purchases
    @GetMapping
    public ResponseEntity<List<Purchase>> getAll() {
        List<Purchase> purchases = purchaseService.getAll();
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }

    // Create a new purchase
    @PostMapping
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        Purchase savedPurchase = purchaseService.save(purchase);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }

    // Update an existing purchase
    @PutMapping("/{id}")
    public ResponseEntity<Purchase> update(@PathVariable Long id, @RequestBody Purchase purchaseDetails) {
        Purchase updatedPurchase = purchaseService.update(id, purchaseDetails);
        if (updatedPurchase != null) {
            return new ResponseEntity<>(updatedPurchase, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Purchase>> searchPurchases(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<Purchase> purchases = purchaseService.search(keyword);
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        boolean deleted = purchaseService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

