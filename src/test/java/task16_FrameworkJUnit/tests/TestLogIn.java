package task16_FrameworkJUnit.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import utils.Log;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLogIn extends BeAfAll{

    @Test
    @Order(1)
    @DisplayName("Тест на вход пользователя")
    public void logIn() {

        Log.info("Вводим e-mail");
        driver.findElement(By.id("session_email")).sendKeys("user@user.test");

        Log.info("Вводим пароль");
        driver.findElement(By.name("session[password]")).sendKeys("user");

        Log.info("Кликаем вход");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

        Log.info("Проверяем, что открылась корректная страница");
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/", currentURL,
                "Открыта не правильная страница или адресс страницы неверный");
    }

}
