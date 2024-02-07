package com.combox.commerce.service;

import com.combox.commerce.model.product.Product;

import java.util.List;

public interface ProductService {
    Product getById(Long id);

    List<Product> getAll();

    List<Product> getByForSale(boolean forSale);

    List<Product> search(String keyword);

    Product save(Product product);

    Product update(Long id, Product updatedProduct);

    boolean delete(Long id);
}
