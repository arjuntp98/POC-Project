package com.poc.shoecart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poc.shoecart.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
