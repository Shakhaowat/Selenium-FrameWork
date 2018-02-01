package homepage;

import common.ShareAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderAmazon extends ShareAPI {
        @FindBy(how = How.XPATH, using = ".//*[@id='nav-orders']/span[2]")
        public static WebElement Order;
        @FindBy(how = How.XPATH, using = ".//*[@id='ap_email']")
        public static WebElement Email;
        @FindBy(how = How.XPATH, using = ".//*[@id='ap_password']")
        public static WebElement passwordBox;
        @FindBy(how = How.XPATH, using = ".//*[@id='signInSubmit']")
        public static WebElement SignIn;

        public void clickOnorder(){
            Order.click();
        }
        public void SignInAmazon(String email,String password){
            Email.sendKeys(email);
            passwordBox.sendKeys(password);
            SignIn.click();
        }
    }

