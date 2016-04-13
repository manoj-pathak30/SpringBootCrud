package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.User;
import com.dto.UserDto;
import com.mapper.UserMapper;

@Service
@Transactional
class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDto> findAll() {

		List<User> userList = userRepository.findAll();
		if (userList != null && !userList.isEmpty())
			return UserMapper.mapUserList(userList);
		else
			return null;
	}

	@Override
	public UserDto find(Long id) {

		User user = userRepository.findOne(id);
		if (user != null)
			return UserMapper.mapUser(user);
		else 
			throw new RuntimeException("No user found with id :"+id);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public UserDto create(UserDto userDto) {
		User user = UserMapper.mapUserDto(userDto);
		userRepository.saveAndFlush(user);
		userDto.setId(user.getId());
		System.out.println("User created Successfully!!! " + user.getId());

		return userDto;
	}
}
