package com.syntax.class01;

import org.testng.annotations.Test;

public class TestNgIntro {
	//@Test is a main annotation that identifies how many test will be running 
	
	@Test //we use this annotation to mark a method as a test method
	
	public void testOne () {
		System.out.println("I am test 1");
	}
	
	@Test 
	
	public void testTwo () {
		System.out.println("I am test 2");
	}
	
	@Test 
	
	public void testThree() {
		System.out.println("I am test 3");
	}
	
	@Test 
	
	public void testFour() {
		System.out.println("I am test 4");
	}
	
	//all test methods will execute in alphabetical order

}
