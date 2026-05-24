package com.antoniovelasco.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.antoniovelasco.blog.dto.PostResponseDTO;
import com.antoniovelasco.blog.model.Post;
import com.antoniovelasco.blog.repository.PostRepository;
import com.antoniovelasco.blog.repository.UserRepository;

@Service
public class PostService {
	
	private final PostRepository postRepo;
	private final UserRepository userRepo;
	
	public PostService(PostRepository postRepo, UserRepository userRepo) {
		this.postRepo = postRepo;
		this.userRepo = userRepo;
	}
	
	public List<PostResponseDTO> getAllPosts(){
		
		List<Post> posts = postRepo.findAll();
		List<PostResponseDTO> postsResponse = new ArrayList<>();
		
		for (Post post : posts) {
			
			PostResponseDTO postResponse = new PostResponseDTO();
			
			postResponse.setBody(post.getBody());
			postResponse.setId(post.getId());
			postResponse.setTitle(post.getTitle());
			
			postsResponse.add(postResponse);
		}
		return postsResponse;
	}

	public PostResponseDTO getPostById(Long id) {
		
		Post post = postRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Post not found"));	
		
		PostResponseDTO postResponse = new PostResponseDTO();
		
		postResponse.setBody(post.getBody());
		postResponse.setId(post.getId());
		postResponse.setTitle(post.getTitle());
				
		return postResponse;
	}
	
	
	
	

}
