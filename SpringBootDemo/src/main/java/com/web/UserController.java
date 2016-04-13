package com.web;

/**
 * Rest API to perform CRUD operation for User.
 * @author manojp
 * @dated 12/04/2016
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDto;
import com.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<UserDto> getUserList() {
		List<UserDto> userList = userService.findAll();
		return userList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDto getUser(@PathVariable Long id) {
		UserDto user = userService.find(id);
		return user;
	}

	@RequestMapping(value = "/create", method=RequestMethod.POST)
	public UserDto createUser(@RequestBody UserDto userDto) {
		
		if(userDto != null){
			userDto = userService.create(userDto);
			System.out.println("User creation successful: " + String.valueOf(userDto.getId()));
		} else {
			throw new RuntimeException("Invalid User data.");
		}
		
		return userDto;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		userService.delete(id);
		System.out.println("User deleted successfully.");
	}

}
