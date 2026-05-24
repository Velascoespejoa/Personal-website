package com.antoniovelasco.blog.post;

import lombok.Data;

@Data
public class PostResponseDTO {

	private Long id;	
	private String title;
	private String body;
}
