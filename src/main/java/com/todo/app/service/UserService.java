package com.todo.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.app.dao.UserDao;
import com.todo.app.jpa.UserItemRepository;

@Service

public class UserService {
	private final UserItemRepository userItemRepository;

	@Autowired
	public UserService(UserItemRepository userItemRepository) {
		this.userItemRepository = userItemRepository;
	}

	public UserDao saveUser(UserDao user) {
		return userItemRepository.save(user);
	}

	public List<UserDao> getUsersList() {
		return userItemRepository.findAll();
	}

	public Long getUserCount() {
		return userItemRepository.count();
	}

	public void deleteUser(Long id) {
		userItemRepository.deleteById(id);
	}
	public List<String> getAllNames(){
		return userItemRepository.findAllNames();
	}
}
