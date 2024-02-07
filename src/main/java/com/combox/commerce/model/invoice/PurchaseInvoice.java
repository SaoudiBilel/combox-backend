package com.combox.commerce.model.invoice;

import com.combox.commerce.model.Provider;
import com.combox.commerce.model.product.Purchase;
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
public class PurchaseInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int reference;
    @JsonIgnore
    @OneToMany(mappedBy = "purchaseInvoice")
    private List<Purchase> purchases;
    private double totalAmount;
    @ManyToOne
    private Provider provider;
    @Enumerated(EnumType.STRING)
    private Status status;
}
