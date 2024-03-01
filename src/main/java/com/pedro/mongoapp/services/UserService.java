package com.pedro.mongoapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.mongoapp.domain.User;
import com.pedro.mongoapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired //Injeção de dependencia automatica onde o Sprng instancia automaticamente o Repo
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
