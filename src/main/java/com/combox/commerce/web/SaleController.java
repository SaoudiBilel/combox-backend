package com.combox.commerce.web;

import com.combox.commerce.model.product.Sale;
import com.combox.commerce.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
@CrossOrigin("*")
@Transactional
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getById(@PathVariable Long id) {
        Optional<Sale> sale = saleService.getById(id);
        return sale.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAll() {
        List<Sale> sales = saleService.getAll();
        return ResponseEntity.ok(sales);
    }

    @PostMapping
    public ResponseEntity<Sale> save(@RequestBody Sale sale) {
        Sale savedSale = saleService.save(sale);
        return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> update(@PathVariable Long id, @RequestBody Sale updatedSale) {
        Sale sale = saleService.update(id, updatedSale);
        if (sale != null) {
            return ResponseEntity.ok(sale);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Sale>> searchSales(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<Sale> sales = saleService.search(keyword);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        boolean deleted = saleService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

