package com.app.activities.model.json;

import java.util.ArrayList;
import java.util.List;

import com.app.activities.model.User;

import lombok.Data;

@Data
public class UserResponseBody implements EnvelopeBody {
	private User user;
	private List<User> userList;
	
	public UserResponseBody() {
	}
	
	public UserResponseBody(User user) {
		this.user = user;
	}
	
	public void setUserList(List<User> list) {
		this.userList = new ArrayList<>();
		list.forEach( user -> {
			this.userList.add(user);
		});
	}
}
