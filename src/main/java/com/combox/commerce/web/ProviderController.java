package com.combox.commerce.web;

import com.combox.commerce.model.Customer;
import com.combox.commerce.model.Provider;
import com.combox.commerce.service.ProviderService;
import com.combox.commerce.service.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
@CrossOrigin("*")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getById(@PathVariable Long id) {
        Provider provider = providerService.getById(id);
        if (provider != null) {
            return new ResponseEntity<>(provider, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Provider>> getAll() {
        List<Provider> providers = providerService.getAll();
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Provider> save(@RequestBody Provider provider) {
        Provider savedProvider = providerService.save(provider);
        return new ResponseEntity<>(savedProvider, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provider> update(@PathVariable Long id, @RequestBody Provider updatedProvider) {
        Provider provider = providerService.update(id, updatedProvider);
        if (provider != null) {
            return new ResponseEntity<>(provider, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Provider>> searchProviders(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<Provider> providers = providerService.search(keyword);
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        boolean deleted = providerService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

