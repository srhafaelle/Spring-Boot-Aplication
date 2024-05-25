package com.serviciosconector.rest.services.implems;

import com.serviciosconector.rest.models.dao.DriverDao;
import com.serviciosconector.rest.models.dto.DriverDto;
import com.serviciosconector.rest.models.entity.Driver;
import com.serviciosconector.rest.services.IDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class DriverImplements implements IDriver {
    @Autowired
    private DriverDao driverDao;


    @Transactional
    @Override
    public Driver save(Driver driverdto) {
        Driver driver = Driver.builder()
                .id(driverdto.getId())
                .driver_name(driverdto.getDriver_name())
                .driver_license_number(driverdto.getDriver_license_number())
                .passDriver(driverdto.getPassDriver())
                .typeVehicle(driverdto.getTypeVehicle())
                .driver_email(driverdto.getDriver_email())
                .build();
        return driverDao.save(driver);

    }
    @Transactional(readOnly = true)
    @Override
    public Driver findById(String id) {
        return driverDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delet(Driver driverDto) {
        Driver driver = findById(driverDto.getId());
        driverDao.delete(driver);
    }
}
