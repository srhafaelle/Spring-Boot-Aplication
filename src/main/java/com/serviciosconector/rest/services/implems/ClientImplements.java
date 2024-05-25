package com.serviciosconector.rest.services.implems;
import com.serviciosconector.rest.models.dao.ClientDao;
import com.serviciosconector.rest.models.dto.ClientDto;
import com.serviciosconector.rest.models.entity.Client;
import com.serviciosconector.rest.services.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientImplements implements IClient {
    @Autowired
    private ClientDao clientDoa;


    // guardar
    @Transactional()
    @Override
    public Client save(Client clientDTO) {
    Client client = Client.builder().id(clientDTO.getId())
            .client_name(clientDTO.getClient_name())
            .client_email(clientDTO.getClient_email())
            .build();
        return clientDoa.save(client);

    }



    //buscar
@Transactional(readOnly = true)
    @Override
    public Client singIn(String name, String pass) {

        return clientDoa.findByUsername(name, pass);
    }

    //borrar
@Transactional
    @Override
    public void delet(Client clientDTO) {
    Client client = Client.builder().id(clientDTO.getId())
            .client_name(clientDTO.getClient_name())
            .client_email(clientDTO.getClient_email())
            .build();
         clientDoa.delete(client);

    }
    @Transactional
    @Override
    public boolean login(String email, String pass){
        Client client = Client.builder()
                .client_email(email)
                .pass(pass)
                .build();
        return true;

    }
}
