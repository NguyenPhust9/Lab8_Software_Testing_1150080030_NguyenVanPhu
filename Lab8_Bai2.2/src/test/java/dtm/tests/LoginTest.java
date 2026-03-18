package dtm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import dtm.factory.DriverFactory;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {

        DriverFactory.initDriver("chrome");

        driver = DriverFactory.getDriver();

        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void testLogin() {

        System.out.println("Login Test running on thread: " + Thread.currentThread().getId());

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
    }

    @AfterClass
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}