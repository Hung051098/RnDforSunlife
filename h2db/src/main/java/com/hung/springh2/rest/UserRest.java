package com.hung.springh2.rest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.hung.springh2.request.AddUserRequest;
import com.hung.springh2.service.UserService;

@RefreshScope
@RestController
@RequestMapping("/user")
public class UserRest {

	@Value("${sample.example}")
	private String example;
	
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


	@GetMapping("/getconfig")
	public JSONObject getconfig( ) {
		JSONObject data = new JSONObject();
		data.put("data", example);
		return data;
	}
}
