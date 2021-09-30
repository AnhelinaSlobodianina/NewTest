package com.Google;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGoogle {
    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Test\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        // open Google Chrome
        driver.get("https://www.google.com/");

        // open to full screen
        driver.manage().window().maximize();

        // test title of website
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Google"));

        // enter name "Selenium" in search line
        driver.findElement(By.name("q")).sendKeys("Selenium");

        // click enter
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        // click button "Поиск в Google"
        //driver.findElement(By.xpath("//input[@aria-label='Поиск в Google']")).click();

        // test the title of result
        String t =  driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']")).getText();
        Assert.assertTrue(t.equals("Selenium"));

        // close Google Chrome
        driver.quit();
    }
}
