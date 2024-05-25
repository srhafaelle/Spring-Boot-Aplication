package com.serviciosconector.rest.controllers;

import com.serviciosconector.rest.models.dao.ClientDao;
import com.serviciosconector.rest.models.dto.ClientDto;
import com.serviciosconector.rest.models.entity.Client;
import com.serviciosconector.rest.models.entity.ERol;
import com.serviciosconector.rest.models.entity.RoleEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("security")
public class testSecurityController {
   // @Autowired
    //private SessionRegistry sessionRegistry;
    //
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ClientDao clientDao;

    @GetMapping("/index")

    public String index(){

        return ("this is a test with my spring api");
    }



    /*
    @GetMapping("/session")
    public ResponseEntity<?> getDetailSession(){
        String sessionId ="";
        User userObject = null;

        List<Object> sessions =  sessionRegistry.getAllPrincipals();
        for (Object session :sessions) {
            if(session instanceof User){
              userObject = (User) session;

            }
           List<SessionInformation> sessionInformations =  sessionRegistry.getAllSessions(session, false);
            for (SessionInformation sesioninformation: sessionInformations) {
                    sessionId = sesioninformation.getSessionId();
            }
        }
        Map<String, Object> response = new HashMap<>();
        response.put("response", "hello word");
        response.put("sesionId", sessionId);
        response.put("sessionUser", userObject);

        return ResponseEntity.ok(response);
    }
*/
    @PostMapping("/createCliet")
    public ResponseEntity<?>  createClient(@Valid @RequestBody ClientDto clientDto){
        //esto para poder extraer el rol entity
        Set<RoleEntity> roleEntities = clientDto.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERol.valueOf(role))
                        .build())
                .collect(Collectors.toSet());


        Client client = Client.builder()
                .client_name(clientDto.getClient_name())
                .pass(passwordEncoder.encode(clientDto.getPass()))//aqui en vez de clientDto.getPass() usar el encoder
                .client_email(clientDto.getClient_email())
                .telefono(clientDto.getTelefono())
                .roles(roleEntities)
                .build();

        clientDao.save(client);
        return ResponseEntity.ok(client);

    }
    @DeleteMapping("deletClient")
    public  String deleUser( @RequestBody  String id){
        clientDao.deleteById(String.valueOf(Long.parseLong(id)));
       return  "delet sucssefull".concat(id);
    }
}
