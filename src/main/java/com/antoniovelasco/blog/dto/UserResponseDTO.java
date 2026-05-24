package com.antoniovelasco.blog.dto;

import lombok.Data;

@Data
public class UserResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String nick;
    private String email;
}
