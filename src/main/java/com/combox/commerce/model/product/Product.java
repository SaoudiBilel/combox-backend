package com.combox.commerce.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String unit;
    private double unitPrice;
    @Enumerated(EnumType.STRING)
    private Category category;
    private boolean forSale;
    @JsonIgnore
    @OneToMany(mappedBy = "productPurchase")
    List<Purchase> purchases;
    @JsonIgnore
    @OneToMany(mappedBy = "productSale")
    List<Sale> sales;
}