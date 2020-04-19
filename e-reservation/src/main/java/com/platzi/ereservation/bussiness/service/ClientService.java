/**
 * 
 */
package com.platzi.ereservation.bussiness.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.bussiness.repository.IClientRepository;
import com.platzi.ereservation.model.Client;

/**
 * @author vegad
 *
 */
@Service
@Transactional(readOnly = true) 
public class ClientService {
	private final IClientRepository clientRepository;
	
	public ClientService(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
		
	}
	//operaciones de bd
	/**
	 * Metodo para realizar operacion de guardar un cliente
	 * @param client
	 * @return
	 */
	
	@Transactional
	public Client create(Client client) {
		return this.clientRepository.save(client);
	}
	//La entidad que ingresa entra con un valor para 'client'
	/**
	 * Metodo de actualizacion
	 * @param client
	 * @return
	 */
	@Transactional
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}
	//Sin valor de retorno
	/**
	 * Eliminar un cliente
	 * @param client
	 */
	@Transactional
	public void delete(Client client) {
		this.clientRepository.delete(client);
	}
	//------------------El servicio consume los metodos del repositorio para utilizarlos.
	/**
	 * Metodo para obtener un client por medio de la identificacion
	 * @param identification
	 * @return
	 */
	@Transactional(readOnly = true) //Indica aquellos que no tengan una anotacion @Transactional seran unicamente de lectura, como las queries
	public Client findById(String id) {
		return this.clientRepository.findByIdentification(id);
	}
	@Transactional(readOnly = true)
	public List<Client> findAll(){
		return this.clientRepository.findAll();
	}
}
