package com.combox.commerce.service;

import com.combox.commerce.model.Customer;
import com.combox.commerce.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Get customer by ID
    @Override
    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    // Get all customers
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }


    // Save customer
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    // Update customer
    @Override
    public Customer update(Long id, Customer updatedCustomer) {
        if (customerRepository.existsById(id)) {
            updatedCustomer.setId(id);
            return customerRepository.save(updatedCustomer);
        } else {
            return null; // Handle the case where the customer with the given ID doesn't exist
        }
    }

    // Search Customers
    @Override
    public List<Customer> search(String keyword) {
        return customerRepository.searchByName(keyword);
    }

    // Delete customer
    @Override
    public boolean delete(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

