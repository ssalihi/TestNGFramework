package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class PIMpage extends BaseClass {
@FindBy(partialLinkText="PIM")
public WebElement pimPage;

@FindBy(partialLinkText="Add Employee")
public WebElement addEmployee;

public PIMpage() {
	PageFactory.initElements(driver, this);
}
}
