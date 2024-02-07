package com.combox.commerce.repository;

import com.combox.commerce.model.product.Purchase;
import com.combox.commerce.model.product.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale s JOIN s.productSale p WHERE p.name LIKE %:kw%")
    List<Sale> searchByProductName(@Param("kw") String keyword);
}
