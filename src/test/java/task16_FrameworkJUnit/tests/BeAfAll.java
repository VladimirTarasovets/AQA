package task16_FrameworkJUnit.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;

public class BeAfAll {

    protected WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    @DisplayName("Авторизация на сайте")
    public void logIn() {

        Log.info("Открываем страницу a.testaddressbook.com/sign_in");
        driver.get("http://a.testaddressbook.com/sign_in/");

        Log.info("Проверяем, что открылась корректная страница");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Address Book - Sign In", pageTitle,
                "Открыта не правильная страница или название страницы неверно");

        Log.info("Вводим e-mail");
        driver.findElement(By.id("session_email")).sendKeys("user@user.test");

        Log.info("Вводим пароль");
        driver.findElement(By.name("session[password]")).sendKeys("user");

        Log.info("Кликаем вход");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

    }

    @AfterAll
    @DisplayName("Закрытие браузера")
    public void tearDown() {

        Log.info("Закрываем браузер");
        driver.quit();

    }


}
