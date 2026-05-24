package com.antoniovelasco.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.antoniovelasco.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
