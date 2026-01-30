package tests.alerts;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.alerts.AlertsPage;
import pages.alerts.HomePage;
import pages.alerts.SideBarPage;

import java.time.Duration;

public class AlertsTest extends BaseTest {

    @BeforeClass
    public void alertsPageSetup() {
        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        alertsPage = new AlertsPage();

        homePage.clickOnCard("Alerts, Frame & Windows");
        sideBarPage.clickOnCardItem("Alerts");
    }

    @Test(priority = 0)
    public void userCanClickAlertButton() {
        alertsPage.alertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You clicked a button");
        alert.accept();
    }

    @Test(priority = 1)
    public void userCanClickTimeAlertButton() {
        alertsPage.timeAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "This alert appeared after 5 seconds");
        alert.accept();
    }

    @Test(priority = 2)
    public void userCanClickConfirmButton() {
        alertsPage.confirmButton.click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Do you confirm action?");
        alert.accept();
        Assert.assertEquals(alertsPage.confirmResult.getText(), "You selected Ok");

        alertsPage.confirmButton.click();
        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Do you confirm action?");
        alert.dismiss();
        Assert.assertEquals(alertsPage.confirmResult.getText(), "You selected Cancel");

    }

    @Test(priority = 3)
    public void userCanClickPromptButton() {
        alertsPage.promptButton.click();
        wait.until(ExpectedConditions.alertIsPresent());

        String prompt = "Hello from Huy Nguyen";

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Please enter your name");
        alert.sendKeys(prompt);
        alert.accept();
        Assert.assertEquals(alertsPage.promptResult.getText(), "You entered " + prompt);
    }
}
