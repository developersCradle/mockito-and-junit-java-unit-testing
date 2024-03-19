package com.in28minutes.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.in28minutes.data.api.TodoService;

class TodoBusinessImplMockTest {

	
	@Test
	void testRetrieveTodosRelatedToSpring_usingAMock() {
		
		// Given - START
		TodoService mockTodoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		when(mockTodoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		
		// Given - END


		// When - START
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		
		// When - END

		
		// Then - START

		assertEquals(2,	filteredTodos.size());

		// Then - END
		
	}
	
	@Test
	void testRetrieveTodosRelatedToSpring_withEmptyList() {
		
		// Given - START
		TodoService mockTodoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList();
		
		when(mockTodoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		
		// Given - END


		// When - START
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		
		// When - END

		
		// Then - START

		assertEquals(0,	filteredTodos.size());

		// Then - END
		
	}

}
