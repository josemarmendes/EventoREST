package br.com.ifma.evento.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
 
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("evento");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}
