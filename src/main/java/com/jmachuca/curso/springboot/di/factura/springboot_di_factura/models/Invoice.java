package com.jmachuca.curso.springboot.di.factura.springboot_di_factura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope // Es del contexto de request
//@JsonIgnoreProperties({"targetSource", "advisors"}) // Atributos residuales del proxy
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    @Qualifier("itemsInvoiceOffice")
    private List<Item> items;

    // En este punto ya se encuentran los valores de los atributos, eso no ocurre en el contructor
    @PostConstruct
    public void init() {
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" Felipe"));
        this.description = description.concat(" del cliente ").concat(client.getName()).concat(" ").concat(client.getLastname());
        //this.description = description.join(" ", description, "de cliente", client.getName(), client.getLastname());
    }

    // Antes de destruir ejecutar las acciones
    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componente o Beans Invoice!!!");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // Tradicional
    // public int getTotal() {
    //     int total = 0;

    //     for (Item item : this.items) {
    //         total += item.getImporte();
    //     }

    //     return total;
    // }

    // Utilizando API Stream
    public int getTotal() {
        int total = items.stream()
                        .map(item -> item.getImporte())
                        .reduce(0, (sum, importe) -> sum + importe);
        
        return total;
    }
}
