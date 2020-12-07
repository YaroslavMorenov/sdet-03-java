package lesson4.pages;

import lesson4.helpers.DriverDealer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
    public OrdersPage(DriverDealer dealer) {
        PageFactory.initElements(dealer.createDriver(),this);
    }

    @FindBy(xpath = "//div[@class = 'MuiTabs-root']//button[2][@class = 'MuiButtonBase-root MuiTab-root MuiTab-textColorInherit MuiTab-fullWidth']")
    public WebElement delivered;

    @FindBy(xpath = "//tr[1]//td[1]//span//input[@type = 'checkbox']")
    public WebElement checkBox1;

    @FindBy(xpath = "//tr[2]//td[1]//span//input[@type = 'checkbox']")
    public WebElement checkBox2;

    @FindBy(xpath = "//tr[3]//td[1]//span//input[@type = 'checkbox']")
    public WebElement checkBox3;

    @FindBy(xpath = "//h6[text() = '3 items selected']")
    public WebElement textItemsCount;
}
