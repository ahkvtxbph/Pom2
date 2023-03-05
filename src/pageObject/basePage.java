package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class basePage {
    public WebDriver driver;


    public basePage(WebDriver driver)
    {
        this.driver = driver;
    }




    public void writeText (By element, String toFill)
    {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(toFill);
    }

    public void click (By clickable)
    {

        driver.findElement(clickable).click();
    }

    public void basePage1(WebDriver driver) {
        new basePage(driver);
    }
}
