package com.epam.taf.steps;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest {
    private static final String USER_NAME = "clerk1";
    private static final String USER_PASSWORD = "Thomson!0";
    private static final String FULL_NAME = "Clerk Court";
    private static final String PERSON_LAST_NAME = "Alena";
    public static final String VALIDATION_MESSAGE = "Last Name is required.";
    private Steps steps;


    @BeforeMethod(description = "init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void userCanLogin() {

        steps.loginCMS(USER_NAME, USER_PASSWORD);
        Assert.assertTrue(steps.isUserLoggedIn(FULL_NAME));
    }

    @Test
    public void userCanCreateNewPerson() {
        steps.loginCMS(USER_NAME, USER_PASSWORD);
        String name = steps.createNewPerson("Alena");
        Assert.assertTrue(steps.isPersonCreated(PERSON_LAST_NAME));
    }

    @Test
    public void createNewPersonValidation(){
        steps.loginCMS(USER_NAME, USER_PASSWORD);
        steps.saveNewPersonWithoutRequiredField();
        Assert.assertTrue(steps.isValidationMessageReturns(VALIDATION_MESSAGE));
    }

    /* @AfterMethod(description = "close browser")
     public void tearDown(){
         steps.closeBrowser();*/


}
