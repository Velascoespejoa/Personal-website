package com.antoniovelasco.blog.user;

import lombok.Data;

@Data
public class UserRegisterDTO {
	
    private String firstName;
    private String lastName;
    private String nick;
    private String email;
    private String password;
    
}
