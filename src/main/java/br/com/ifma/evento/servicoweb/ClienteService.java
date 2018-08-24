package br.com.ifma.evento.servicoweb;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.ResponseWrapper;

import br.com.ifma.evento.dao.ClienteDAO;
import br.com.ifma.evento.modelo.Cliente;

@Path("service")
public class ClienteService {
	@Inject
	ClienteDAO clienteDAO;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("adicionacliente")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionaCliente(Cliente cliente){
		
		if(cliente != null) {
			clienteDAO.insert(cliente);
		}
		
		return Response.ok(cliente).status(201).build();
		
	}
	
	@PUT
	@Path("atualizacliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaCliente(Cliente cliente){
		
		if(cliente != null) {
			
			clienteDAO.update(cliente);
		}
		
		return Response.ok().status(200).build();
	}
	
	@DELETE
	@Path("excluircliente/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirCliente(@PathParam("id") Integer id) {
		
		Cliente cliente = clienteDAO.findById(id);
		
		if(cliente != null) {
			clienteDAO.delete(cliente);
		}
		
		return Response.ok(cliente).status(200).build();
		
	}

}