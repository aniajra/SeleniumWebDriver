package test;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.simplilearn.com/");
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Step 1 : Login Click
        WebElement LoginLink = driver.findElement(By.linkText("Log in"));
        Thread.sleep(1000);
        LoginLink.click();

        //Step2: Enter Username
        WebElement UserName = driver.findElement(By.name("user_login"));
        UserName.sendKeys("abc@xyz.com");

        //Step3: Enter Password
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("Test@1234");

        //Step 4: Check Box
        WebElement checkBox = driver.findElement(By.className("rememberMe"));
        checkBox.click();

        //Step 5: Click Login
        WebElement LoginButton = driver.findElement(By.name("btn_login"));
        LoginButton.click();

        //WebElement RememberMe = driver.findElement(By.xpath("//input[@name=’rememberMe’]"));
        //RememberMe.click();

        //Step 6: Validate the Error Message on Screen
        WebElement Error = driver.findElement(By.id("msg_box"));

        String ActError = Error.getText();
        String ValError = "The email or password you have entered is invalid.";

        if(ActError.equals(ValError)){
            System.out.println("TC Passed");
        } else {
            System.out.println("TC Failed");
        }

        List<WebElement> Links = driver.findElements(By.tagName("a"));
        System.out.println("Total num of links are "+ Links.size());

        for (WebElement link:Links) {
            System.out.println(link.getAttribute("href"));
        }
        //driver.close();

    }
}