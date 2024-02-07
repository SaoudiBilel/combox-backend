package com.combox.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.combox.commerce")
public class ComboxBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComboxBackendApplication.class, args);
    }

    /*@Bean
    CommandLineRunner run(ProductToSellRepository productToSellRepository,
                          ProductToBuyRepository productToBuyRepository,
                          BillRepository billRepository) {
        return args -> {
            productToSellRepository.save(new ProductToSell("baguette", "pièce", 1.0, 5, Category.BAKERY, null));
            productToSellRepository.save(new ProductToSell("tradition", "pièce", 1.0, 5, Category.BAKERY, null));
            productToSellRepository.save(new ProductToSell("pastries", "pièce", 1.0, 5, Category.PASTRY, null));
            productToSellRepository.save(new ProductToSell("sandwich", "pièce", 1.0, 5, Category.PASTRY, null));

            productToBuyRepository.save(new ProductToBuy("flour", "pièce", 1.0, 5, Category.BAKERY, null));
            productToBuyRepository.save(new ProductToBuy("fuel", "pièce", 1.0, 5, Category.ENERGY, null));
            productToBuyRepository.save(new ProductToBuy("chaise", "pièce", 1.0, 5, Category.FURNITURE, null));
            productToBuyRepository.save(new ProductToBuy("table", "pièce", 1.0, 5, Category.FURNITURE, null));


            billRepository.save(new CustomerBill("001", LocalDate.now(), LocalDate.now(), 500.0, BillStatus.PAID, null, null));
            billRepository.save(new CustomerBill("002", LocalDate.now(), LocalDate.now(), 400.0, BillStatus.PARTIALLY_PAID, null, null));
            billRepository.save(new CustomerBill("003", LocalDate.now(), LocalDate.now(), 700.0, BillStatus.UNPAID, null, null));
            billRepository.save(new CustomerBill("004", LocalDate.now(), LocalDate.now(), 1200.0, BillStatus.PAID, null, null));


            billRepository.save(new ProviderBill("flour", LocalDate.now(), LocalDate.now(), 400.0, BillStatus.PAID, null, null));
            billRepository.save(new ProviderBill("fuel", LocalDate.now(), LocalDate.now(), 650.0, BillStatus.PARTIALLY_PAID, null, null));
            billRepository.save(new ProviderBill("chaise", LocalDate.now(), LocalDate.now(), 320.0, BillStatus.PAID, null, null));
            billRepository.save(new ProviderBill("table", LocalDate.now(), LocalDate.now(), 184500.0, BillStatus.UNPAID, null, null));
        };
    }*/

}
