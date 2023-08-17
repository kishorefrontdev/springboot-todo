package com.todo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.todo.app.dao.TodoItem;
import com.todo.app.jpa.TodoItemRepository;
@Service

public class TodoItemService {
    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public TodoItem saveTodoItem(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    
    }
    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }
    public Long getTodoCount() {
        return todoItemRepository.count();
    }
    public void deleteTodo(Long id) {
         todoItemRepository.deleteById(id);
    }
}

