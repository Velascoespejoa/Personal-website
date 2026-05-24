package com.antoniovelasco.blog.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.antoniovelasco.blog.dto.UserRegisterDTO;
import com.antoniovelasco.blog.dto.UserResponseDTO;
import com.antoniovelasco.blog.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponseDTO toResponseDTO(User user);	
	
	List<UserResponseDTO> toResponseDTOs(List<User> users);
	
	User userRegisterToUser(UserRegisterDTO userRegister);	
	
	
}
