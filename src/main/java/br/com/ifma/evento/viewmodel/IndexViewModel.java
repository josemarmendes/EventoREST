package br.com.ifma.evento.viewmodel;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.Binder;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;

import br.com.ifma.evento.dao.ClienteDAO;
import br.com.ifma.evento.dao.EventoDAO;
import br.com.ifma.evento.modelo.Cliente;
import br.com.ifma.evento.modelo.Evento;

public class IndexViewModel {
	
	private ClienteDAO clienteDAO;
	private EventoDAO eventoDAO;
	private String nome;
	private String cpf;
	private String nomeEvento;
	private Combobox cmbCliente;
	private Cliente cliente;
	private Evento evento;
	private List<Cliente> colClientes;
	private List<Evento> colEventos;
	
	@Init
	public void init() throws NamingException {
		clienteDAO = InitialContext.doLookup("java:global/EventoREST/ClienteDAO");
		eventoDAO = InitialContext.doLookup("java:global/EventoREST/EventoDAO");
		cliente = new Cliente();
		evento = new Evento();
		colClientes = clienteDAO.findAll();
		colEventos = eventoDAO.findAll();
	}
	
	@Command("salvarCliente")
	@NotifyChange("*")
	public void cadastrarCliente() {
		
		System.out.println(cliente.getNomeCliente());
		clienteDAO.insert(cliente);
		cliente = new Cliente();
		Clients.showNotification("Cliente salvo com sucesso");
	
	}
	
	@Command("salvarEvento")
	@NotifyChange("*")
	public void cadastrarEvento() {
		
		System.out.println(evento.getNomeEvento());
		eventoDAO.insert(evento);
		evento = new Evento();
		Clients.showNotification("Evento salvo com sucesso");
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public Combobox getCmbCliente() {
		return cmbCliente;
	}

	public void setCmbCliente(Combobox cmbCliente) {
		this.cmbCliente = cmbCliente;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Cliente> getColClientes() {
		return colClientes;
	}
	
	public List<Evento> getColEventos() {
		return colEventos;
	}
	
}
