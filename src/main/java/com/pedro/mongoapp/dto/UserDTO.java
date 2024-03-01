package com.pedro.mongoapp.dto;

import java.io.Serializable;

import com.pedro.mongoapp.domain.User;

/*
É um objeto que tem o papel de carregar alguns dados específicos das entidades de forma simples,
podendo inclusive "projetar" apenas alguns dados da entidade original. 
Por exemplo: tenho uma entidade com 30 tipos de dados, mas preciso apenas de 3. o DTO converte 
essa entidade de 30 objetos para apenas 3.
*/

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
