/**
 * 
 */
package com.platzi.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase tabla reserva
 * @author vegad
 *
 */
@Data
@Entity
@Table(name="Booking")
public class Booking {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idBooking;
	//En Java existen distintas formas de definir una fecha, por lo tanto es necesario especificarlo
	//@Temporal para especificar 'TemporalType'
	@Temporal(TemporalType.DATE)
	private Date dateIn;
	@Temporal(TemporalType.DATE)
	private Date dateOut;
	private int quantity;
	private String descBooking;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Client Client;

}
