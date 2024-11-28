package org.ibs.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoTest {

    @Test
    void test() {
System.setProperty("webdriver.chromedriver.driver," ,
        "\\src\\test\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qualit.appline.ru/");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().scriptTimeout();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement btnSandbox = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
            btnSandbox.click();

        WebElement btnGoods = driver.findElement(By.xpath("//a[@href='/food']"));
            btnGoods.click();

        WebElement btnAdd = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
            btnAdd.click();

        WebElement titleAddingGoods = driver.findElement(By.xpath("//h5[@class='modal-title']"));

        //Assertions.assertEquals("Добавление товара", titleAddingGoods, "Не открылось окно");

        WebElement btnInputNameOfGoods = driver.findElement(By.xpath("//input[@id='name']"));
            btnInputNameOfGoods.sendKeys("Груша");

        WebElement btnTypeOfGoods = driver.findElement(By.xpath(
                "//select[@id='type']/..//option[@value='FRUIT']"));
            btnTypeOfGoods.click();

        WebElement btnCheckBoxExotic = driver.findElement(By.xpath("//input[@id='exotic']"));
            btnCheckBoxExotic.click();
        Assertions.assertTrue(btnCheckBoxExotic.isSelected());

        WebElement btnSave = driver.findElement(By.xpath("//button[@id='save']"));
            btnSave.click();
        try{
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

        //driver.manage().timeouts().scriptTimeout()
    }
}
