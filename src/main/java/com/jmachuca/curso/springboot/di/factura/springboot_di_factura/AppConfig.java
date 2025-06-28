package com.jmachuca.curso.springboot.di.factura.springboot_di_factura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.jmachuca.curso.springboot.di.factura.springboot_di_factura.models.Item;
import com.jmachuca.curso.springboot.di.factura.springboot_di_factura.models.Product;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
})
public class AppConfig {

    @Bean
    List<Item> itemsInvoice() {

        Product prod1 = new Product("Camara Sony", 800);
        Product prod2 = new Product("Bicicleta Bianchi 26'", 1200);
        
        List<Item> items = Arrays.asList(
            new Item(prod1, 2), 
            new Item(prod2, 4)
        );

        return items;
    }

    @Bean
    List<Item> itemsInvoiceOffice() {

        Product prod1 = new Product("Monitor Asus 24'", 700);
        Product prod2 = new Product("Notebook Razer", 2400);
        Product prod3 = new Product("Impresora HP", 800);
        Product prod4 = new Product("Escritorio Oficina", 900);
        
        List<Item> items = Arrays.asList(
            new Item(prod1, 4), 
            new Item(prod2, 6),
            new Item(prod3, 1), 
            new Item(prod4, 4)
        );

        return items;
    }
}
