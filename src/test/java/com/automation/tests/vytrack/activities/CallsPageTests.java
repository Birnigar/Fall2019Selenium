package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests {
    private WebDriver driver;
    private Actions actions;
    private String Url="http://qa2.vytrack.com/user/login";
    private By userNameBy= By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By activitiesBy=By.xpath("//span[@class='title title-level-1'  and contains(text(), 'Activities')]");
    private String storeManagerUserName="storemanager85";
    private String storeManagerPassword="UserUser123";
    private By logCallBtnBy=By.cssSelector("a[title='Log call']");


    /*
    Login as story manager
    Go to activities--> Calls
    Verify that Log Call button is displayed
     */
    @BeforeMethod
  public void setup(){
      driver= DriverFactory.createADriver("chrome");
      driver.get(Url);
      driver.manage().window().maximize();
      actions=new Actions(driver);

      BrowserUtils.wait(3);

      driver.findElement(userNameBy).sendKeys(storeManagerUserName);
      driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);

      BrowserUtils.wait(15);
      //hover over Activities
      actions.moveToElement(driver.findElement(activitiesBy)).perform();
      BrowserUtils.wait(2);
      driver.findElement(By.linkText("Calls")).click();
      BrowserUtils.wait(5);
  }
  @Test
  public void verifyLogCallButton(){
     WebElement logCallBtnElement= driver.findElement(logCallBtnBy);
      Assert.assertTrue(logCallBtnElement.isDisplayed());
      BrowserUtils.wait(2);


  }

  @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
  }








}
