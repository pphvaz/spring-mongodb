package com.pedro.mongoapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.mongoapp.domain.Post;
import com.pedro.mongoapp.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	/* 
	O controlador REST acessa o SERVICE
	O serviço acessa o REPOSITORY  
	*/
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
