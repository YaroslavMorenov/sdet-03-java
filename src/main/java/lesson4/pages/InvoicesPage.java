package lesson4.pages;

import lesson4.helpers.DriverDealer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicesPage {
    public InvoicesPage(DriverDealer dealer) {
        PageFactory.initElements(dealer.createDriver(),this);
    }

    @FindBy(xpath = "//*[@name = 'date_gte']")
    public WebElement dateFrom;

    @FindBy(xpath = "//*[@name = 'date_lte']")
    public WebElement dateTo;

    @FindBy(xpath = "//tr[1]/td[1]//span[@class = 'MuiIconButton-label']")
    public WebElement firstExpand;

    @FindBy(xpath = "//p[text() = 'Rowland']")
    public WebElement customerInfoOnInvoice;
}
