package com.serviciosconector.rest.models.dao;

import com.serviciosconector.rest.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientDao extends CrudRepository<Client, String> {
      Client findByUsername(String username, String pass);

      @Query("SELECT u  FROM Client u WHERE u.client_name = ?1")
      Optional<Client> findClientByClient_name(String client_name);
}
