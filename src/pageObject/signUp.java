package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class signUp extends basePage{

    public signUp (WebDriver driver)
    {
        super(driver);
    }

    By mainLoginButton  = By.partialLinkText("כניסה / הרשמה");
    By signUpButton = By.cssSelector("span[class='text-link theme']");
    By buymeFirstName= By.cssSelector("input#ember1987");
    By buymeEmail= By.cssSelector("input#ember1876");
    By buymePass = By.cssSelector("input#valPass");
    By buymePassV = By.cssSelector("input#ember2008");
    By checkBoxAgree = By.cssSelector("div#ember2014");
    By checkBoxDivur = By.cssSelector("div#ember2016");
    By buttonReg = By.cssSelector("button#ember1900");


    public signUp buymeFirstNameText (String text)
    {
        writeText (buymeFirstName, text);
        return this;
    }

    public signUp buymeEmailText (String text)
    {
        writeText (buymeEmail, text);
        return this;
    }

    public signUp buymePassText (String text)
    {System.out.println("Shilo: "+text);
        writeText (buymePass, text);
        return this;
    }

    public signUp buymePassVText (String text)
    {
        writeText (buymePassV, text);
        return this;
    }


    public signUp mainLoginButtonClick ()
    {
        click (mainLoginButton);
        return this;
    }

    public signUp loginButtonClick ()
    {
        click (signUpButton);
        return this;
    }



    public signUp checkBoxAgreeClick ()
    {
        click (checkBoxAgree);
        return this;
    }

    public signUp checkBoxDivurClick ()
    {
        click (checkBoxDivur);
        return this;
    }

    public signUp buttonRegClick ()
    {
        click (buttonReg);
        return this;
    }


    public void loginMainLoginButton() {
        mainLoginButtonClick();
    }

    public void signUpButton() {
        loginButtonClick();
    }
    public void buymeFirstName(String name)
    {buymeFirstNameText(name); }
    public void buymeEmail(String email) {

        buymeEmailText(email);
    }

    public void buymePass(String pass) {
        buymePassText(pass);
    }
    public void buymePassV(String passV) {  buymePassVText(passV);   }
    public void checkBoxAgree() {checkBoxAgreeClick();}
    public void checkBoxDivur(){checkBoxDivurClick();}
    public void buttonReg() {  buttonRegClick();   }




    public boolean validate() {
      boolean result=driver.findElement(By.cssSelector("li.parsley-type")).isDisplayed();
        if (!result)
        { return  true;
        }
        else  return false;

    }
}
