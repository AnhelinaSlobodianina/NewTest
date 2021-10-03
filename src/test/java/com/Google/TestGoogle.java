package com.Google;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestGoogle {

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\chromedriver.exe");
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
        //driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        // click button "Поиск в Google"
        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
        el.click();

        /*  List<WebElement> elements = driver.findElements(By.xpath("//div[@class ='g']"));
        for (WebElement i : elements) {
            if(i.getText()!=null)
            {
            System.out.println(i.getText().contains("elenium"));}
        }*/

        // test the title of result
        String t =  driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']")).getText();
        Assert.assertTrue(t.contains("Selenium"));

        WebElement element1 =  driver.findElement(By.xpath("//div[@class ='g']"));
        Assert.assertTrue(element1.getText().contains("Selenium"));

        WebElement element2 =  driver.findElement(By.xpath("//div[@class ='g'][position()=3]"));
        Assert.assertTrue(element2.getText().contains("Selenium"));

        WebElement element3 =  driver.findElement(By.xpath("//div[@class ='g'][last()]"));
        Assert.assertTrue(element3.getText().contains("Selenium"));

        List<WebElement> elements =  driver.findElements(By.cssSelector("div.fc9yUc.oz3cqf.p5AXld"));
        for (WebElement i : elements) {
            Assert.assertTrue(i.getText().contains("Selenium")||i.getText().contains("тест"));
        }

        // close Google Chrome
        driver.quit();
    }
}
