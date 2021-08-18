package com.hung.springh2.service.impl;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.springh2.model.User;
import com.hung.springh2.repository.UserRepository;
import com.hung.springh2.request.AddUserRequest;
import com.hung.springh2.service.UserService;


@Service
public class UserServicerImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public JSONObject getListUser() {
		// TODO Auto-generated method stub
		JSONObject data = new JSONObject();
		List<User> lst = userRepository.findAll();
		data.put("data", lst);
		return data;
	}
	
	@Override
	public JSONObject addCustomer(AddUserRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPwd());
		user = userRepository.save(user);
		JSONObject data = new JSONObject();
		data.put("user", user);
		return data;
	}

}
