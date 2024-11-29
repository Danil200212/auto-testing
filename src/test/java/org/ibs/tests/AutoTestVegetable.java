package org.ibs.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoTestVegetable {

    @Test
    void test() {
        System.setProperty("webdriver.chromedriver.driver," ,
        "\\src\\test\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qualit.appline.ru/");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        /** Нажимаем на вкладку "Песочница" и в выпадающем списке выбираем вкладку "Товары"
         */
        WebElement btnSandbox = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
            btnSandbox.click();

        WebElement btnGoods = driver.findElement(By.xpath("//a[@href='/food']"));
            btnGoods.click();

        /** Нажать на кнопку "Добавить"
         */
        WebElement btnAdd = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
            btnAdd.click();

        //WebElement titleAddingGoods = driver.findElement(By.xpath("//h5[@id='editModalLabel']"));
        //Assertions.assertEquals("Добавление товара", titleAddingGoods.getText(), "Не открылось окно");

        /** Ввести данные товара в соответствующие в поля
         */
        WebElement btnInputNameOfGoods = driver.findElement(By.xpath("//input[@id='name']"));
            btnInputNameOfGoods.sendKeys("Момордика");

        WebElement btnTypeOfGoods = driver.findElement(By.xpath(
                "//select[@id='type']/..//option[@value='VEGETABLE']"));
            btnTypeOfGoods.click();

        WebElement btnCheckBoxExotic = driver.findElement(By.xpath("//input[@id='exotic']"));
            btnCheckBoxExotic.click();
        Assertions.assertTrue(btnCheckBoxExotic.isSelected());

        /** Нажать на кнопку "Сохранить"
         */
        WebElement btnSave = driver.findElement(By.xpath("//button[@id='save']"));
            btnSave.click();

            WebElement titleRow5 = driver.findElement(By.xpath("//tr[5]/th[@scope='row']"));
            Assertions.assertEquals("5", titleRow5.getText(), "Not add" );

        /** Нажать на кнопку "Добавить"
         */
        WebElement btnAdd1 = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
        btnAdd1.click();

        /** Ввести данные товара (без чек-бокса) в соответствующие в поля
         */
        WebElement btnInputNameOfGoods1 = driver.findElement(By.xpath("//input[@id='name']"));
        btnInputNameOfGoods1.sendKeys("Картофель");

        WebElement btnTypeOfGoods1 = driver.findElement(By.xpath(
                "//select[@id='type']/..//option[@value='FRUIT']"));
        btnTypeOfGoods1.click();

        /** Нажать на кнопку "Сохранить"
         */
        WebElement btnSave1 = driver.findElement(By.xpath("//button[@id='save']"));
        btnSave1.click();

        WebElement titleRow6 = driver.findElement(By.xpath("//tr[6]/th[@scope='row']"));
        Assertions.assertEquals("6", titleRow6.getText(), "Not add" );



        /**Выбрать вкладку "Песочница" и в выпадающем списке нажать на вкладку "Сброс данных"
         */
        WebElement btnSandbox1 = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
            btnSandbox1.click();

        WebElement btnClear = driver.findElement(By.xpath("//a[@id='reset']"));
            btnClear.click();


        try{
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

    }
}
