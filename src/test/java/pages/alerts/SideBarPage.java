package pages.alerts;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBarPage extends BaseTest {
    public SideBarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "text")
    public List<WebElement> cardItems;

    public void clickOnCardItem(String str) {
        for (WebElement cardItem : cardItems) {
            if(cardItem.getText().equals(str)) {
                cardItem.click();
            }
        }
    }
}
