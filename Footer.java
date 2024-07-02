package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class Footer {

    WebDriver driver;
    List<WebElement> sociallinks;

    public Footer(WebDriver driver){
        this.driver = driver;
    }
    public List<WebElement> getSociallinks(){
        return driver.findElements(By.cssSelector("ul.social>li"));
    }

    public void clickOnFooterLinks(){
        for (WebElement link:getSociallinks()){
            link.click();
        }
    }

}
