package com.serviciosconector.rest.models.dao;

import com.serviciosconector.rest.models.entity.Calification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasificationDao extends JpaRepository<Calification, String> {
}
