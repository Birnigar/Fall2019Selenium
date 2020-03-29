package com.automation.homework.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
     List<String> actual=new ArrayList<>();


        for (int i = 0; i <btn.size() ; i++) {
            if (btn.get(i).isEnabled() && !btn.get(i).getText().equals("Friday")) {
                btn.get(i).click();
                actual.add(btnText.get(i).getText());
                btn.get(i).click();
            } else if (btn.get(i).equals("Friday")) {
                for (int j = 0; j < 6; j++) {
                    btn.get(i).click();
                }
                actual.add(btnText.get(i).getText());
            }

        }
        BrowserUtils.wait(10);

        Assert.assertEquals(actual.toString(),expected.toString());



    }

}
