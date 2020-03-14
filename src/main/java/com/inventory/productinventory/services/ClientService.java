package com.inventory.productinventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.productinventory.dao.ClientRepository;
import com.inventory.productinventory.entities.Client;

@Service
public class ClientService {

   @Autowired
   private ClientRepository clientRepository;

	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		return clientRepository.findOne(id);
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	public void delete(Long id) {
		 clientRepository.delete(id);
	}
	
}

