package com.combox.commerce.model.product;

import com.combox.commerce.model.invoice.PurchaseInvoice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product productPurchase;
    private int quantity;
    private double amount;
    @ManyToOne
    private PurchaseInvoice purchaseInvoice;
}
