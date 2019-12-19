package com.dompetku.services;

import java.util.List;

import com.dompetku.entity.Client;

public interface IClientService {
	
	List<Client> getClient();
	Client createClient(Client client);
	Client updateClient(int clientId, Client client);
	Client getClient(int clientId);
	boolean deleteClient(int clientId);
}
