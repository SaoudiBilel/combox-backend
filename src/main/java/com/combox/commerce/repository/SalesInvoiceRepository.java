package com.combox.commerce.repository;

import com.combox.commerce.model.invoice.SalesInvoice;
import com.combox.commerce.model.product.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesInvoiceRepository extends JpaRepository<SalesInvoice, Long> {

    @Query("SELECT si FROM SalesInvoice si JOIN si.customer c WHERE c.name LIKE %:kw%")
    List<SalesInvoice> searchByCustomerName(@Param("kw") String keyword);

}
