package com.app.activities.service;

import com.app.activities.dao.UserDao;
import com.app.activities.model.User;
import com.app.activities.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public User getUserById(long id) {
		return userDao.findById(id).get();
	}

	@Override
	public void deleteUser(long id) {
		userDao.deleteById(id);
	}

	@Override
    public User createUser(User user) {
        return userDao.saveAndFlush(user);
    }
	
	@Override
    public User updateUser(User user) {
        return userDao.saveAndFlush(user);
    }
	
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
	}
}
