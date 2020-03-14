package com.inventory.productinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.productinventory.entities.Client;
import com.inventory.productinventory.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Client> getAllClients(){
		return clientService.getAllClients();
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client newClient){
		return clientService.save(newClient);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Client findClientById(@RequestParam("id") String id){
		return clientService.findById(Long.valueOf(id));
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public String delete(@RequestParam("id") String id){
			clientService.delete(Long.valueOf(id));
		 return "Client deleted successfully";
	}
	
}
