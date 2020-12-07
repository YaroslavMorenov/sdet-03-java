package lesson4.pages;

import lesson4.helpers.DriverDealer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(DriverDealer dealer) {
        PageFactory.initElements(dealer.createDriver(),this);
    }

    @FindBy(xpath = "//*[@class = \"MuiButton-label\"]")
    public WebElement account;

    @FindBy(xpath = "//ul[@role = \"menu\"]//li[text()='Logout']")
    public WebElement logOut;

    @FindBy(xpath = "//a[text()='Orders']")
    public WebElement orders;

    @FindBy(xpath = "//a[text()='Invoices']")
    public WebElement invoices;

    @FindBy(xpath = "//a[text()='Customers']")
    public WebElement customers;
}
