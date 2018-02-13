package com.juliuskrah.controller.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.juliuskrah.entity.Student;

@Path("/v1.0/students")
public class StudentEndPoint {
	@Inject
	private EntityManager em;

	@PostConstruct
	private void initialize() {
		Student student = new Student();
		student.setFirstName("Julius");
		student.setLastName("Krah");
		student.setDateOfBirth(LocalDate.of(1990, Month.APRIL, 04));
		student.setCreatedDate(LocalDateTime.now());
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
	}

	@GET
	public List<Student> students() {
		return em.createQuery("FROM Student", Student.class).getResultList();
	}
}
