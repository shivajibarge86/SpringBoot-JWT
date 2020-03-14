package com.inventory.productinventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.productinventory.entities.Client;

/** This the Client Repository interface  */ 
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {



}
