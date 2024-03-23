package com.in28minutes.mockito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.in28minutes.data.api.TodoService;

public class HamcrestMatchersTest 
{
   
	@Test
	public void testName() throws Exception {
		
			List<Integer> scores = Arrays.asList(99, 100, 101, 105);
			assertThat(scores, hasSize(4));
			assertThat(scores, hasItems(100, 101));
			
			assertThat(scores, everyItem(greaterThan(90)));
			assertThat(scores, everyItem(lessThan(200)));

			// String
			assertThat("", isEmptyString());
			assertThat(null, isEmptyOrNullString());

			// Array
			Integer[] marks = { 1, 2, 3 };

			assertThat(marks, arrayWithSize(3));
			assertThat(marks, arrayContainingInAnyOrder(2, 3, 1));
	}
 
    
    
}
