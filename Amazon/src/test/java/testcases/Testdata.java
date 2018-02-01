package testcases;

import homepage.HomePage;
import javafx.scene.layout.Priority;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ReadExcelFile;

public class Testdata extends HomePage {

    @Test(dataProvider = "testdata")
    public void testMemberLogIn(String username, String password) throws InterruptedException {
        HomePage hp = PageFactory.initElements(driver, HomePage.class);
        hp.SignInAmazon(username, password);
    }
    @DataProvider(name = "testdata")
    public Object[][] TestDataFeed() {
        ReadExcelFile config = new ReadExcelFile("../Amazon/data/file.xls");
        int rows = config.getRowCount(0);
        Object[][] credentials = new Object[rows][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 2; j++) {
                credentials[i][j] = config.getData(0, i, j);
                credentials[i][j] = config.getData(0, i, j);
            }
        }
        return credentials;
    }
}