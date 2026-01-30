package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.alerts.AlertsPage;
import pages.alerts.HomePage;
import pages.alerts.SideBarPage;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public WebDriverWait wait;

    public HomePage homePage;
    public SideBarPage sideBarPage;
    public AlertsPage alertsPage;

    @BeforeClass
    public void pageSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.quit();
    }
}
