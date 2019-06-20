package com.syntax.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {//result variable will keep the 
	System.out.println("Test case started :"+result.getName());	
		test=report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case passed:" +result.getName());
		test.pass("Test passed:"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Case failed:" +result.getName());
		test.fail("Test Case failed :"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case skipped:" +result.getName());
		report.createTest(result.getName());
		
	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Cas started:" +context.getName());	
		//report.createTest(context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Cas finished:" +context.getName());	
		//report.createTest(context.getName());
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//test.fail("Test Failed:"+result.getName());
		
	}

}
