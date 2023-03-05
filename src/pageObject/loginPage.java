package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class loginPage extends basePage
{



    public loginPage (WebDriver driver)
    {

        super(driver);
    }

    public By googleLogin= By.cssSelector("div.social-btn.google");
    public By facebookLogin= By.cssSelector("div.social-btn.facebook");
    public By mainLoginButton  = By.partialLinkText("כניסה / הרשמה");
    public By loginButton = By.cssSelector("span.text-link.theme");
    public By buymeEmail= By.cssSelector("input#ember1900");
    public  By buymePass = By.cssSelector("input#ember1907");
    public  By remember = By.cssSelector("div#ember1981");
    public By recover = By.cssSelector("u.bm-body-2.text-link.theme.db");
    public By buttonReg = By.cssSelector("div#ember2037");

    public loginPage buymeEmailText (String text)
    {
        writeText (buymeEmail, text);
        return this;
    }

    public loginPage buymePassText (String text)
    {
        writeText (buymePass, text);
        return this;
    }


    public loginPage mainLoginButtonClick ()
    {
        click (mainLoginButton);
        return this;
    }
    public loginPage loginButtonClick ()
    {
        click (loginButton);
        return this;
    }

    public loginPage recoverClick ()
    {
        click (recover);
        return this;
    }

    public loginPage rememberClick ()
    {
        click (remember);
        return this;
    }

    public loginPage buttonRegClick ()
    {
        click (buttonReg);
        return this;
    }

    public loginPage facebookegClick ()
    {
        click (facebookLogin);
        return this;
    }

    public loginPage googleClick ()
    {
        click (googleLogin);
        return this;
    }






    public void mainLoginButton() {
        mainLoginButtonClick();
    }

    public void loginButton() {
        loginButtonClick();
    }

    public void buymeEmail(String email) {
        buymeEmailText(email);
    }

    public void buymePass(String pass) {
        buymePassText(pass);
    }

    public void buttonReg() {
        buttonRegClick();
    }


}
