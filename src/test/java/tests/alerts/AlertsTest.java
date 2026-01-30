package tests.alerts;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.alerts.AlertsPage;
import pages.alerts.HomePage;
import pages.alerts.SideBarPage;

public class AlertsTest extends BaseTest {

    @BeforeClass
    public void alertsPageSetup() {
        log.info("===== Setup Alerts page =====");

        homePage = new HomePage();
        sideBarPage = new SideBarPage();
        alertsPage = new AlertsPage();

        log.info("Navigate to Alerts page");
        homePage.clickOnCard("Alerts, Frame & Windows");
        sideBarPage.clickOnCardItem("Alerts");
    }

    @Test(priority = 0)
    public void userCanClickAlertButton() {
        log.info("=== Start test: userCanClickAlertButton ===");

        log.info("Click Alert button");
        alertsPage.alertButton.click();

        log.info("Wait for alert");
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        log.info("Verify alert text");
        Assert.assertEquals(alert.getText(), "You clicked a button");

        log.info("Accept alert");
        alert.accept();

        log.info("=== End test: userCanClickAlertButton ===");
    }

    @Test(priority = 1)
    public void userCanClickTimeAlertButton() {
        log.info("=== Start test: userCanClickTimeAlertButton ===");

        log.info("Click Time Alert button");
        alertsPage.timeAlertButton.click();

        log.info("Wait for alert (5 seconds)");
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        log.info("Verify alert text");
        Assert.assertEquals(alert.getText(), "This alert appeared after 5 seconds");

        log.info("Accept alert");
        alert.accept();

        log.info("=== End test: userCanClickTimeAlertButton ===");
    }

    @Test(priority = 2)
    public void userCanClickConfirmButton() {
        log.info("=== Start test: userCanClickConfirmButton ===");

        log.info("Click Confirm button (OK case)");
        alertsPage.confirmButton.click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Do you confirm action?");

        log.info("Accept confirm alert");
        alert.accept();

        log.info("Verify result is OK");
        Assert.assertEquals(alertsPage.confirmResult.getText(), "You selected Ok");

        log.info("Click Confirm button (Cancel case)");
        alertsPage.confirmButton.click();
        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Do you confirm action?");

        log.info("Dismiss confirm alert");
        alert.dismiss();

        log.info("Verify result is Cancel");
        Assert.assertEquals(alertsPage.confirmResult.getText(), "You selected Cancel");

        log.info("=== End test: userCanClickConfirmButton ===");
    }

    @Test(priority = 3)
    public void userCanClickPromptButton() {
        log.info("=== Start test: userCanClickPromptButton ===");

        log.info("Click Prompt button");
        alertsPage.promptButton.click();
        wait.until(ExpectedConditions.alertIsPresent());

        String prompt = "Hello from Huy Nguyen";

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Please enter your name");

        log.info("Enter text into prompt: {}", prompt);
        alert.sendKeys(prompt);
        alert.accept();

        log.info("Verify prompt result");
        Assert.assertEquals(alertsPage.promptResult.getText(), "You entered " + prompt);

        log.info("=== End test: userCanClickPromptButton ===");
    }
}
