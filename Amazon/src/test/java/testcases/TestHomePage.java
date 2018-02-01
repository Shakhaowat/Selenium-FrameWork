package testcases;

import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestHomePage extends HomePage {
    @Test
    public void Homepagetest(){
        HomePage h= PageFactory.initElements(driver,HomePage.class);
        h.SignInAmazon("shakhaowat","12345");
    }

}
