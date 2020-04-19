/**
 * 
 */
package com.platzi.ereservation.bussiness.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.ereservation.model.Client;

/**
 * @author vegad
 *
 */
public interface IClientRepository extends JpaRepository<Client, String>{
	//En caso de tener mas de un usuario con el mismo aapellido generar una lista de Cliente
	public List<Client> findByLastname(String lastname);
	//Acompa;ado de NamedQuery en la clase Client
	public Client findByName(String name);
	//Query para personalizar la cantidad de parametros
	public Client findByIdentification(String identification);
;}
