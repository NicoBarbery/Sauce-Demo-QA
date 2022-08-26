package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page factor patron
public class Login {

    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement usernametxb;

    @FindBy(id = "password")
    WebElement passwordtxb;

    @FindBy(id = "login-button")
    WebElement loginbtn;

    @FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3")
    WebElement loginError;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //hace el findElements
    }

    public void setUsername(String username){
        usernametxb.sendKeys(username);
    }
    public void setPassword(String password){
        passwordtxb.sendKeys(password);
    }
    public void clickLogin(){
        loginbtn.click();
    }

    public String loginErrorMsg(){
        String errorMesg = loginError.getText();
        return errorMesg;
    }
}
