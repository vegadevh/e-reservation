/**
 * 
 */
package com.platzi.ereservation.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.bussiness.service.ClientService;
import com.platzi.ereservation.model.Client;
import com.platzi.ereservation.view.resources.vo.ClientVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web del cliente
 * @author vegad
 *
 */
@RestController
@RequestMapping("/api/client") //Para recibir peticiones, para ser consumido en otros proyectos
@Api(tags="client")
public class ClientResource {
	//Enlazar con  el servicio
	private final ClientService clienteService;
	
	public ClientResource(ClientService clientService) {
		this.clienteService=clientService;
	}
	//RequestBody
	
	@PostMapping //Relacionado a la operacion de creacion
	@ApiOperation(value="Create Client", notes="Servicio para la creacion de clientes")
	@ApiResponses(value= {@ApiResponse(code=201, message="Cliente creado correctamente"),
			@ApiResponse(code=400, message="Solicitud invalida")}) //ApiResponses engloba todas las respuestas y ApiResponse un en particular
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
	@ApiOperation(value="Update Client", notes="Servicio para actualizar un clientes")
	@ApiResponses(value= {@ApiResponse(code=201, message="Cliente actualizado correctamente"),
			@ApiResponse(code=404, message="Cliente no encontrado")})
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
	@ApiOperation(value="Delete Client", notes="Servicio para eliminar un clientes")
	@ApiResponses(value= {@ApiResponse(code=201, message="Cliente eliminado correctamente"),
			@ApiResponse(code=404, message="Cliente no encontrado")})
	public void removeClient(@PathVariable("id") String id) {
		Client client = this.clienteService.findById(id);
		if(client != null) {
			this.clienteService.delete(client);
		}
		
	}
	@GetMapping
	@ApiOperation(value="List of Clients", notes="Servicio para listar un clientes")
	@ApiResponses(value= {@ApiResponse(code=201, message="Cliente encontrados correctamente"),
			@ApiResponse(code=404, message="Clientes no encontrados")})
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok(this.clienteService.findAll());
	}
	
	
}
