package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsAndTabsExample {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);

        String ParentWin = driver.getWindowHandle();
        System.out.println("Before Clicking Tab button the win is " + ParentWin);

        WebElement TabButton = driver.findElement(By.id("tabButton"));
        TabButton.click();
        System.out.println("After clicking the tab button");

        Set<String> allWinHan = driver.getWindowHandles();

        for(String win:allWinHan){
            if(!win.equals(ParentWin)){
                driver.switchTo().window(win);
            }
        }
        WebElement childHeader = driver.findElement(By.id("sampleHeading"));
        System.out.println(childHeader.getText());
        driver.switchTo().window(ParentWin);

        WebElement WinBtn = driver.findElement(By.id("windowButton"));
        WinBtn.click();

        driver.quit();

    }
}
