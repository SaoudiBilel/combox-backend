package com.combox.commerce.model;

import com.combox.commerce.model.invoice.PurchaseInvoice;
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
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "provider")
    private List<PurchaseInvoice> invoices;
}
