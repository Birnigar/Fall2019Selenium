package com.automation.homework.homework3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class TestCaseFrom1To5 {
    private WebDriver driver;
    private String URL="http://practice.cybertekschool.com/registration_form";
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

    @Test(priority = 1)
    public void verifyBirth() {
        driver.findElement(dateOfBirthBy).sendKeys("wrong_dob");
        String warningMessage=driver.findElement(By.xpath("//small[text()='The date of birth is not valid']")).getText();
        String actual="The date of birth is not valid";
        BrowserUtils.wait(5);
        Assert.assertEquals(warningMessage,actual);

    }

    @Test(priority = 2)
    public void verifyLanguage(){
      List<WebElement> languages=driver.findElements(By.xpath("//input[@class='form-check-input']"));
      BrowserUtils.wait(5);

        for (WebElement language : languages) {
            Assert.assertTrue(language.isDisplayed());
        }

        }

    @Test(priority = 3)
    public void verifyFirstName(){
        driver.findElement(firstNameBy).sendKeys("a");

        String warningMessage=driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']")).getText();
       BrowserUtils.wait(3);
        String actualMessage="first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(warningMessage,actualMessage);
    }

    @Test(priority = 4)
    public void verifyLastName(){
        driver.findElement(lastNameBy).sendKeys("b");

        String warningMessage=driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']")).getText();
        BrowserUtils.wait(3
        );
        String actualMessage="The last name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(warningMessage,actualMessage);
    }

    @Test
     public void fillUpFormVerify(){
        driver.findElement(firstNameBy).sendKeys("Nigar");
        driver.findElement(lastNameBy).sendKeys("Ozyurt");
        driver.findElement(usernameBy).sendKeys("username");
        driver.findElement(emailBy).sendKeys("farukozyurt34@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(passwordBy).sendKeys("12345678");
        driver.findElement(phoneNumberBy).sendKeys("491-235-2365");
        driver.findElement(femaleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("10/02/1979");
        Select select=new Select(driver.findElement(departmentBy));
        select.selectByValue("AO");
        BrowserUtils.wait(2);
        Select select2=new Select(driver.findElement(jobTitleBy));
        select2.selectByVisibleText("SDET");
        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        String expected="You've successfully completed registration!";
        String actual=driver.findElement(By.xpath("//*[@id='content']//p")).getText();
        BrowserUtils.wait(2);

        Assert.assertEquals(actual,expected);


    }










    @BeforeMethod
    public void setup(){
       driver= DriverFactory.createADriver("chrome");
       driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(10);
    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
