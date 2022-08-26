package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement logo;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement add2CartBtnBackpack;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeProdbtnBackpack;

    @FindBy(className = "product_sort_container")
    WebElement sortDropDown;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menu;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppOpt;

    @FindBy(className = "inventory_item_name")
    List<WebElement> products;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //hace el findElements
    }

    public boolean logoIsDisplayed(){
        boolean logoIsDisplayed = logo.isDisplayed();
        return logoIsDisplayed;
    }
    public boolean IsSortedZA(){
        List<String> actualProdOrder = new ArrayList<>();
        for(WebElement element: products){
            actualProdOrder.add(element.getText());
        }
        boolean isSorted = Ordering.natural().reverse().isOrdered(actualProdOrder);
        return isSorted;
    }

    public boolean IsSortedAZ(){
        List<String> actualProdOrder = new ArrayList<>();
        for(WebElement element: products){
            actualProdOrder.add(element.getText());
        }
        boolean isSorted = Ordering.natural().isOrdered(actualProdOrder);
        return isSorted;
    }

    public String getCartIconText(){
        String cartText = cartIcon.getText();
        return cartText;
    }
    public void clickOnAddCartBackPackBtn(){
        add2CartBtnBackpack.click();
    }
    public void clickOnRemoveBackPack(){
        removeProdbtnBackpack.click();
    }

    public void dropDownAndZ2A(){
        Select select = new Select(sortDropDown);
        select.selectByValue("za");
    }
    public void dropDownAndA2Z(){
        Select select = new Select(sortDropDown);
        select.selectByValue("az");
    }
    public void dropDownAndHighPrice(){
        Select select = new Select(sortDropDown);
        select.selectByValue("hilo");
    }
    public void dropDownAndLowPrice(){
        Select select = new Select(sortDropDown);
        select.selectByValue("lohi");
    }

    public void menuClick(){
        menu.click();
    }

    public void menuResetAppClick(){ // MAL
        Select select = new Select(menu);
        select.selectByVisibleText("Reset App State");
    }

}
