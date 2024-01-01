package com.user.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.model.User;

public interface UserRepository extends JpaRepository<User,String>{

}
