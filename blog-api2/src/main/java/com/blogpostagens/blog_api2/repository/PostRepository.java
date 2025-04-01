package com.blogpostagens.blog_api2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpostagens.blog_api2.model.Post;



@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByTitulo(String titulo);
}
