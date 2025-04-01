package com.blogpostagens.blog_api2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogpostagens.blog_api2.model.Post;
import com.blogpostagens.blog_api2.repository.PostRepository;



@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(){
		return postRepository.findAll();			
	}
	
	public Optional<Post> findById(Long id){
		return postRepository.findById(id);
	}
	
	public Post save(Post post) {
		return postRepository.save(post);
	}
	
	public Post update(Post post) {
	    // Verifique se o post existe antes de tentar atualizar
	    if (post.getId() == null || !postRepository.existsById(post.getId())) {
	        throw new IllegalArgumentException("Post não encontrado para atualização.");
	    }
	    return postRepository.save(post); // Vai atualizar se o post já existir, senão, cria um novo
	}
	public void delete(Long id) {
		postRepository.deleteById(id);
	}
	
	public boolean existById(Long id) {
		return postRepository.existsById(id);
	}
	
}
