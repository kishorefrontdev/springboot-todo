package com.todo.app.model;

import lombok.Data;

@Data
public class Todo {
	private Long id;
    private String text;
    private boolean completed;
    private Long updatedId;
}
