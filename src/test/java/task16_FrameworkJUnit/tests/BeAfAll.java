package task16_FrameworkJUnit.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;

public class BeAfAll {

    protected WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    @DisplayName("Авторизация на сайте")
    public void start() {

        Log.info("Открываем страницу a.testaddressbook.com/sign_in");
        driver.get("http://a.testaddressbook.com/sign_in/");

        Log.info("Проверяем, что открылась корректная страница");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Address Book - Sign In", pageTitle,
                "Открыта не правильная страница или название страницы неверно");

    }

    @AfterAll
    @DisplayName("Закрытие браузера")
    public void tearDown() {

        Log.info("Закрываем браузер");
        driver.quit();

    }

}
