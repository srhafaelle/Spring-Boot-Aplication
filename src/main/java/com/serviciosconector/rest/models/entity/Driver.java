package com.serviciosconector.rest.models.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "drivers")
public class Driver implements Serializable {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
    String id;
    @Column(name="driver_name")
    String driver_name;
    @Column(name ="driver_license_number")
    String driver_license_number;
    @Column(name ="passDriver")
    String passDriver;
    /*
    @Column(name="imageDriver")
    String imageDriver;
    @Column(name="imageLicense")
    String imageLicense;
    @Column(name="plateDriver")

     */
    String plateDriver;
    @Column(name="vehicleDriver")
    String vehicleDriver;
    @Column(name="typeDriver")
    String typeVehicle;
    /*
    @Column(name="vehiCleTwo")
    String vehicleTwo;
    @Column(name="plateTwo")
    String platetwo;
    @Column(name="typeVehicleTwo")
    String typeVehicleTwo;
    */
    @Column(name="driver_email")
    String driver_email;






}
