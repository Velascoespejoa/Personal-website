package com.antoniovelasco.blog.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "posts")
public class Post {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String body;
	//create_at
	//update_at
	
	@ManyToOne
	@JoinColumn(name = "creador_id")
	@JsonManagedReference
	private User creador;
}
