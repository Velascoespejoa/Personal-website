package com.antoniovelasco.blog.user;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponseDTO toResponseDTO(User user);	
	
	List<UserResponseDTO> toResponseDTOs(List<User> users);
	
	User userRegisterToUser(UserRegisterDTO userRegister);	
	
	
}
