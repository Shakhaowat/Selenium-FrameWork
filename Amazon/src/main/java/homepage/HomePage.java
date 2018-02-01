package homepage;

import common.ShareAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utility.ReadExcelFile;

import java.util.concurrent.TimeUnit;

public class HomePage extends ShareAPI {
    //Actions ac = new Actions(driver);
    //JavascriptExecutor jsc = (JavascriptExecutor) driver;
    //WebElement scrollBar;
    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/span[1]")
    WebElement SignINbutton;
    @FindBy(xpath = ".//*[@id='nav-link-shopall']/span[2]/span")
    WebElement department;
    @FindBy(xpath = ".//*[@id='twotabsearchtextbox']")
    WebElement baramazon;
    @FindBy(css = "#nav-search > form > div.nav-right > div > input")
    WebElement clicksearch;
    @FindBy(css = "#nav-link-accountList > span.nav-line-2")
    WebElement demoSign;
    @FindBy(css="#nav-link-accountList > span.nav-line-2")
    WebElement realSign;
    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    WebElement Email;
    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    WebElement PassW;
    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    WebElement logIn;
    public void clickDepartment() {
        department.click();
        baramazon.sendKeys("books");
        clicksearch.click();
    }
    public void signIN() {
        //ac.moveToElement(demoSign).moveToElement(realSign).click().build().perform();
    }
    public void SignInAmazon(String email,String password){
        //signIN();
       // ac.moveToElement(demoSign).moveToElement(realSign).click().build().perform();
        SignINbutton.click();
        Email.sendKeys(email);
        PassW.sendKeys(password);
        logIn.click();
    }

}