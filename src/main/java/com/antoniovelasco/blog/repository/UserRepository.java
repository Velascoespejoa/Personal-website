package com.antoniovelasco.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.antoniovelasco.blog.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
