package com.in28minutes.business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

class TodoBusinessImplStubTest {

	@Test
	void testRetrieveTodosRelatedToSpring_usingAStub() {


		
		// Given - START
		
		TodoService todoServiceStub = new TodoServiceStub();// We put some test data with Stub
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		// Given - END


		// When - START
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		// When - END

		
		// Then - START

		assertEquals(2,	filteredTodos.size());
		// Then - END
		
	}

	@Test
	void testRetrieveTodosRelatedToSpring_usingAStub_secondCase() {


		
		// Given - START
		
		TodoService todoServiceStub = new TodoServiceStub();// We put some test data with Stub
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		// Given - END


		// When - START
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy1");
		
		// When - END

		
		// Then - START

		assertEquals(0,	filteredTodos.size());
		// Then - END
		
	}

}
