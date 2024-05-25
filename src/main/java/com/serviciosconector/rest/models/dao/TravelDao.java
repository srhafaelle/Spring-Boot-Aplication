package com.serviciosconector.rest.models.dao;

import com.serviciosconector.rest.models.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelDao extends JpaRepository<Travel, String> {
}
