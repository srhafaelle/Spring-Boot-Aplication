package com.serviciosconector.rest.models.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto implements Serializable {



   @NotBlank
   String client_name;
    @Email
    @NotBlank
   String client_email;
   @NotBlank
   String pass;

   String telefono;

   String direccion;


   private Set<String> roles;

}
