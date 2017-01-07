package com.soap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soap.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User findUserByUsername(String username);

}
