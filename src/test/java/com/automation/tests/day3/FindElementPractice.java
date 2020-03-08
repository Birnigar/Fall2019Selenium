package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= DriverFactory.createADriver("chrome");
         driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("Birnigar Ozyurt");
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("galatasaray@gmail.com");

        WebElement signUp=driver.findElement(By.className("radius"));
        signUp.click();
       // when you see type="submit", you can use submit() instead of click()
        // it make sense to use when click() method doesn't work
       Thread.sleep(3000);
        String expected="Thank you for signing up. Click the button below to return to the home page.";
        WebElement message=driver.findElement(By.className("subheader"));

        String actual=message.getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        driver.quit();//to close everything


    }
}
