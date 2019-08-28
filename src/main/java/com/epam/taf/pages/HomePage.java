package com.epam.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='header-username']")
    private WebElement fullUserNameLabel;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUserName() {
        return fullUserNameLabel.getText();
    }
}

