package com.pedro.mongoapp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.mongoapp.domain.User;
import com.pedro.mongoapp.dto.UserDTO;
import com.pedro.mongoapp.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	/* 
	O controlador REST acessa o SERVICE
	O serviço acessa o REPOSITORY  
	*/
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
}
