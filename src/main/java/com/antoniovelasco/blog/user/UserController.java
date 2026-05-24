package com.antoniovelasco.blog.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping()
	public List<UserResponseDTO> getUsers() {		
		return userService.getAllUsers();		
	}

	@GetMapping("/{id}")
	public UserResponseDTO getUser(@PathVariable Long id) {		
		return userService.getUserById(id);		
	}	
	
	// ¡¡¡¡¡ NO TIENE SENTIDO QUE DEVUELVA UN "UserRegisterDTO" !!!!!
	@PostMapping()
	public UserRegisterDTO createUser(@RequestBody UserRegisterDTO userRegisterDTO) {
		return userService.createUser(userRegisterDTO);		
	}
	
	// HAY QUE trabajar en hacer PATCH PERSONALIZADOS y con DTO DISTINTOS
	@PutMapping("/{id}")
	public UserRegisterDTO updateUser(@PathVariable Long id, @RequestBody UserRegisterDTO userRegisterDTO) {
			return userService.updateUser(id, userRegisterDTO);
	}
	
	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
