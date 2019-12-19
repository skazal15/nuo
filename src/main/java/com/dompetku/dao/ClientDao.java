package com.dompetku.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dompetku.entity.Client;

@Transactional
@Repository

public class ClientDao implements IClientDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClient() {
		
		String hql = "FROM Client as atcl ORDER BY atcl.id";
		return (List<Client>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public Client getClient(int clientId) {
		return entityManager.find(Client.class, clientId);
	}
	
	@Override
	public Client createClient(Client client) {
		entityManager.persist(client);
		Client c = getLastInsertedClient();
		return c;
	}
	
	@Override
	public Client updateClient(int clientId, Client client) {
		Client clientFromDB = getClient(clientId);
		clientFromDB.setName(client.getName());
		clientFromDB.setDdgital(client.getDdgital());
		clientFromDB.setNdigital(client.getNdigital());
		clientFromDB.setJmlh(client.getJmlh());
		clientFromDB.setTdigital(client.getTdigital());
		clientFromDB.setNtdigital(client.getNtdigital());
		clientFromDB.setStatus(client.getStatus());
		
		entityManager.flush();
		
		Client updateClient = getClient(clientId);
		
		return updateClient;
	}
	
	@Override
	public boolean deleteClient(int clientId) {
		Client client = getClient(clientId);
		entityManager.remove(client);
		
		boolean status = entityManager.contains(client);
		if(status) {
			return false;
		}
		return true;
	}
	
	private Client getLastInsertedClient() {
		String hql = "from Client order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Client client = (Client)query.getSingleResult();
		return client;
	}
	

}
