/**
 * 
 */
package com.platzi.ereservation.view.resources.vo;

import lombok.Data;

/**
 * Simil de la clase Client pero sin anotaciones con la finalidad de solucionar el mapeo de los JPA
 * Tabla Cliente
 * @author vegad
 *
 */
@Data
public class ClientVo {
	private String id;
	private String name;
	private String lastname;
	private String identification;
	private String address;
	private String phone;
	private String email;
}
