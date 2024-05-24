package org.Task_17_Snapdeal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal_Automation {

    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        // Initialize the Web_driver to launch the browser
        driver = new ChromeDriver();
        driver.navigate().to("https://www.snapdeal.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Actions class
        Actions actions = new Actions(driver);

        // Move cursor to SignIn and Hold
        WebElement signinbutton = driver.findElement(By.xpath("//div[@class='accountInner']"));
        actions.moveToElement(signinbutton).clickAndHold();
        actions.moveToElement(signinbutton).perform();

        // Wait for the Login button shown in display
        Thread.sleep(2000);

        // Click Login Functions
        WebElement loginbutton = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[2]/span[2]"));
        loginbutton.click();

        // iFrame performs
        driver.switchTo().frame("loginIframe");
        driver.switchTo();
        // Wait for the iFrame loading
        Thread.sleep(2000);

        // SignIn with Email.id
        // Given Email is as per notes dummy e-mailid
        WebElement emailid = driver.findElement(By.xpath("//*[@id='userName']"));
        emailid.sendKeys("Hitler20489@gmail.com");
        driver.findElement(By.xpath("//button[@id='checkUser']")).click();

        /*
         * Note These steps are not belong to task For Login functions other credentials
         * are done here Note Below steps
         */
        Thread.sleep(2000);
        WebElement phnnum = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[10]/div[1]/form[1]/div[1]/div[2]/input[1]"));
        phnnum.sendKeys("7603899026");
        Thread.sleep(2000);
        WebElement name =driver.findElement(By.xpath("/html/body/div/div/div/div[10]/div[1]/form/div[2]/input"));
        name.sendKeys("Hitler");
        /*
         * Note These steps are not belong to task For Login functions other credentials
         * are done here Note Above steps
         */
        // Enter Valid Password
        // Given Email is as per notes dummy password
        WebElement password = driver.findElement(By.xpath("//input[@id='j_password']"));
        password.sendKeys("Hitler04");
        WebElement continuebutton  =  driver.findElement(By.xpath("//button[@id='userSignup']"));
        continuebutton.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div/div/div[10]/div[2]/form/button")).click();

        // Verify its Success or Not
        Thread.sleep(2000);
        WebElement usernamefound = driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']"));
        usernamefound.getText();
        if (usernamefound.equals(name)) {
            System.out.println(usernamefound.equals(name) + "User Login Successfully in Home page");
        } else {
            System.out.println(usernamefound.equals(name) + "User Login UnSuccessfully");
        }

        driver.switchTo().defaultContent();
        // Close the browser
        driver.close();
    }
}