/**
 * 
 */
package com.platzi.ereservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Tabla Cliente
 * @author vegad
 *
 */
@Data
@Entity //Representar la tabla de bd
@Table(name = "Client")
@NamedQuery(name="Client.findByName", query="Select c from Client c where c.name = ?1")
public class Client {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String id;
	private String name;
	private String lastname;
	private String identification;
	private String address;
	private String phone;
	private String email;
	
	@OneToMany(mappedBy="Client")
	private Set<Booking> Booking;
	
	public Client() {
		
	}
	
	
}
