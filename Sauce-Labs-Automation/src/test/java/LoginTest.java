import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.Login;
import utilities.DriverManager;

public class LoginTest extends BaseTest{

    Login loginpage = new Login(DriverManager.getDriver().driver);
    HomePage homepage = new HomePage(DriverManager.getDriver().driver);
    @Test
    public void LoginSuccess(){
        loginpage.setUsername("standard_user");
        loginpage.setPassword("secret_sauce");
        loginpage.clickLogin();
        Assert.assertTrue(homepage.logoIsDisplayed());
    }

    @Test
    public void LoginWithInvalidCred(){
        loginpage.setUsername("standard_user");
        loginpage.setPassword("wrong_passwrd");
        loginpage.clickLogin();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",
                loginpage.loginErrorMsg());
    }
}
