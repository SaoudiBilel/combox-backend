package com.combox.commerce.repository;

import com.combox.commerce.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.name like %:kw%")
    List<Product> searchByName(@Param("kw") String keyword);

    List<Product> findByForSale(boolean forSale);
}
