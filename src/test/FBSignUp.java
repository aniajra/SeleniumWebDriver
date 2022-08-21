package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FBSignUp {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);


        //Step1: Click Sign Up Button
        WebElement SignUpButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        SignUpButton.click();
        //Thread.sleep(1000);

        WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement Surname = driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement Mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));


        FirstName.sendKeys("FirstName");
        Surname.sendKeys("LastName");
        Mobile.sendKeys("123456789");
        Password.sendKeys("abc@123");

        //DropDown
        WebElement birthdayDay = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        WebElement birthdayMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        WebElement birthdayYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));

        Select Day = new Select(birthdayDay);
        Day.selectByVisibleText("13");

        Select Month = new Select(birthdayMonth);
        System.out.println("First Selected Option "+ Month.getFirstSelectedOption().getText());
        //xpath for the selected - //select[@name='birthday_month']/option[@selected=1]

        Month.selectByVisibleText("Nov");

        Select Year = new Select(birthdayYear);
        Year.selectByVisibleText("1984");

        List<WebElement> Months = Month.getOptions();

        for(WebElement elm:Months){
            System.out.println(elm.getText());
        }

        List<WebElement> AllMonths = driver.findElements(By.xpath("//select[@name='birthday_month']/option"));

        for(WebElement elm: AllMonths) {
            System.out.println(elm.getText());
        }

        WebElement male = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
        male.click();
        String Gender = "Male";

        WebElement Female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
        WebElement Male = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
        WebElement Other = driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));

        if(Gender.equals("Female")) {
            Female.click();
        }else if(Gender.equals("Male")) {
            Male.click();
        }else {
            Other.click();
        }


    }



}
