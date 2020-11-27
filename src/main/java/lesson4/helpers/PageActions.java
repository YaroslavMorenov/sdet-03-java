package lesson4.helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageActions {
    private static final DriverDealer dealer = DriverDealer.getInstance();

    public static void click(WebElement element) {
        element.click();
    }

    public static void input(WebElement element,String text) {
        element.sendKeys(text);
    }

    public static void movePage(Keys key) {
        Actions action = new Actions(dealer.createDriver());
        action.sendKeys(key).build().perform();
    }
}
