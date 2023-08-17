package com.todo.app.controller;

public class ApiResponse<T> {
    private boolean success;
    private String message;
	private T response;

    public ApiResponse(boolean success, String message, T response) {
        this.success = success;
        this.message = message;
        this.response = response;
//        
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return response;
	}

	public void setData(T response) {
		this.response = response;
	}

    // Getters and setters
}