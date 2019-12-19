package com.dompetku.dao;

import java.util.List;

import com.dompetku.entity.Client;

public interface IClientDao {
	
	List<Client> getClient();
	Client getClient(int clientId);
	Client createClient(Client client);
	Client updateClient(int clientId,Client client);
	boolean deleteClient(int clientId);

}
