package lesson4.pages;

import lesson4.helpers.DriverDealer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(DriverDealer dealer) {
        PageFactory.initElements(dealer.createDriver(),this);
    }

    @FindBy(xpath = "//*[@name = \"username\"]")
    public WebElement loginField;

    @FindBy(xpath = "//*[@name = \"password\"]")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type=\"submit\"]//span[text()='Sign in']")
    public WebElement loginButton;
}
