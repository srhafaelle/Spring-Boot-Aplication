package com.serviciosconector.rest.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="calification")
public class Calification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "valueClient")
    private int  valueClient;
    @Column(name = "valueDriver")
    private int valueDriver;
    @Column(name = "idTravel")
    private String idTravel;



}
