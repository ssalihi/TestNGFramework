package com.syntax.practice;

import org.testng.annotations.Test;

public class ExceptionTimeOut {
@Test

public void infitLoop() {
	int i=1;
	while(i==1) {
		System.out.println(i);
	}
}
}
