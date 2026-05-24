package com.antoniovelasco.blog.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.antoniovelasco.blog.dto.PostResponseDTO;
import com.antoniovelasco.blog.model.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {

	PostResponseDTO toPostResponse(Post post);
	
	
	
	
	Post PostRequestToPost(PostResponseDTO postRequest);
	
	List<PostResponseDTO> toPostsResponse(List<Post> posts);
}
