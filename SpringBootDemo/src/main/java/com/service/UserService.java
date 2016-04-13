package com.service;

import java.util.List;

import com.dto.UserDto;


public interface UserService {

	public List<UserDto> findAll();

	public UserDto find(Long id);

	public void delete(Long id);
	
	public UserDto create(UserDto userDto);
}
