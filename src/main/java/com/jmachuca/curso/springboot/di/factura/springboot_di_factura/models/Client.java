package com.jmachuca.curso.springboot.di.factura.springboot_di_factura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
//@SessionScope // Contexto de la session, es compartido
@RequestScope // Contexto del Request
//@JsonIgnoreProperties({"targetSource", "advisors"}) // Atributos residuales del proxy
public class Client {

    @Value("${client.name}")
    private String name;
    
    @Value("${client.lastname}")
    private String lastname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
