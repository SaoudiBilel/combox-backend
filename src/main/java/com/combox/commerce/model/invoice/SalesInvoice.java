package com.combox.commerce.model.invoice;

import com.combox.commerce.model.Customer;
import com.combox.commerce.model.product.Sale;
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
public class SalesInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int reference;
    @JsonIgnore
    @OneToMany(mappedBy = "salesInvoice")
    private List<Sale> sales;
    private double totalAmount;
    @ManyToOne
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private Status status;
}
