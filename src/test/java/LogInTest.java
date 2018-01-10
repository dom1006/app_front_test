import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class LogInTest {
    static WebDriver driver;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test(priority = 1)
    public void logIn() throws InterruptedException {

        driver.get("https://192.168.1.77/login.html");
        Thread.sleep(5000);
        driver.close();
    }
}
