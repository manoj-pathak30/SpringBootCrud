package com.mapper;

import java.util.ArrayList;
import java.util.List;

import com.domain.User;
import com.dto.UserDto;

public class UserMapper {

	public static User mapUserDto(UserDto userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setAddress(userDto.getAddress());
		
		return user;
	}

	public static UserDto mapUser(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setAddress(user.getAddress());

		return userDto;
	}

	public static List<UserDto> mapUserList(List<User> userList) {

		List<UserDto> userDtoList = new ArrayList<>();
		for (User user : userList) {
			userDtoList.add(mapUser(user));
		}

		return userDtoList;
	}
}
