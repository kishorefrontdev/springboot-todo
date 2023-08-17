package com.todo.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.app.dao.TodoItem;
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}

