package com.antoniovelasco.blog.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String nick;
	private String password;
	private String email;
	//create_at
	//update_at

	@OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Post> postsCreados;
	
}
