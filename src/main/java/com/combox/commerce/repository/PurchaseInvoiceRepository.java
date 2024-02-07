package com.combox.commerce.repository;

import com.combox.commerce.model.invoice.PurchaseInvoice;
import com.combox.commerce.model.product.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, Long> {

    @Query("SELECT pi FROM PurchaseInvoice pi JOIN pi.provider p WHERE p.name LIKE %:kw%")
    List<PurchaseInvoice> searchByProviderName(@Param("kw") String keyword);

}
