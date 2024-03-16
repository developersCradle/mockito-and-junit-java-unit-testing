package com.minutes.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {

	StringHelper helper;
	
	@Before
	public void before(){
		helper = new StringHelper();
	}
	
	
	
	@Test
	public void testTruncateAInFirst2Postions() {
		helper = new StringHelper();
		
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}
	

	@Test
	public void testTruncateAInFirst2Postions_AinFirstPosition() {
		helper = new StringHelper();
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	
	
	// ABCD => false, ABAB => true, AB => true, A => false
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
		assertFalse( 
				helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
		assertTrue( 
				helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	

}

