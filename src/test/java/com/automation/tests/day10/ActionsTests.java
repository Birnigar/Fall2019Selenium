package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {
    private WebDriver driver;
    private Actions actions;
    private String URL="http://qa2.vytrack.com/user/login";
    private By userNameBy= By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By activitiesBy=By.xpath("//span[@class='title title-level-1'  and contains(text(), 'Activities')]");
    private String storeManagerUserName="storemanager85";
    private String storeManagerPassword="UserUser123";
    private By logCallBtnBy=By.cssSelector("a[title='Log call']");
    //builder pattern => you put one method then you can take action
//builder pattern == chaining methods
//what is build?
//if you have multiple actions you have to put build
//to combine a couple of actions.
//build() is needed when you have couple of actions
//build combines the action; perform; starts the action
//in this example; first we move to one image then second so we used build
//always end with perform
//perform does not click, it starts the action, execute the event
//you can perform click, drag and drop etc
//actions class has different implementations
//moveToElement returns instance of action class that's why we can chain them


    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createADriver("chrome");
       driver.get(URL);
        driver.manage().window().maximize();

        actions=new Actions(driver);
        BrowserUtils.wait(5);

        driver.findElement(userNameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword);
    }
    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1=driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2=driver.findElement(By.xpath("(//img)[2]"));

        //build() is needed when you have couple of actions
        //perform is start the actions
        //pause - like a thread.sleep
        //always end with perform
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                build().perform();



    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
