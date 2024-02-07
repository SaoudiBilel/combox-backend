package com.combox.commerce.model.product;

import com.combox.commerce.model.invoice.SalesInvoice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product productSale;
    private int quantity;
    private double amount;
    @ManyToOne
    private SalesInvoice salesInvoice;
}