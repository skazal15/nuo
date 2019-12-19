package com.dompetku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dompetku.entity.Client;
import com.dompetku.services.IClientService;

@Controller
@RequestMapping("cservice")
public class ClientController {
	
	@Autowired
	private IClientService service;
	
	@GetMapping("clients")
	public ResponseEntity<List<Client>> getClient(){
		
		List<Client> clients=service.getClient();
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}
	
	@GetMapping("clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") int id){
		Client client = service.getClient(id);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@PostMapping("clients")
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		Client c = service.createClient(client);
		return new ResponseEntity<Client>(c, HttpStatus.OK);
	}
	
	@PutMapping("clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") int id, @RequestBody Client client){
		Client c = service.updateClient(id, client);
		return new ResponseEntity<Client>(c, HttpStatus.OK);
	}
	
	@DeleteMapping("clients/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") int id){
		boolean isDeleted = service.deleteClient(id);
		if(isDeleted) {
			String repsonseContent = "user deleted";
			return new ResponseEntity<String>(repsonseContent, HttpStatus.OK);
		}
		String error = "tidak bisa dihapus";
		return new ResponseEntity<String>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
