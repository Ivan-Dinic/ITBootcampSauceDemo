package Base;

import Pages.SidebarPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Pages.*;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public Login loginPage;
    public SidebarPage sidebarPage;
    public CartPage cartPage;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new Login();
        sidebarPage = new SidebarPage();
        cartPage = new CartPage();

    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }

    //-------------------------------------------------------------------------


    public void loginUserWithCredentials(String username, String password) {
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
    }

    public void resetAppState() {
        sidebarPage.clickOnHamburgerMenu();
        sidebarPage.clickOnHamburgerMenuItem("Reset App State");
        driver.navigate().refresh();
    }

    public void scrollIntoElementView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForAllElementsVisibility(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementDisplayed(WebElement element) {
        boolean elementIsDisplayed = false;
        try {
            elementIsDisplayed = element.isDisplayed();
        } catch(Exception ignored) {

        }

        return elementIsDisplayed;
    }

    public void switchToNewWindow() {
        String mainWindow = driver.getWindowHandle();

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
}
