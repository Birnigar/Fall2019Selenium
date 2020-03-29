package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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

        WebElement img3=driver.findElement(By.xpath("(//img)[3]"));
        //build() is needed when you have couple of actions
        //perform is start the actions
        //pause - like a thread.sleep
        //always end with perform
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();
        BrowserUtils.wait(3);


        actions.moveToElement(img1).perform();
        WebElement imgText1=driver.findElement(By.xpath("//h5[text()='name: user1']"));
        BrowserUtils.wait(3);

        Assert.assertTrue(imgText1.isDisplayed());

        BrowserUtils.wait(3);

        actions.moveToElement(img2).perform();
        WebElement imgText2=driver.findElement(By.xpath("//h5[text()='name: user2']"));
        BrowserUtils.wait(3);

        Assert.assertTrue(imgText2.isDisplayed());
    }
    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        BrowserUtils.wait(3);
        //hover on "enabled'
        //hover on 'downloads'
        //click on pdf

        WebElement enabled=driver.findElement(By.id("ui-id-3"));
        WebElement download=driver.findElement(By.id("ui-id-4"));
        WebElement pdf=driver.findElement(By.id("ui-id-5"));

       actions.moveToElement(enabled).
               pause(1000).
               moveToElement(download).
               pause(1000).
               click(pdf).
               build().perform();


        }

        @Test
        public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(3);


        WebElement earth=driver.findElement(By.id("droptarget"));
        WebElement moon=driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon,earth).perform();
        BrowserUtils.wait(5);

        String expected="You did great!";
        String actual=earth.getText();
        BrowserUtils.wait(5);

        Assert.assertEquals(actual,expected);

        }



    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
