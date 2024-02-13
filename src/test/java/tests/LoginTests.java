package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.SplashScreen;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class LoginTests extends AppiumConfig {
    @Test
    public void loginSuccess() {
//        boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthenticationScreen(driver)
                .fillEmail("chara@gmail.com")
                .fillPassword("Chara12345$")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }

    @Test
    public void loginSuccessModel() {
//        boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("chara@gmail.com")
                        .password("Chara12345$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);

    }

    @Test
    public void loginSuccessModel2() {
        Assert.assertTrue(new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("chara@gmail.com")
                .password("Chara12345$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list"));


    }

    @Test
    public void loginWrongEmail() {
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("charagmail.com")
                .password("Chara12345$").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }


    @AfterMethod
    public void postCondition() {
        new ContactListScreen(driver).logout();
    }


}

//******************* HW postCondition LoginTests *****************
//public class LoginTests extends AppiumConfig {
//
//    private boolean testResult;
//
//    @Test
//    public void loginSuccess() {
//        testResult = new AuthenticationScreen(driver)
//                .fillEmail("chara@gmail.com")
//                .fillPassword("Chara12345$")
//                .submitLogin()
//                .isActivityTitleDisplayed("Contact list");
//    }
//
//    @Test
//    public void loginSuccessModel() {
//        testResult = new AuthenticationScreen(driver)
//                .fillLoginRegistrationForm(Auth.builder().email("chara@gmail.com")
//                        .password("Chara12345$").build())
//                .submitLogin()
//                .isActivityTitleDisplayed("Contact list");
//    }
//
//    @Test
//    public void loginSuccessModel2() {
//        testResult = new AuthenticationScreen(driver)
//                .fillLoginRegistrationForm(Auth.builder().email("chara@gmail.com")
//                        .password("Chara12345$").build())
//                .submitLogin()
//                .isActivityTitleDisplayed("Contact list");
//    }
//
//    @Test
//    public void loginWrongEmail() {
//        new AuthenticationScreen(driver)
//                .fillLoginRegistrationForm(Auth.builder().email("charagmail.com")
//                        .password("Chara12345$").build())
//                .submitLoginNegative()
//                .isErrorMessageHasText("Login or Password incorrect");
//        testResult = false;
//    }
//
//    @AfterMethod
//    public void postCondition(ITestResult result) {
//        if (result.isSuccess() && testResult) {
//            new ContactListScreen(driver).logout();
//        }
//    }
//}