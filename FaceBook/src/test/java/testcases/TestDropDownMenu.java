package testcases;

import Home.DropDownMenu;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestDropDownMenu extends DropDownMenu {
    @Test
    public void drop() throws InterruptedException {
        DropDownMenu dropDownMenu = PageFactory.initElements(driver, DropDownMenu.class);
        dropDownMenu.getMenus();
    }
}
