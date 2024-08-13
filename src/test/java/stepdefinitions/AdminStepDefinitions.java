package stepdefinitions;

import io.cucumber.java.en.Then;


import org.junit.jupiter.api.Assertions;
import pages.AdminPage;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.*;


public class AdminStepDefinitions {
    static AdminPage adminPage;

    @Then("Admin anasayfasının açıldığını doğrular")
    public void admin_anasayfasının_açıldığını_doğrular() {
        adminPage = new AdminPage();
        String expectedUrl = "https://qa.flavorfetch.com/backoffice/login" ;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(expectedUrl,actualUrl);
    }
    @Then("Admin panelinin yüklendiğini doğrular")
    public void admin_panelinin_yüklendiğini_doğrular() {
        adminPage = new AdminPage();
        assertTrue(adminPage.userNameButton.isDisplayed());
        assertTrue(adminPage.passwordButton.isDisplayed());
        Assertions.assertTrue(adminPage.signInButton.isDisplayed());




    }
}
