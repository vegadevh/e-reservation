/**
 * 
 */
package com.platzi.ereservation.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.bussiness.service.ClientService;
import com.platzi.ereservation.model.Client;
import com.platzi.ereservation.view.resources.vo.ClientVo;

/**
 * Clase que representa el servicio web del cliente
 * @author vegad
 *
 */
@RestController
@RequestMapping("/api/client") //Para recibir peticiones, para ser consumido en otros proyectos
public class ClientResource {
	//Enlazar con  el servicio
	private final ClientService clienteService;
	
	public ClientResource(ClientService clientService) {
		this.clienteService=clientService;
	}
	//RequestBody
	
	@PostMapping //Relacionado a la operacion de creacion
	public ResponseEntity<Client> createClient(@RequestBody ClientVo clientvo){
		Client client = new Client();
		client.setId(clientvo.getId());
		client.setName(clientvo.getName());
		client.setLastname(clientvo.getLastname());
		client.setIdentification(clientvo.getIdentification());
		client.setAddress(clientvo.getAddress());
		client.setPhone(clientvo.getPhone());
		client.setEmail(clientvo.getEmail());
		
		return new ResponseEntity<>(this.clienteService.create(client), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}") //Relacionado a la operacion de creacion
	public ResponseEntity<Client> updateClient(@PathVariable("id") String id, ClientVo clientvo){
		
		Client client = this.clienteService.findById(id);
		if(client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}else {
			client.setId(clientvo.getId());
			client.setName(clientvo.getName());
			client.setLastname(clientvo.getLastname());
			client.setIdentification(clientvo.getIdentification());
			client.setAddress(clientvo.getAddress());
			client.setPhone(clientvo.getPhone());
			client.setEmail(clientvo.getEmail());
		}
		
		return new ResponseEntity<>(this.clienteService.create(client), HttpStatus.OK);
	}
	
	@DeleteMapping
	public void removeClient(@PathVariable("id") String id) {
		Client client = this.clienteService.findById(id);
		if(client != null) {
			this.clienteService.delete(client);
		}
		
	}
	
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok(this.clienteService.findAll());
	}
	
	
}
