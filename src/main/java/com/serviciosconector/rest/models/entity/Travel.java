package com.serviciosconector.rest.models.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.swing.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "travel")
public class Travel implements Serializable {
    @Id
            @Column(name = "travel_id")
            @GeneratedValue(strategy = GenerationType.IDENTITY)
   String travel_id;
    @Column(name = "client_id")
    String client_id;
    @Column(name = "driver_id")
    String driver_id;
    @Column(name = "travel_date")
     Date travel_date;
    @Column(name = "travel_time")
     Timer travel_time;
    @Column(name = "departure_location")
     String departure_location;
    @Column(name = "destination_location")
    String destination_location;
    @Column(name = "travelVehicle")
    String travelVehicle;
    @Column(name = "amountTravel")
    String amountTravel;
}
