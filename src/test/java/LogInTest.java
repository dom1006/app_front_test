import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LogInTest {
    static WebDriver driver;
    static WebDriverWait wait;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://192.168.1.77/login.html");
        wait = new WebDriverWait(driver, 10000);
    }

    @Test(priority = 1)
    public void logIn() throws InterruptedException {
        WebElement login = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement submit = driver.findElement(By.id("submit"));

        login.clear();
        login.sendKeys("admin@qsg.com");
        pass.clear();
        pass.sendKeys("ikea");
        submit.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.className("estore-logout")));
        String userName = driver.findElements(By.className("x-btn-inner-default-toolbar-small")).get(0).getText();
        Assert.assertEquals(userName, "Aleksandra Grzywacz");
    }

    @Test(priority = 2)
    public void addNewSupplier() {
        WebElement filesButton = driver.findElements(By.className("x-treelist-item-collapsed"))
                .stream()
                .filter()
                .findFirst();
    }



    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
