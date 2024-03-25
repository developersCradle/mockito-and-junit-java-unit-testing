package com.in28minutes.data.api;


import java.util.List;

public interface TodoService {
	public List<String> retrieveTodos(String user);
//	List<String> configureSomething(String user); // Now when Service grows
	public void deleteTodo(String todo);
}