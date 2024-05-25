package com.serviciosconector.rest.controllers;

import com.serviciosconector.rest.models.dao.DriverDao;
import com.serviciosconector.rest.models.dto.ClientDto;
import com.serviciosconector.rest.models.dto.DriverDto;
import com.serviciosconector.rest.models.entity.Client;
import com.serviciosconector.rest.models.entity.Driver;
import com.serviciosconector.rest.services.IDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/driver")

public class DriverController {
    @Autowired
    private IDriver driverService;


    //Create Drivers
    @PostMapping("create")
    public Driver Create(@RequestBody Driver driverDto){
         Driver driverSave = driverService.save(driverDto);
         return  Driver.builder()
                 .driver_name(driverDto.getDriver_name())
                 .plateDriver(driverDto.getPlateDriver())
                 .vehicleDriver(driverDto.getVehicleDriver())
                 .build();

    }
    @PutMapping("update")
    public Driver Update(Driver driverDto){
        Driver driverUpdate = driverService.save(driverDto);
        return Driver.builder()
                .vehicleDriver(driverDto.getVehicleDriver())
                .plateDriver(driverDto.getPlateDriver())
                .build();
    }
    @DeleteMapping("delete")
    public ResponseEntity<?> Delete(@PathVariable String id){
        Map<String, Object> response = new HashMap<>();
        try{
            Driver driverDelete = driverService.findById(id);
            driverService.delet(driverDelete);
            return  new ResponseEntity<>(driverDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException e){
            response.put("Mensaje", e.getMessage());
            response.put("Cliente", null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     //--------------------------------

    @GetMapping("show")
    public DriverDto showbyId(@PathVariable String id){

        Driver driver = driverService.findById(id);
      
        return      DriverDto.builder().id(driver.getId())
                .driver_name(driver.getDriver_name())
                .vehicleDriver(driver.getVehicleDriver())
                .build();

    }
    

}
