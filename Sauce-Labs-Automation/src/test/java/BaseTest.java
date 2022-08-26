import org.junit.AfterClass;
import org.junit.Before;
import utilities.DriverManager;

public class BaseTest {

    @Before
    public void setUp(){
        DriverManager.getDriver().driver.get("https://www.saucedemo.com/");
        DriverManager.getDriver().driver.manage().window().maximize();
    }

    @AfterClass
    public static void CleanUp(){
        DriverManager.getDriver().driver.close();
    }
}
