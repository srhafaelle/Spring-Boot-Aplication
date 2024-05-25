package com.serviciosconector.rest.services;
import com.serviciosconector.rest.models.dto.DriverDto;
import com.serviciosconector.rest.models.entity.Driver;

public interface IDriver {
    Driver save(Driver driverdto); //metodo guarda y actualiza
    Driver findById(String id); // metodo busca
    void delet(Driver  driver); //metodo eleimina
}
