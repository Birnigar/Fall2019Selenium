package com.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Selenium_Office_Hour_03_17_2020 {

    private WebDriver driver;
    private String url="https://qa3.vytrack.com/user/login";
    private String username = "storemanager85";   //   valid username
    private String password = "UserUser123";      //   valid password
    private By usernameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By clickLogin=By.id("_submit");

    @BeforeMethod
    protected void setup(){
        driver= DriverFactory.createADriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    protected void login(){

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(clickLogin).submit();
        BrowserUtils.wait(15);
    }
    @Test
    protected void createContact(){
        WebElement contactLink=driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        contactLink.click();
        BrowserUtils.wait(5);
        WebElement creatingContact=driver.findElement(By.linkText("Create Contact"));
        creatingContact.click();

        String currentTitle=driver.getTitle();
        Assert.assertEquals(currentTitle,"Create Contact - Contacts - Customers");

        HashMap<String,String> contact1= new HashMap<>();
        contact1.put("First Name","John");
        contact1.put("Last Name","Smith");
        contact1.put("Phone","571-236-4545");
        contact1.put("Street","400 Main Street");
        contact1.put("City","Tysons");
        contact1.put("State","VA");
        contact1.put("Zip Code","22120");
        contact1.put("Sales Group","true");
        contact1.put("Country","United States");

        System.out.println("Contact1: "+contact1);

        WebElement firstName=driver.findElement(By.xpath("//input[@data-name = 'field__first-name'][1]"));
        WebElement lastName=driver.findElement(By.xpath("//input[@data-name = 'field__last-name'][1]"));
        WebElement phone=driver.findElement(By.xpath("//input[@data-name = 'field__phone']"));
        WebElement street=driver.findElement(By.name("oro_contact_form[addresses][0][street]"));
        WebElement city=driver.findElement(By.name("oro_contact_form[addresses][0][city]"));
        WebElement state=driver.findElement(By.xpath("//input[@data-name='field__region-text']"));
        WebElement zipCode=driver.findElement(By.name("oro_contact_form[addresses][0][postalCode]"));
        WebElement salesGroup=driver.findElement(By.xpath("//label[contains(text(),'Sales Group')]"));

        Select country=new Select(driver.findElement(By.name("oro-contact-form[addresses][0][country]")));

        firstName.sendKeys(contact1.get("First Name"));

        country.selectByValue("US");

    }
}
