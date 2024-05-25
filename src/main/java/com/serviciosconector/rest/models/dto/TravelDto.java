package com.serviciosconector.rest.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class TravelDto implements Serializable {
    String travel_id;
    String driver_id;
    Date travel_date;
    String departure_location;
    String travelVehicle;
    String amountTravel;
    String destination_location;


}
