package com.dompetku.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dompetku.dao.IClientDao;
import com.dompetku.entity.Client;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private IClientDao dao;
	
	@Override
	public List<Client> getClient(){
		return dao.getClient();
	}
	
	@Override
	public Client createClient(Client client) {
		return dao.createClient(client);
	}
	
	@Override
	public Client updateClient(int clientId, Client client) {
		return dao.updateClient(clientId, client);
	}
	
	@Override
	public Client getClient(int clientId) {
		return dao.getClient(clientId);
	}
	
	@Override
	public boolean deleteClient(int clientId) {
		return dao.deleteClient(clientId);
	}
	

}
