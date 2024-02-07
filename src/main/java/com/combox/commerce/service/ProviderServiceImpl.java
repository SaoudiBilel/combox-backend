package com.combox.commerce.service;

import com.combox.commerce.model.Provider;
import com.combox.commerce.repository.ProviderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Provider getById(Long id) {
        Optional<Provider> providerOptional = providerRepository.findById(id);
        return providerOptional.orElse(null);
    }

    @Override
    public List<Provider> getAll() {
        return providerRepository.findAll();
    }

    @Override
    public List<Provider> search(String keyword) {
        return providerRepository.searchByName(keyword);
    }

    @Override
    public Provider save(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public Provider update(Long id, Provider updatedProvider) {
        Optional<Provider> providerOptional = providerRepository.findById(id);
        if (providerOptional.isPresent()) {
            Provider existingProvider = providerOptional.get();
            // Update fields of existingProvider with updatedProvider
            existingProvider.setName(updatedProvider.getName());
            existingProvider.setPhoneNumber(updatedProvider.getPhoneNumber());
            existingProvider.setEmail(updatedProvider.getEmail());
            return providerRepository.save(existingProvider);
        } else {
            return null; // or throw an exception indicating not found
        }
    }

    // Delete customer
    @Override
    public boolean delete(Long id) {
        if (providerRepository.existsById(id)) {
            providerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
