package com.automation.homework;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCaseFrom1To5 {
    private WebDriver driver;
    private String URL="http://practice-cybertekschool.herokuapp.com/registration_form";
    private By firstNameBy=By.name("firstname");
    private By lastNameBy=By.name("lastname");
    private By usernameBy=By.name("username");
    private By emailBy=By.name("email");
    private By passwordBy=By.name("password");
    private By phoneNumberBy=By.name("phone");

    private By maleBy=By.cssSelector("input[value='male']");
    private By femaleBy=By.cssSelector("input[value='female']");
    private By otherBy=By.cssSelector("input[value='other']");

    private By dateOfBirthBy=By.xpath("//*[@name='birthday']");
    private By departmentBy=By.xpath("//*[@name='department']");
    private By jobTitleBy=By.cssSelector("select[name='job_title']");

    private By cplusplusBy = By.xpath("//*[@value='cplusplus']");
    private By javaBy=By.cssSelector("input[value='java']");
    private By javaScriptBy=By.cssSelector("input[value='javascript']");

    private By signUpBy = By.id("wooden_spoon");

    @Test
    public void verifyBirth() {
        driver.findElement(dateOfBirthBy).sendKeys("wrong_dob");
        WebElement warningMessage = driver.findElement(By.linkText("The date of birth is not valid"));
        BrowserUtils.wait(5);
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @Test
    public void verifyLanguage(){


        }
















    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
