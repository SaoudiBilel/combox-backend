package com.combox.commerce.service;

import com.combox.commerce.model.Provider;

import java.util.List;

public interface ProviderService {
    Provider getById(Long id);

    List<Provider> getAll();

    List<Provider> search(String keyword);

    Provider save(Provider provider);

    Provider update(Long id, Provider updatedProvider);

    // Delete customer
    boolean delete(Long id);
}
