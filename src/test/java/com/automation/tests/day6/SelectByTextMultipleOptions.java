package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);


        Select languagesSelect=new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple=languagesSelect.isMultiple();
        System.out.println(isMultiple);

        if(isMultiple==true) {
             languagesSelect.selectByVisibleText("Java");
             languagesSelect.selectByVisibleText("JavaScript");
            languagesSelect.selectByVisibleText("Python");
        }
        List<WebElement> allSelectedOptions=languagesSelect.getAllSelectedOptions();
         //lets get all selected option
        for (WebElement allSelectedOption : allSelectedOptions) {
            System.out.println(allSelectedOption.getText());

        }




        BrowserUtils.wait(3);
        driver.quit();




    }
}
