package dtm;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // TC1: Login thành công
    @Test
    public void testLoginSuccess() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("inventory.html"));

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("inventory.html"),
                "Đăng nhập thành công nhưng không chuyển sang inventory.html"
        );
    }

    // TC2: Sai mật khẩu
    @Test
    public void testLoginWrongPassword() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_pass");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

        boolean errorDisplayed =
                driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();

        Assert.assertTrue(
                errorDisplayed,
                "Sai mật khẩu nhưng thông báo lỗi không hiển thị"
        );
    }

    // TC3: Bỏ trống username
    @Test
    public void testLoginEmptyUsername() {

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

        String error =
                driver.findElement(By.cssSelector("[data-test='error']")).getText();

        Assert.assertTrue(
                error.contains("Username is required"),
                "Không hiển thị lỗi Username is required"
        );
    }

    // TC4: Bỏ trống password
    @Test
    public void testLoginEmptyPassword() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

        String error =
                driver.findElement(By.cssSelector("[data-test='error']")).getText();

        Assert.assertTrue(
                error.contains("Password is required"),
                "Không hiển thị lỗi Password is required"
        );
    }

    // TC5: User bị khóa
    @Test
    public void testLoginLockedUser() {

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

        String error =
                driver.findElement(By.cssSelector("[data-test='error']")).getText();

        Assert.assertTrue(
                error.contains("locked out"),
                "Không hiển thị lỗi tài khoản bị khóa"
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}