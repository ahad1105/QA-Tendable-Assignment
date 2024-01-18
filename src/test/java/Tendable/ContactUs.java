package Tendable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {

	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.tendable.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
        driver.findElement(By.linkText("Contact Us")).click();
        
        WebElement cont_btn = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div[1]/div/div[2]/div[2]/button"));
		js.executeScript("arguments[0].click()", cont_btn);
        
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        
        //fill the form
        //Full name
        driver.findElement(By.id("form-input-fullName")).click();
        //organisation name
        driver.findElement(By.id("form-input-organisationName")).click();
        //phone number
        driver.findElement(By.id("form-input-cellPhone")).click();
        //email
        driver.findElement(By.id("form-input-email")).click();
        //job role
        
        
        
        WebElement dropdownElement = driver.findElement(By.id("form-input-jobRole"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Management");
        
        
        //agree radio button
        driver.findElement(By.id("form-input-consentAgreed-0")).click();
        //submit button
        driver.findElement(By.xpath("//*[@id=\"contactMarketingPipedrive-163701\"]/div[10]/div/button")).click();
        
        //assert error messages
        try {
            WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/table/tbody/tr[6]/td[2]"));
            
            assert element.isDisplayed() : "Element is not displayed.";

            // If element is displayed, get the "logout" link's href attribute
            String logoutLinkHref = driver.findElement(By.linkText("logout")).getAttribute("href");
            System.out.println("Logout link href: " + logoutLinkHref);

        } catch (AssertionError e) {
            // If the element is not displayed, assert and click on the alternative link
            assert driver.findElement(By.xpath("/html/body/div/div/div/a[2]")).isDisplayed() : "Alternative link is not displayed.";
            driver.findElement(By.xpath("/html/body/div/div/div/a[2]")).click();
        }
   

	}

}
