package com.juliuskrah.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotEmpty;

@Named
@RequestScoped
public class Hello {
	// private static final Logger LOGGER = Logger.getLogger(Hello.class.getName());
	@NotEmpty
	private String name;
	private String message;

	public void createMessage() {
		message = "Hello, " + name + "!";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}
}
