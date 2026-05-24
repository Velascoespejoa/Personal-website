package com.antoniovelasco.blog.post;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

	PostResponseDTO toPostResponse(Post post);
	
	
	
	
	Post PostRequestToPost(PostResponseDTO postRequest);
	
	List<PostResponseDTO> toPostsResponse(List<Post> posts);
}
