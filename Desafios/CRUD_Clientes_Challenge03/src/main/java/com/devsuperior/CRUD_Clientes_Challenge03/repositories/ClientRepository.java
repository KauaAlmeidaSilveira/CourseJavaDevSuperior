package com.devsuperior.CRUD_Clientes_Challenge03.repositories;

import com.devsuperior.CRUD_Clientes_Challenge03.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
