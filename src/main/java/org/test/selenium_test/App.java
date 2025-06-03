package org.test.selenium_test;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class App {
  public static void main(String[] args) throws InterruptedException, IOException {
    System.out.println("Hello World!");
    
    //run in headless mode
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    WebDriver driver = new ChromeDriver(options);
    //Chromedriver definition
    //WebDriver driver = new ChromeDriver();
    //1.Open the URL
    driver.get("http://54.146.26.166:8080/addressbook-2.0/");
    
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

    //2.Locate new contact button and click
    
    driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[1]/div/div/div[2]/div")).click();
    
    
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

    //3.Locate first name and enter first namea
    
    driver.findElement(By.id("gwt-uid-5")).sendKeys("Gourav");
    
    
    //4.locate last name and enter last name
    driver.findElement(By.id("gwt-uid-7")).sendKeys("Chakraborty");
    
    //5.locate phone number and enter phone number
    driver.findElement(By.id("gwt-uid-9")).sendKeys("9999999");
    
    //6.Locate email and enter email
    driver.findElement(By.id("gwt-uid-11")).sendKeys("abc@abc.com");
    
    //7.Locate birthday and enter birthday
    driver.findElement(By.id("gwt-uid-13")).sendKeys("12/12/2012,");
    
    //8.Locate save button and click save
    driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[3]/div/div[1]/div")).click();
    
    
    Thread.sleep(4000);
    
	/*
	 * WebDriver driver = new ChromeDriver();
	 * 
	 * driver.get("https://www.selenium.dev/selenium/web/web-form.html");
	 * 
	 * driver.getTitle();
	 * 
	 * driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	 * 
	 * WebElement textBox = driver.findElement(By.name("my-text")); WebElement
	 * password= driver.findElement(By.name("my-password"));
	 * 
	 * WebElement submitButton = driver.findElement(By.cssSelector("button"));
	 * 
	 * WebElement textarea= driver.findElement(By.xpath(
	 * "/html/body/main/div/form/div/div[1]/label[3]/textarea"));
	 * Thread.sleep(1000);
	 * 
	 * textBox.sendKeys("Selenium"); Thread.sleep(1000);
	 * password.sendKeys("password"); Thread.sleep(1000);
	 * textarea.sendKeys("How are you?"); Thread.sleep(1000); submitButton.click();
	 * Thread.sleep(2000); WebElement message =
	 * driver.findElement(By.id("message")); message.getText(); Thread.sleep(1000);
	 * 
	 */
	 TakesScreenshot scrShot = ((TakesScreenshot)driver); 
	 File scrFile=scrShot.getScreenshotAs(OutputType.FILE); 
	 File destFile=new File("test-report.jpg"); 
	 FileUtils.copyFile(scrFile,destFile);
	 
	 System.out.println("Script executed and result captured");
    driver.quit();
    
  }
}
