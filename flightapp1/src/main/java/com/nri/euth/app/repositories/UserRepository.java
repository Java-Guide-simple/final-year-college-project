package com.nri.euth.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nri.euth.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmailId(String emailId);

}
