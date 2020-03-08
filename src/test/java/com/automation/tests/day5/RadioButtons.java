package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");
    driver.manage().window().maximize();
        BrowserUtils.wait(2);

        List<WebElement> radioButtons=driver.findElements(By.tagName("input"));
        for (WebElement radioButton : radioButtons) {

            boolean isSelected=radioButton.isSelected();
            System.out.println(radioButton.getAttribute("id") + " is selected "+isSelected);
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("Clicked on: "+radioButton.getAttribute("id"));
                BrowserUtils.wait(1);
            }else{
                System.out.println("Button is disabled ,not clicked : " +radioButton.getAttribute("id"));
            }
        }
        System.out.println();
        driver.quit();




    }
}
