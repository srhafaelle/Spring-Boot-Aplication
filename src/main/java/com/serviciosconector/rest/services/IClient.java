package com.serviciosconector.rest.services;


import com.serviciosconector.rest.models.entity.Client;

public interface IClient {
   Client save(Client client); //metodo guarda y actualiza
    Client singIn(String userName, String pass); // metodo busca
    void delet(Client  client); //metodo eleimina
     boolean login(String email, String pass);

}
