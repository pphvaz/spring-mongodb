package com.pedro.mongoapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.mongoapp.domain.Post;
import com.pedro.mongoapp.repository.PostRepository;
import com.pedro.mongoapp.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
}
