package com.antoniovelasco.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antoniovelasco.blog.dto.PostResponseDTO;
import com.antoniovelasco.blog.service.PostService;


@RestController
@RequestMapping("/api/posts")
@CrossOrigin
public class PostController {
	
	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping()
	public List<PostResponseDTO> getAllPosts(){
		return postService.getAllPosts();
	}
	
	@GetMapping("/{id}")
	public PostResponseDTO getPost(@PathVariable Long id) {
		return postService.getPostById(id);
	}
	
	@PostMapping()
	public PostResponseDTO createPost(@RequestBody PostResponseDTO postResponse) {		
		return postService.createPost(postResponse);
	}
	

}
