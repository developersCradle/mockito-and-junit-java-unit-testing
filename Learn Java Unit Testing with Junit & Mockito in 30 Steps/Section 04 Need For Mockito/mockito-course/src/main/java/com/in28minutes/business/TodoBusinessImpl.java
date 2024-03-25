package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImpl {
	private TodoService todoService;

	//TodoBusinessImpl SUT
	//TodoService Dependency
	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		
		
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) { //Related to spring
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	
public void delteTodosNotRelatedToSpring(String user) {
		
		
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) { //Related to spring
				todoService.deleteTodo(todo);
			}
		}
	}
	
}