package lesson4;

import lesson4.helpers.AppProperties;
import lesson4.helpers.DriverDealer;
import lesson4.helpers.PageActions;
import lesson4.pages.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;

/*
Не понятно почему тесты падают если их запустить все
Если запускать по отдельности всё ок
Падаются с ошибкой что не могут выполнить метод loginTest
org.openqa.selenium.NoSuchElementException:
 no such element: Unable to locate element: {"method":"xpath","selector":"//*[@name = "username"]"}
 */
public class TestWithPageFactory {
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static OrdersPage ordersPage;
    public static CustomersPage customersPage;
    public static InvoicesPage invoicesPage;

    @BeforeClass
    public static void setup() {
        loginPage = new LoginPage(DriverDealer.getInstance());
        mainPage = new MainPage(DriverDealer.getInstance());
        ordersPage = new OrdersPage(DriverDealer.getInstance());
        customersPage = new CustomersPage(DriverDealer.getInstance());
        invoicesPage = new InvoicesPage(DriverDealer.getInstance());
    }

    @AfterClass
    public static void tearDown() {
        PageActions.click(mainPage.account);
        PageActions.click(mainPage.logOut);
        DriverDealer.getInstance().closeDriver();
        DriverDealer.getInstance().quitDriver();
    }

    @Test
    public void loginTest() {
        PageActions.input(loginPage.loginField,AppProperties.getProperty("login"));
        PageActions.input(loginPage.passwordField,AppProperties.getProperty("password"));
        PageActions.click(loginPage.loginButton);
    }

    @Test
    public void orderTest() {
        loginTest();
        PageActions.click(mainPage.orders);
        PageActions.click(ordersPage.checkBox1);
        PageActions.click(ordersPage.checkBox2);
        PageActions.click(ordersPage.checkBox3);
        PageActions.click(ordersPage.textItemsCount);
    }

    @Test
    public void invoiceTest() {
        loginTest();
        PageActions.click(mainPage.invoices);
        PageActions.input(invoicesPage.dateFrom,"19.10.2020");
        PageActions.input(invoicesPage.dateTo,"29.10.2020");
        PageActions.click(invoicesPage.firstExpand);
        PageActions.click(invoicesPage.customerInfoOnInvoice);
    }

    @Test
    public void customerTest() {
        loginTest();
        PageActions.click(mainPage.customers);
        PageActions.click(customersPage.customerInfo);
        PageActions.input(customersPage.address,"volga22");
        PageActions.click(customersPage.buttonSave);
        PageActions.movePage(Keys.PAGE_UP);
    }
}
