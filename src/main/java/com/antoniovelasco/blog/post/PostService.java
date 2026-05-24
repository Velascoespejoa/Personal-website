package com.antoniovelasco.blog.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.antoniovelasco.blog.user.UserRepository;

@Service
public class PostService {
	
	private final PostRepository postRepo;
	private final PostMapper postMap;
	private final UserRepository userRepo;
	
	public PostService(PostRepository postRepo, UserRepository userRepo, PostMapper postMap) {
		this.postRepo = postRepo;
		this.userRepo = userRepo;
		this.postMap = postMap;
	}
	
	public List<PostResponseDTO> getAllPosts(){
		
		List<Post> posts = postRepo.findAll();
		List<PostResponseDTO> postsResponse = postMap.toPostsResponse(posts);
		
		return postsResponse;
	}

	public PostResponseDTO getPostById(Long id) {
		
		Post post = postRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Post not found"));	
		
		PostResponseDTO postResponse = postMap.toPostResponse(post);		
		return postResponse;
	}

	public PostResponseDTO createPost(PostResponseDTO postResponse) {
		
		Post nuevoPost = postMap.PostRequestToPost(postResponse);
		postRepo.save(nuevoPost);
		return postResponse;
	}
	
	
	
	
	
	

}
