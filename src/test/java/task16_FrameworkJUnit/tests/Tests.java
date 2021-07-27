package task16_FrameworkJUnit.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import utils.Log;

import static task16_FrameworkJUnit.locators.Locators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests extends TestLogIn {

    @Test
    @Order(2)
    @DisplayName("Тест на добавление адреса")
    public void testAddAdress() {

        Log.info("Кликаем вкладку адреса");
        driver.findElement(By.xpath("//a[@class='nav-item nav-link'][1]")).click();

        Log.info("Кликаем создать новый адрес");
        driver.findElement(By.xpath("//a[@class='row justify-content-center']")).click();

        Log.info("Заполняем First name");
        driver.findElement(FIRST_NAME).sendKeys("First name");

        Log.info("Заполняем Last name");
        driver.findElement(LAST_NAME).sendKeys("Last name");

        Log.info("Заполняем Address1");
        driver.findElement(ADDRESS1).sendKeys("Address1");

        Log.info("Заполняем Address2");
        driver.findElement(ADDRESS2).sendKeys("Address2");

        Log.info("Заполняем город");
        driver.findElement(By.id("address_city")).sendKeys("Minsk");

        Log.info("Выбираем Гавайи");
        driver.findElement(By.xpath("//option[@value='HI']")).click();

        Log.info("Заполняем зип код");
        driver.findElement(By.id("address_zip_code")).sendKeys("9379992");

        Log.info("Выбираем страну");
        driver.findElement(By.id("address_country_us")).click();

        Log.info("Заполнение дня рождения (Календарь)");
        driver.findElement(By.id("address_birthday")).sendKeys("19021993");

        Log.info("Выбираем цвет");
        driver.findElement(By.id("address_color")).sendKeys("#00FF08");

        Log.info("Заполняем возвраст)");
        driver.findElement(By.id("address_age")).sendKeys("28");

        Log.info("Заполняем веб-сайт");
        driver.findElement(By.id("address_website")).sendKeys("https://www.google.com/");

        Log.info("Выбираем файл для загрузки");
        driver.findElement(By.id("address_picture")).sendKeys(PICTURE);

        Log.info("Заполняем номер телефона");
        driver.findElement(By.id("address_phone")).sendKeys("2020327");

        Log.info("Выбираем интересы");
        driver.findElement(By.id("address_interest_read")).click();

        Log.info("Заполняем примечания");
        driver.findElement(By.id("address_note")).sendKeys("Примечание");

        Log.info("Кликаем создать адресс");
        driver.findElement(By.xpath("//input[@value='Create Address']")).click();

        Log.info("Кликаем на список адресов");
        driver.findElement(By.cssSelector("a[data-test='list']")).click();

        Log.info("Проверяем, что открылась корректная страница");
        String currentURL1 = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/addresses", currentURL1,
                "Открыта не правильная страница или адресс страницы неверный");
    }

    @Test
    @Order(3)
    @DisplayName("Тест на редактирование адреса")
    public void testEditAdress() {

        Log.info("Кликаем редактировать адрес");
        driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a")).click();

        Log.info("Очищаем строку First name");
        driver.findElement(FIRST_NAME).clear();

        Log.info("Редактируем строку First name");
        driver.findElement(FIRST_NAME).sendKeys("First name EDIT");

        Log.info("Очищаем строку Last name");
        driver.findElement(LAST_NAME).clear();

        Log.info("Редактируем строку Last name");
        driver.findElement(LAST_NAME).sendKeys("Last name EDIT");

        Log.info("Очищаем строку Address1");
        driver.findElement(ADDRESS1).clear();

        Log.info("Редактируем строку Address1");
        driver.findElement(ADDRESS1).sendKeys("Address1 EDIT");

        Log.info("Очищаем строку Address2");
        driver.findElement(ADDRESS2).clear();

        Log.info("Редактируем строку Address2");
        driver.findElement(ADDRESS2).sendKeys("Address2 EDIT");

        Log.info("Редактируем штат");
        driver.findElement(By.xpath("//option[@value='TX']")).click();

        Log.info("Кликаем обновить адресс");
        driver.findElement(By.xpath("//input[@value='Update Address']")).click();

        Log.info("Кликаем на список адресов");
        driver.findElement(By.cssSelector("a[data-test='list']")).click();

        Log.info("Проверяем, что открылась корректная страница");
        String currentURL2 = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/addresses", currentURL2,
                "Открыта не правильная страница или адресс страницы неверный");
    }

    @Test
    @Order(4)
    @DisplayName("Тест на удаление адреса")
    public void testDelitAdress() {

        Log.info("Кликаем удалить адресс");
        driver.findElement(By.xpath("//tbody/tr/td[7]/a")).click();

        Log.info("Жмем ОК на всплывающем окне для подтверждения удаления адреса");
        driver.switchTo().alert().accept();

        Log.info("Проверяем, что открылась корректная страница");
        String currentURL3 = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/addresses", currentURL3,
                "Открыта не правильная страница или адресс страницы неверный");
    }

    @Test
    @Disabled("Тест на выход пользователя")
    public void testSingOut() {

        Log.info("Кликаем на выход пользователя Sing Out");
        driver.findElement(By.xpath("//a[@class='nav-item nav-link'][2]")).click();

        Log.info("Проверяем, что открылась корректная страница");
        String currentURL4 = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentURL4,
                "Открыта не правильная страница или адресс страницы неверный");
    }

}
