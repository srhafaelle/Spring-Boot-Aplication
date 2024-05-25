package com.serviciosconector.rest.services;


import com.serviciosconector.rest.models.dto.PaymentMethodDto;
import com.serviciosconector.rest.models.entity.Driver;
import com.serviciosconector.rest.models.entity.PaymentMethod;

public interface IPaymentMethod {
    PaymentMethod save(PaymentMethodDto paymentMethodDto); //metodo guarda y actualiza
    PaymentMethod findById(String id); // metodo busca
    void delet(Driver  driver); //metodo elimina





}
