package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.in28minutes.data.api.TodoService;

public class ListTest 
{
    @Test
    public void testMockListSizeMethod()
    {
    	List listMock = mock(List.class);
    	when(listMock.size()).thenReturn(2);
    	assertEquals(2, listMock.size());
    }
    
    @Test
    public void testMockListSize_ReturnMultipleValues()
    {
    	List listMock = mock(List.class);
    	when(listMock.size()).thenReturn(2).thenReturn(3);
    	
    	assertEquals(2, listMock.size());
    	assertEquals(3, listMock.size());
    }
    
    @Test
    public void testLetsMockListGet()
    {
    	List listMock = mock(List.class);
    	when(listMock.get(0)).thenReturn("in28Minutes");
    	
    	
    	assertEquals("in28Minutes", listMock.get(0)); // Defined only for get(0) argument
    	assertEquals(null, listMock.get(1)); // Nice mocks happening here, not defined 
    }
    
    @Test
    public void testLetsMockListGetWithArgumentMatchers()
    {
    	List listMock = mock(List.class);
    	when(listMock.get(anyInt())).thenReturn("in28Minutes");    	
    	
    	assertEquals("in28Minutes", listMock.get(0)); 
    	assertEquals("in28Minutes", listMock.get(1));
    }
    
    @Test
    public void testLetsMockListThrowsAnExpection()
    {
    	List listMock = mock(List.class);
    	
    	when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));//Junit 5 way
    	
    	   assertThrows(RuntimeException.class, () -> {
    		   listMock.get(0);
           });
    	   
    }
    
    // Same test, but with (BDD)Given, When, Then
	@Test
	public void usingMockito_UsingBDD() {
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		//given
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

		//when
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");

		//then
		assertThat(todos.size(), is(2));
	}
 
 
    
    
}
