package br.com.ifma.evento.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaUpdate;
import javax.transaction.Transactional;

import br.com.ifma.evento.modelo.Cliente;
import br.com.ifma.evento.util.JPAUtil;

@Stateless
public class ClienteDAO {
	
	@PersistenceContext(unitName="evento")
	public EntityManager manager = new JPAUtil().getEntityManager();

	@Transactional
	public Cliente insert(Cliente cliente) {

		manager.persist(cliente);
		
		return cliente;
		
	}
	
	@Transactional
	public Cliente update(Cliente cliente) {
		manager.merge(cliente);
		return cliente;
	}
	
	@Transactional
	public void delete(Cliente cliente) {
		Cliente c = manager.merge(cliente);
		manager.remove(c);
	}

	public Cliente findById(Integer clienteId) {
		return manager.find(Cliente.class, clienteId);
	}

	public List<Cliente> findAll() {
		 
		String sql = "Select c From Cliente c order by c.nomeCliente";
		Query q = manager.createQuery(sql);
		
		List<Cliente> clientes = q.getResultList();
		
		return clientes;
	}
	
}
