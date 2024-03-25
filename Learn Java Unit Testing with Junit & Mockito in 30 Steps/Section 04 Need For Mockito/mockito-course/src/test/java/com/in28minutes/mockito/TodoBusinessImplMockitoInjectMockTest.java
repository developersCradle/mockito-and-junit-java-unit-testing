package com.in28minutes.mockito;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockitoInjectMockTest 
{
	@Rule
	 public MockitoRule mockitoRule = MockitoJUnit.rule();
	
// Mock annotation will make this behind scenes
// TodoService mockTodoService = mock(TodoService.class);
	
	@Mock
	TodoService mockTodoService;

//	InjectMocks will remove this one
//	TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
	
	@InjectMocks 
	TodoBusinessImpl todoBusinessImpl;
	
	
//	Argument captor will be 
//	ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		
		// Given - START
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
	public void testRetrieveTodosRelatedToSpring_withEmptyList() {
		
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
	
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		
		// Given - START
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		given(mockTodoService.retrieveTodos("Ranga")).willReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		
		// Given - END


		// When - START
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		
		// When - END

		
		// Then - START

		assertThat(filteredTodos.size(), is(2));

		// Then - END
		
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {
		
		// Given - START
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		given(mockTodoService.retrieveTodos("Dummy")).willReturn(allTodos); // We need this for deleting
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		
		// Given - END


		// When - START
		
		todoBusinessImpl.delteTodosNotRelatedToSpring("Dummy");
		
		// When - END

		
		// Then - START

		then(mockTodoService).should().deleteTodo("Learn to Dance");// Check if some method is called
		//mockTodoService.deleteTodo("Learn to Dance"); // Unrelated to dance with dummy data
		then(mockTodoService).should(never()).deleteTodo("Learn Spring MVC");// Check if some method is never called
		
		// Then - END

	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumnentCapture() {
		
		//Define Argument captor on specific method call
		//Capture the argument
		
		// Given - START
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		given(mockTodoService.retrieveTodos("Dummy")).willReturn(allTodos); // We need this for deleting
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		
		// Given - END


		// When - START
		
		todoBusinessImpl.delteTodosNotRelatedToSpring("Dummy");
		
		// When - END

		
		// Then - START

		then(mockTodoService).should().deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
		
		// Then - END

	}

    
    
}
