package lesson4.pages;

import lesson4.helpers.DriverDealer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
    public CustomersPage(DriverDealer dealer) {
        PageFactory.initElements(dealer.createDriver(),this);
    }

    @FindBy(xpath = "//tr[1][@resource=\"customers\"]")
    public WebElement customerInfo;

    @FindBy(xpath = "//*[@id=\"address\"]")
    public WebElement address;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    public WebElement buttonSave;
}
