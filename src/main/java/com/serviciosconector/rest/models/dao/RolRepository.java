package com.serviciosconector.rest.models.dao;

import com.serviciosconector.rest.models.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<RoleEntity, Long> {
}
