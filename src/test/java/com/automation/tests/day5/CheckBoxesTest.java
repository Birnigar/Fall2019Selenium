package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        BrowserUtils.wait(20);
        //verify first checkbox  is not selected
        //second one is selected

        List<WebElement> checkBoxes=driver.findElements(By.tagName("input"));

        for (int i = 0; i <checkBoxes.size() ; i++) {
            if(checkBoxes.get(i).isSelected()){
                System.out.println("CheckBox "+(i+1)+" is selected");
            }else{
                System.out.println("CheckBox "+(i+1)+" is not selected");
            }


        }
        BrowserUtils.wait(2);
        driver.quit();
    }
}
