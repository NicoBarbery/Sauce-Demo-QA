import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.HomePage;
import pages.Login;
import utilities.DriverManager;

public class HomePageTests extends BaseTest{

    Login loginpage = new Login(DriverManager.getDriver().driver);
    HomePage homepage = new HomePage(DriverManager.getDriver().driver);

    @Test
    public void number1Cart(){
        loginpage.setUsername("standard_user");
        loginpage.setPassword("secret_sauce");
        loginpage.clickLogin();
        Assert.assertTrue(homepage.logoIsDisplayed());
        //
        homepage.clickOnAddCartBackPackBtn();
        Assert.assertEquals( "1", homepage.getCartIconText());
    }

    @Test
    public void verify1IsNotThere(){
        loginpage.setUsername("standard_user");
        loginpage.setPassword("secret_sauce");
        loginpage.clickLogin();
        Assert.assertTrue(homepage.logoIsDisplayed());
        //
        homepage.clickOnAddCartBackPackBtn();
        homepage.clickOnRemoveBackPack();
        Assert.assertEquals("", homepage.getCartIconText());
    }

    @Test
    public void orderZ2A(){
        loginpage.setUsername("standard_user");
        loginpage.setPassword("secret_sauce");
        loginpage.clickLogin();
        Assert.assertTrue(homepage.logoIsDisplayed());
        //
        homepage.dropDownAndZ2A();
        Assert.assertTrue(homepage.IsSortedZA());
    }

    @Test
    public void orderA2Z(){
        loginpage.setUsername("standard_user");
        loginpage.setPassword("secret_sauce");
        loginpage.clickLogin();
        Assert.assertTrue(homepage.logoIsDisplayed());
        //
        homepage.dropDownAndA2Z();
        Assert.assertTrue(homepage.IsSortedAZ());
    }

    @Test
    public void orderHighPrice(){
        loginpage.setUsername("standard_user");
        loginpage.setPassword("secret_sauce");
        loginpage.clickLogin();
        Assert.assertTrue(homepage.logoIsDisplayed());
        //
        homepage.dropDownAndHighPrice();
    }

    @Test
    public void orderLowPrice(){
        loginpage.setUsername("standard_user");
        loginpage.setPassword("secret_sauce");
        loginpage.clickLogin();
        Assert.assertTrue(homepage.logoIsDisplayed());
        //
        homepage.dropDownAndLowPrice();
    }

    /*
    @Test @Ignore
    public void resetAppTest(){
        loginpage.setUsername("standard_user");
        loginpage.setPassword("secret_sauce");
        loginpage.clickLogin();
        Assert.assertTrue(homepage.logoIsDisplayed());
        //
        homepage.clickOnAddCartBackPackBtn();
        //
        homepage.menuClick();
        homepage.menuResetAppClick();
        //Assert.assertEquals("", homepage.getCartIconText());
    }*/




}
