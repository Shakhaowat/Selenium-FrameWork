package Home;
import common.ShareAPI;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu extends ShareAPI {
    public List<String> getMenus() throws InterruptedException {
        driver.findElement(By.xpath(".//*[@id='u_0_e']")).sendKeys("shakhaowat");
        driver.findElement(By.name("lastname")).sendKeys("Hossain");
        driver.findElement(By.cssSelector("#u_0_j")).sendKeys("myqc@hotmail.com");
        driver.findElement(By.cssSelector("#u_0_m")).sendKeys("realdonuldtrumph@president.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("000000");

        List<String> items = new ArrayList<>();
    items = getTextFromWebElements("#month option");
    //clickByCssSlector("#month");
        driver.findElement(By.cssSelector("#month")).sendKeys("Jun");
    items = getTextFromWebElements("#day option");
        driver.findElement(By.cssSelector("#day")).sendKeys("15");
    items = getTextFromWebElements("#year option");
        driver.findElement(By.cssSelector("#year")).sendKeys("1983");
        Thread.sleep(3000);
    //items = getTextFromWebElements("#sex option");
        driver.findElement(By.xpath("//input[@value='2']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#u_0_w")).click();
    sleepFor(5);
        for (String item:items){
        System.out.println("item:"+item);
    }
        return items;
}
    @FindBy(xpath ="//*[@id=\"email\"]")
    WebElement Emailid;
    @FindBy(xpath="//*[@id=\"pass\"]")
    WebElement PassWord;


   public void shakDatabse(String email,String pass) {
       Emailid.sendKeys(email);
       PassWord.sendKeys(pass);

   }


}
