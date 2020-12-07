package lesson3;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyTest {
    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/Users/Yaroslav.Morenov/Desktop/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        driver.findElement(By.xpath("//*[@class = \"MuiButton-label\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-appbar\"]/div[3]/ul/li")).click();
        driver.close();
    }

    @Test
    public void firstTest() {
        driver.get("https://marmelab.com/react-admin-demo/#/login");
        driver.findElement(By.xpath("//*[@name = \"username\"]")).sendKeys("demo");
        driver.findElement(By.xpath("//*[@name = \"password\"]")).sendKeys("demo" + Keys.valueOf("ENTER"));
    }

    @Test
    public void secondTest() {
        firstTest();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[1]/div/div/div[1]/div/div/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[1]/span/span[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div/div[2]/div/div[3]/table/tbody/tr[2]/td[1]/span/span[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div/div[2]/div/div[3]/table/tbody/tr[3]/td[1]/span/span[1]/input")).click();
        driver.findElement(By.xpath("//*[contains(text(),'3 items selected')]"));
    }

    @Test
    public void thirdTest() {
        firstTest();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[1]/div/div/div[1]/div/div/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@name = 'date_gte']")).sendKeys("19.10.2020");
        driver.findElement(By.xpath("//*[@name = 'date_lte']")).sendKeys("29.10.2020");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/div/span[1]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Rhianna')]"));
    }

    @Test
    public void fourthTest() {
        firstTest();
        driver.findElement(By.xpath("//*[@href=\"#/customers\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Volga 22");
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_UP).build().perform();
    }
}
