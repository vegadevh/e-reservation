/**
 * 
 */
package com.platzi.ereservation.bussiness.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.ereservation.model.Booking;
import com.platzi.ereservation.model.Client;

/**
 * @author vegad
 *
 */
public interface IBookingRepository extends JpaRepository<Client, String>{
	//Colsultar por fechas
	@Query("Select b from Booking b where b.dateIn=:dateIn and b.dateOut=:dateOut")
	//@Param indicar el parametro que se esta representando
	public List<Booking> find(@Param("dateIn") Date dateIn, @Param("dateOut") Date dateOut);
}
