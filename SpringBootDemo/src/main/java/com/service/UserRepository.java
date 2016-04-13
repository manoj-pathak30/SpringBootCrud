package com.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.User;


interface UserRepository extends  JpaRepository<User, Long>{

}