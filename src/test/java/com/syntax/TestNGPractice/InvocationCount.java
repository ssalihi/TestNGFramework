package com.syntax.TestNGPractice;

import org.testng.annotations.Test;

public class InvocationCount {
@Test (invocationCount=5)

public void number() {
	int a=10;
	int b=11;
	int c=a+b;
	
	System.out.println("The sum is ="+c);
}
}
