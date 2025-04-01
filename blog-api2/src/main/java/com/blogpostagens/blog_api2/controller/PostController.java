package com.blogpostagens.blog_api2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpostagens.blog_api2.model.Post;
import com.blogpostagens.blog_api2.service.PostService;




@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping
	public List<Post> getAllPosts() {
		return postService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Long id){
		Optional<Post> post = postService.findById(id);
		return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
		 if (post.getId() != null) {
		        // Retorna um erro 400 (Bad Request) caso o 'id' esteja presente
		        return ResponseEntity.badRequest().body(null);
		    }
		Post createdPost = postService.save(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable Long id){
		
		if (id == null || id <= 0) {
	        return ResponseEntity.badRequest().build();  // Retorna 400 se o 'id' for inválido
	    }

	    // Verificar se o post existe
	    if (!postService.existById(id)) {
	        return ResponseEntity.notFound().build();  // Retorna 404 se o post não for encontrado
	    }
		
		postService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
