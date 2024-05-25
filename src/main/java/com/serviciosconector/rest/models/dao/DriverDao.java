package com.serviciosconector.rest.models.dao;

import com.serviciosconector.rest.models.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DriverDao extends CrudRepository<Driver,String> {
}
