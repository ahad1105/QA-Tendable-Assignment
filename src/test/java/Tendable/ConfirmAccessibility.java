package Tendable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmAccessibility {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.tendable.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        try {
            // Home 
            WebElement homeElement = driver.findElement(By.linkText("Tendable Logo"));
            assertElementIsDisplayed(homeElement);

            // Our Story element
            WebElement ourStoryElement = driver.findElement(By.linkText("Our Story"));
            assertElementIsDisplayed(ourStoryElement);

            // Our Solution element
            WebElement ourSolutionElement = driver.findElement(By.linkText("Our Solution"));
            assertElementIsDisplayed(ourSolutionElement);

            // Why Tendable element
            WebElement whyTendableElement = driver.findElement(By.linkText("Why Tendable?"));
            assertElementIsDisplayed(whyTendableElement);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void assertElementIsDisplayed(WebElement homeElement) {
        if (homeElement.isDisplayed()) {
            System.out.println("Home element is accessible.");
        } else {
            System.out.println("Home element is not accessible.");
            throw new AssertionError(" element is not accessible.");
        }
        
    }
    
    private static void assertElementIsDisplayed2(WebElement ourStoryElement) {
        if (ourStoryElement.isDisplayed()) {
            System.out.println("our story element is accessible.");
        } else {
            System.out.println("our story element is not accessible.");
            throw new AssertionError(" element is not accessible.");
        }
        
    }
    
    private static void assertElementIsDisplayed3(WebElement ourSolutionElement) {
        if (ourSolutionElement.isDisplayed()) {
            System.out.println("our solution element is accessible.");
        } else {
            System.out.println("our solution element is not accessible.");
            throw new AssertionError(" element is not accessible.");
        }
        
    }
    
    private static void assertElementIsDisplayed4(WebElement whyTendableElement) {
        if (whyTendableElement.isDisplayed()) {
            System.out.println("why Tendable Element element is accessible.");
        } else {
            System.out.println("our why Tendable Element is not accessible.");
            throw new AssertionError(" element is not accessible.");
        }
        
    }
    
    
    
    
    
}