package com.serviciosconector.rest.models.dto;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
@Builder
public class DriverDto implements Serializable {

    final  String id;
    final  String driver_name;
    final String driver_license_number;
    final String passDriver;
    final String imageDriver;
    final String imageLicense;
    final String plateDriver;
    final String vehicleDriver;
    final String typeVehicle;
    final String vehicleTwo;
    final String platetwo;
    final String TypeVehicleTwo;
}
