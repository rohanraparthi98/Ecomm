import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class AppTest {
@Test
public void testValidLogin()throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","D:/StaragileDevOps/Assignments/Assignment-5 Selenium/EComm/src/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    Thread.sleep(5000);
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    Thread.sleep(5000);
    driver.findElement(By.id("login-button")).click();
    Thread.sleep(5000);
    assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    Thread.sleep(5000);
    driver.quit();
}
@Test
public void testInvalidLogin()throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "D:/StaragileDevOps/Assignments/Assignment-5 Selenium/EComm/src/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.id("user-name")).sendKeys("invalid_user");
    Thread.sleep(5000);
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    Thread.sleep(5000);
    driver.findElement(By.id("login-button")).click();
    Thread.sleep(5000);
    WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
    assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage.getText());
    Thread.sleep(5000);
    driver.quit();
}
}