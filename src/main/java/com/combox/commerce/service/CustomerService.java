package com.combox.commerce.service;

import com.combox.commerce.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    // Get customer by ID
    Optional<Customer> getById(Long id);

    // Get all customers
    List<Customer> getAll();

    // Save customer
    Customer save(Customer customer);

    // Update customer
    Customer update(Long id, Customer updatedCustomer);

    List<Customer> search(String keyword);

    boolean delete(Long id);
}
