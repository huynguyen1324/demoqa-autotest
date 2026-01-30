package pages.alerts;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> cards;

    public void clickOnCard(String str) {
        for (WebElement card : cards) {
            if(card.getText().equals(str)) {
                card.click();
                break;
            }
        }
    }
}
