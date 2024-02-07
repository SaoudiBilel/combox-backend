package com.combox.commerce.repository;

import com.combox.commerce.model.Customer;
import com.combox.commerce.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    @Query("select p from Provider p where p.name like %:kw%")
    List<Provider> searchByName(@Param("kw") String keyword);
}
