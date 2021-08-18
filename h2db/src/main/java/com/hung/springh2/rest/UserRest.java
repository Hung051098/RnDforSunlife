package com.hung.springh2.rest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hung.springh2.request.AddUserRequest;
import com.hung.springh2.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRest {

	@Autowired
	UserService userService;

	@GetMapping("/list_user")
	public JSONObject getListCustomer() {
		return userService.getListUser();
	}


	@PostMapping("/add_user")
	public JSONObject addCustomer(@RequestBody AddUserRequest request) {
		return userService.addCustomer(request);
	}
}
