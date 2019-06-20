package com.syntax.TestNGPractice;

import org.testng.annotations.Test;

public class TestNgFeatures {
@Test
public void loginTest() {// if login test is failed so there is no mean to run the other test cases. so we use depentOnMethod keyword 
System.out.println("loging test");	

int a=9/0; //in this case the home page test will be not executed becuase it depend on login test case.
}
@Test (dependsOnMethods="loginTest")
public void HomePageTest() {
System.out.println("Home Page Test");	
}
@Test (dependsOnMethods="loginTest")
public void SearchPageTest() {
System.out.println("loging test");	

}

@Test (dependsOnMethods="loginTest")
public void REgisterPageTest() {
System.out.println("loging test");	
}

@Test (dependsOnMethods="loginTest")
public void PageTest() {
System.out.println("loging test");	
}
}
