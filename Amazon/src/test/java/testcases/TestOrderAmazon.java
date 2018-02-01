package testcases;

import homepage.OrderAmazon;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
public class TestOrderAmazon extends OrderAmazon {
@Test
 public void testOrder() {
  OrderAmazon Order = PageFactory.initElements(driver,OrderAmazon.class);
  Order.SignInAmazon("bhuiyan","12345");

 }
}