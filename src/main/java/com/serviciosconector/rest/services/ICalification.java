package com.serviciosconector.rest.services;

import com.serviciosconector.rest.models.dto.CalificationDto;

import com.serviciosconector.rest.models.entity.Calification;


public interface ICalification {
    Calification save(CalificationDto calification); //metodo guarda y actualiza
    Calification findById(String id); // metodo busca
    void delet(Calification  calification); //metodo eleimina
}
