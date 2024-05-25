package com.serviciosconector.rest.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "clients")
public class Client implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    String id;
@Column(name = "client_name")
    String client_name;
@Column(name = "client_email")
        @Email
        @NotBlank
        @Size(max = 80)
    String client_email;
@Column (name="pass")
    String pass;
@Column(name="phone")
    String telefono;
@Column(name = "direction")
    String direccion;
@Column(name = "imageuser")
    String imageuser;
@ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
@JoinTable(name = "cliente_roles",
joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<RoleEntity> roles;   //se puede usar list o set cualquera y set no permite duplicar elementos

}
