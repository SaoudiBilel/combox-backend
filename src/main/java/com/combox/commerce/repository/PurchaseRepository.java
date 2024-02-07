package com.combox.commerce.repository;

import com.combox.commerce.model.Customer;
import com.combox.commerce.model.product.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT c FROM Purchase c JOIN c.productPurchase p WHERE p.name LIKE %:kw%")
    List<Purchase> searchByProductName(@Param("kw") String keyword);
}