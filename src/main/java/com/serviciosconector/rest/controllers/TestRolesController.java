package com.serviciosconector.rest.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class TestRolesController {

    @GetMapping("accesAdmin")

    public String acccesAdmin(){
    return "rol de admin";
    }

   @GetMapping("accesUser")
   @PreAuthorize("hasAnyRole('USER')")
   public String acccesUser(){
        return "rol de User";
    }

    @GetMapping("accesInvited")
    @PreAuthorize("hasAnyRole('INVITED')")  //esta es otra forma de dar acceso por roles me gusto esta
    public String accceInvited(){
        return "rol de Invitado";
    }


}
