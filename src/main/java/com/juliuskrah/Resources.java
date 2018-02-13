package com.juliuskrah;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Resources {
	private static final Logger LOGGER = Logger.getLogger(Resources.class.getName());

	@Produces
	@ApplicationScoped
	public EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("javaee8PU");

	}

	public void destroy(@Disposes EntityManagerFactory factory) {
		factory.close();
		LOGGER.log(Level.INFO, "Closed entity manager factory");

	}

	@Produces
	@RequestScoped
	public EntityManager create(EntityManagerFactory emf) {
		return emf.createEntityManager();
	}

}
