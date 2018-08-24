package br.com.ifma.evento.servicoweb;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.ifma.evento.dao.EventoDAO;
import br.com.ifma.evento.modelo.Evento;

@Path("service")
public class EventoService {
	
	@GET
	@Path("clienteporeventoid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Evento listarClientesPorEvento(@PathParam("id") int id){
		
		Evento evento;
		
		EventoDAO evemtoDAO = new EventoDAO();
		
		evento = evemtoDAO.findByClientePorEventoId(id);
		
		return evento;
		
	}

	@GET
	@Path("clienteporevento/{nomeEvento}")
	@Produces(MediaType.APPLICATION_JSON)
	public Evento listarClientesPorEvento(@PathParam("nomeEvento") String nomeEvento){
		
		Evento evento;
		
		EventoDAO evemtoDAO = new EventoDAO();
		
		evento = evemtoDAO.findByClientePorEvento(nomeEvento);
		
		return evento;
	}
	
	@GET
	@Path("todososclientesporevento/{nomeEvento}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Evento> listarTodosOsClientesPorEvento(@PathParam("nomeEvento") String nomeEvento){
		
		List<Evento> colEventos;
		
		EventoDAO eventoDAO = new EventoDAO();
		
		colEventos = eventoDAO.findAllClientesPorEvento(nomeEvento);
		
		return colEventos;
	}
}