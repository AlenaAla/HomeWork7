package com.epam.taf.steps;

import com.epam.taf.pages.CreateNewPersonPage;
import com.epam.taf.pages.HomePage;
import com.epam.taf.pages.LoginPage;
import com.epam.taf.pages.ManagePersonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Steps {
    private WebDriver driver;

    public void loginCMS(String userName, String userPassword) {
        LoginPage page = new LoginPage(driver);
        page.openPage();
        page.login(userName, userPassword);
    }

    public boolean isUserLoggedIn(String fullName) {
        HomePage homePage = new HomePage(driver);
        String actualUserName = homePage.getLoggedInUserName();
        return actualUserName.equals(fullName);
    }

    public void closeBrowser() {
        this.driver.close();
    }

    public void initBrowser() {
        this.driver = new FirefoxDriver();
    }

    public String createNewPerson(String newPersonLastName) {
        CreateNewPersonPage page = new CreateNewPersonPage(driver);
        page.openPage();
        page.createPerson(newPersonLastName);
        return newPersonLastName;
    }

    public boolean isPersonCreated(String personLastName) {
        ManagePersonPage managePersonPage = new ManagePersonPage(driver);
        String actualPersonLastName = managePersonPage.getPersonLastName();
        return actualPersonLastName.equals(personLastName);
    }


    public void saveNewPersonWithoutRequiredField() {
        CreateNewPersonPage page =new CreateNewPersonPage(driver);
        page.openPage();
        page.savePersonWithoutRequiredField();
    }

    public boolean isValidationMessageReturns(String validationMessage) {
        CreateNewPersonPage page = new CreateNewPersonPage(driver);
        String actualValidationMessage = page.getValidationMessage();
        return actualValidationMessage.equals(validationMessage);
    }

}

    
    









