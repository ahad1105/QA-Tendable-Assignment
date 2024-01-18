package Tendable;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyDemoButton {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tendable.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            // Click on Home button
            driver.findElement(By.linkText("Tendable Logo")).click();
            verifyDemoButton(driver);

            // Click on Our Story button
            driver.findElement(By.linkText("Our Story")).click();
            verifyDemoButton(driver);

            // Click on Our Solution button
            driver.findElement(By.linkText("Our Solution")).click();
            verifyDemoButton(driver);

            // Click on Why Tendable button
            driver.findElement(By.linkText("Why Tendable?")).click();
            verifyDemoButton(driver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void verifyDemoButton(WebDriver driver) {
        // Verify that the "Request a Demo" button is present and active
        WebElement demoButton = driver.findElement(By.linkText("Request a Demo"));
        if (demoButton.isDisplayed() && demoButton.isEnabled()) {
            System.out.println("Request a Demo button is present and active.");
        } else {
            System.out.println("Request a Demo button is not present or active.");
            throw new AssertionError("Request a Demo button is not present or active.");
        }
    }
}