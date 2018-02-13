package com.juliuskrah.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = -7241782434187812334L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;

	private String firstName;

	private String lastName;

	private LocalDate dateOfBirth;

	private LocalDateTime createdDate;

	private LocalDateTime modifiedDate;

}
