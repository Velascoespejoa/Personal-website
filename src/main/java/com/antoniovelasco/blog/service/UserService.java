package com.antoniovelasco.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.antoniovelasco.blog.dto.UserRegisterDTO;
import com.antoniovelasco.blog.dto.UserResponseDTO;
import com.antoniovelasco.blog.mapper.UserMapper;
import com.antoniovelasco.blog.repository.UserRepository;
import com.antoniovelasco.blog.model.User;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	private final UserMapper userMap;
	
	public UserService(UserRepository userRepo, UserMapper userMap) {
		this.userRepo = userRepo;
		this.userMap = userMap;
	}
	
	public List<UserResponseDTO> getAllUsers(){
		
		List<User> users = userRepo.findAll();
		List<UserResponseDTO> usersDTOs = userMap.toResponseDTOs(users);
		 
		return usersDTOs;		
	}
	
	public UserResponseDTO getUserById(Long id) {

		User user = userRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("User not found"));			
		
		return userMap.toResponseDTO(user);					
		
	}

	 //¡¡¡¡¡ NO TIENE SENTIDO QUE DEVUELVA UN "UserRegisterDTO" !!!!!
	public UserRegisterDTO createUser(UserRegisterDTO userRegisterDTO) {
		
		User user = userMap.userRegisterToUser(userRegisterDTO);
		
		userRepo.save(user);
		
		return userRegisterDTO;
	}
	 //¡¡¡¡¡ NO TIENE SENTIDO QUE DEVUELVA UN "UserRegisterDTO" !!!!!
	// hace falta expandir para modificar campos independientes y validaciones;
	public UserRegisterDTO updateUser(Long id, UserRegisterDTO userRegisterDTO) {
		
		User user = userRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("User not found"));	
		
		user.setEmail(userRegisterDTO.getEmail());
		user.setFirstName(userRegisterDTO.getFirstName());
		user.setLastName(userRegisterDTO.getLastName());
		user.setNick(userRegisterDTO.getNick());
		user.setPassword(userRegisterDTO.getPassword());
		
		userRepo.save(user);
		
		return userRegisterDTO;
	}

	public void deleteUser(Long id) {
		userRepo.deleteById(id);		
	}

}
