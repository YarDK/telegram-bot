package src.gitdoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ChromeChek {
    private String result;
    private WebDriver wd;

    public String getResult() {
        return result;
    }

    public void init(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        wd = new ChromeDriver(options);

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(url);
        if(netVNalichee().contains("Нет в наличии")) result = "Все еще нет в наличии";
        else result = "Я бы проверил";

    }

    public String netVNalichee(){
        By not_available = By.className("ProductHeader__not-available-header");
        waitForElementPresent(not_available);
        return wd.findElement(not_available).getText();
    }


    public WebElement waitForElementPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wait.withMessage("Element not present" + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void stop(){
        wd.quit();
    }


}
