package com.serviciosconector.rest.controllers;

import com.serviciosconector.rest.models.dto.ClientDto;
import com.serviciosconector.rest.models.entity.Client;
import com.serviciosconector.rest.services.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/cliet")
public class ClientController {
    @Autowired
private IClient clientScervices;
// crear cliente
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client clientDTO){
        Client clientSave = clientScervices.save(clientDTO);
          return      Client.builder().id(clientSave.getId())
                .client_name(clientSave.getClient_name())
                .client_email(clientSave.getClient_email())
                .build();

    }

//modificar cliente
    @PutMapping("update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Client update(Client clientDTO){

        Client clientUpdate = clientScervices.save(clientDTO);
        return      Client.builder().id(clientUpdate.getId())
                .client_name(clientUpdate.getClient_name())
                .client_email(clientUpdate.getClient_email())
                .build();
    }

//eliminar cliente

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delet(@PathVariable String name, @PathVariable String pass){
      Map<String, Object> response= new HashMap<>();
     try{
         Client clientDele = clientScervices.singIn(name, pass);
         clientScervices.delet(clientDele);
        return new ResponseEntity<>(clientDele, HttpStatus.NO_CONTENT);
     }catch (DataAccessException e){
      //  response.put("Mensaje", e.getMessage());
      //  response.put("cliente", null);
         return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
     }
    }
//buscar cliente   comento uso de busqueda por id.. posible uso en el dashboard
  /*  @GetMapping("show")
    @ResponseStatus(HttpStatus.OK)

    public ClientDto showbyId(@PathVariable String id){
        Client client = clientScervices.findById(id);

        return      ClientDto.builder().id(client.getId())
                .client_name(client.getClient_name())
                .client_email(client.getClient_email())
                .build();

    }*/
@PostMapping("login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean login(@PathVariable String email, String pass){

       // Client client = clientScervices.login(email, pass);
        return true;
}

}
