package com.todo.app.controller;

import java.util.ArrayList;
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

import com.todo.app.service.TodoItemService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	private final TodoItemService todoItemService;

    @Autowired
    public TodoController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @PostMapping
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
  
        return todoItemService.saveTodoItem(todoItem);
    }
    @GetMapping
    public ApiResponse getTodoItem() {
        List<TodoItem> todoList= todoItemService.getAllTodoItems();
        ApiResponse<List<TodoItem>>response = new ApiResponse(true,"Total todo List",todoList);
        return response;
    }
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
    	todoItemService.deleteTodo(id);
    }
    @RequestMapping("/count")
    @GetMapping
    public ApiResponse getCount() {
     Long count =   todoItemService.getTodoCount();
     ApiResponse response = new ApiResponse(true,"Total todo count",count);
     return response;
    }

}
