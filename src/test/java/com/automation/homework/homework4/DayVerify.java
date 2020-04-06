package com.automation.homework.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class DayVerify {

    private WebDriver driver;



    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createADriver("chrome");

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserUtils.wait(10);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyDay() {
     List< WebElement> btn=driver.findElements(By.xpath("//input"));
     List<WebElement> btnText=driver.findElements(By.xpath("//label"));
     BrowserUtils.wait(2);
     List<String> expected= Arrays.asList("Monday","Tuesday","Wednesday","Thursday","Friday");

        int counter=0;

        while (counter<3) {
            Random random = new Random();
            int checkBoxSelect = random.nextInt(btn.size());

            if ((btn.get(checkBoxSelect).isEnabled()))
                btn.get(checkBoxSelect).click();
            System.out.println("Selected :" + btnText.get(checkBoxSelect).getText());

                  // btn.get(checkBoxSelect).click();
             if(btnText.get(checkBoxSelect).getText().equals("Friday")){
                 counter++;

        }
        }




    }

}
