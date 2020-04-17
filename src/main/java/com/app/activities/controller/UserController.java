package com.app.activities.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.activities.constants.Constants;
import com.app.activities.model.User;
import com.app.activities.model.json.MessageEnvelope;
import com.app.activities.model.json.MessageHeaders;
import com.app.activities.model.json.UserResponseBody;
import com.app.activities.service.UserService;
import com.app.activities.util.Utils;

@RestController
@RequestMapping("/api")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);


	@Autowired
	private UserService userService;

	@GetMapping(value="/get/users")
	public MessageEnvelope<UserResponseBody> listUser() {

		MessageEnvelope<UserResponseBody> userResponseEnvelope = new MessageEnvelope<UserResponseBody>();

		UserResponseBody body = new UserResponseBody();
		body.setUserList(userService.findAll());
		userResponseEnvelope.setBody(body);

		MessageHeaders headers = Utils.messageHeader(Constants.SUCCESS, Constants.EMPTY_STRING);
		userResponseEnvelope.setHeader(headers);

		return userResponseEnvelope;
	}

	@PostMapping(value = "/createUser")
	public MessageEnvelope<UserResponseBody> createUser(@RequestBody User user) {
		MessageEnvelope<UserResponseBody> userResponseEnvelope = new MessageEnvelope<UserResponseBody>();
		userService.createUser(user);
		MessageHeaders headers = Utils.messageHeader(Constants.SUCCESS, Constants.USER_CREATED);
		userResponseEnvelope.setHeader(headers);
		return userResponseEnvelope;
	}

	@GetMapping(value = "/get/userById/{id}")
	public MessageEnvelope<UserResponseBody> getUserById(@PathVariable long id) {
		MessageEnvelope<UserResponseBody> userResponseEnvelope = new MessageEnvelope<UserResponseBody>();
		User user = userService.getUserById(id);
		UserResponseBody body = new UserResponseBody(user);
		userResponseEnvelope.setBody(body);
		MessageHeaders headers = Utils.messageHeader(Constants.SUCCESS, Constants.SUCCESS);
		userResponseEnvelope.setHeader(headers);
		return userResponseEnvelope;
	}

	@PostMapping(value = "/updateUser")
	public MessageEnvelope<UserResponseBody> updateUser(@RequestBody User user) {
		MessageEnvelope<UserResponseBody> userResponseEnvelope = new MessageEnvelope<UserResponseBody>();
		userService.updateUser(user);
		MessageHeaders headers = Utils.messageHeader(Constants.SUCCESS, Constants.USER_UPDATED);
		userResponseEnvelope.setHeader(headers);
		return userResponseEnvelope;
	}

	@PostMapping(value = "/deleteUser")
	public MessageEnvelope<UserResponseBody> deleteUser(@RequestBody User user) {
		MessageEnvelope<UserResponseBody> userResponseEnvelope = new MessageEnvelope<UserResponseBody>();
		userService.deleteUser(user.getId());
		MessageHeaders headers = Utils.messageHeader(Constants.SUCCESS, Constants.USER_DELETED);
		userResponseEnvelope.setHeader(headers);
		return userResponseEnvelope;
	}
}
