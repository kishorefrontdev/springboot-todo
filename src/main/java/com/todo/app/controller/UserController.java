package com.todo.app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.dao.TodoItem;
import com.todo.app.dao.UserDao;
import com.todo.app.model.User;
import com.todo.app.service.TodoItemService;
import com.todo.app.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDao createUser(@RequestBody UserDao userItem) {
  
        return userService.saveUser(userItem);
    }
    @GetMapping
    public ApiResponse getUserItem() {
        List<String> todoList= userService.getAllNames();
        ApiResponse response = new ApiResponse(true,"Total Users List",todoList);
        return response;
    }
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
    	userService.deleteUser(id);
    }
    @RequestMapping("/count")
    @GetMapping
    public ApiResponse getUserCount() {
     Long count =   userService.getUserCount();
     ApiResponse response = new ApiResponse(true,"Total Users count",count);
     return response;
    }

}
