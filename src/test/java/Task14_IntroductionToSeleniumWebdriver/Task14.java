package Task14_IntroductionToSeleniumWebdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;

public class Task14 {

    public static void main(String[] args) {
        System.setProperty("webdriver.opera.driver", "C:\\Users\\Lenovo\\IdeaProjects\\operadriver.exe");
        WebDriver driver = new OperaDriver();
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Логин
        driver.get("http://a.testaddressbook.com/sign_in"); // открываем страницу
        driver.findElement(By.id("session_email")).sendKeys("user@user.test"); //вводим e-mail
        driver.findElement(By.name("session[password]")).sendKeys("user"); //вводим пароль
        driver.findElement(By.cssSelector("input[value='Sign in']")).click(); // кликаем вход

        // 2. Добавление адреса
        driver.findElement(By.xpath("//a[@class='nav-item nav-link'][1]")).click(); // кликаем вкладку адреса
        driver.findElement(By.xpath("//a[@class='row justify-content-center']")).click(); //кликаем новый адрес
        driver.findElement(By.id("address_first_name")).sendKeys("First name"); // заполняем First name
        driver.findElement(By.id("address_last_name")).sendKeys("Last name"); // заполняем Last name
        driver.findElement(By.name("address[address1]")).sendKeys("Address1"); // заполняем Address1
        driver.findElement(By.name("address[address2]")).sendKeys("Address2"); // заполняем Address2
        driver.findElement(By.id("address_city")).sendKeys("Minsk"); // заполняем First name
        driver.findElement(By.xpath("//option[@value='HI']")).click(); // выбираем Гавайи
        driver.findElement(By.id("address_zip_code")).sendKeys("9379992"); // заполняем зип код
        driver.findElement(By.id("address_country_us")).click(); //выбираем страну
        driver.findElement(By.id("address_birthday")).sendKeys("19021993"); // Заполнение дня рождения (Календарь)

        // Выбор цвета (Не работает по координатам, или координаты не так указал)
        driver.findElement(By.id("address_color")).click(); // кликаем по элементу Color
        actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0); // сбрасываем курсор в верхний левый угол представления веб-браузера
        actions.moveByOffset(655, 406).click().build().perform(); // кликаем по координатам x, y, указанным вручную в качестве параметра

        // Ищем координаты и размер веб-элемента
        WebElement e = driver.findElement(By.id("address_color")); // какой будет веб-элемент для поиска

        Point location = e.getLocation(); // координаты запрашиваемого веб-элемента x и y
        Dimension size = e.getSize(); // размер запрашиваемого веб-элемента

        System.out.println(location); // вывод на экран координат запрашиваемого веб-элемента
        System.out.println(size); // вывод на экран размера запрашиваемого веб-элемента
//        webElement.getLocation().getX();
//        webElement.getLocation().getY();

        driver.findElement(By.id("address_age")).sendKeys("28"); // заполняем возвраст
        driver.findElement(By.id("address_website")).sendKeys("https://www.google.com/"); // заполняем вебсайт

        // Загрузка файла
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Lenovo\\Pictures\\Скриншот.png"); // выбираем файл

        /* Не обращать внимание на этот код------
        WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        */

        driver.findElement(By.id("address_phone")).sendKeys("2020327"); // заполняем телефон
        driver.findElement(By.id("address_interest_read")).click(); // выбираем интересы
        driver.findElement(By.id("address_note")).sendKeys("Примечание"); // заполняем примечания
        driver.findElement(By.xpath("//input[@value='Create Address']")).click(); // кликаем создать адресс
        driver.findElement(By.cssSelector("a[data-test='list']")).click(); // кликаем список


        // 3. Изменение адреса
        driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a")).click();  // кликаем редактировать
                                                                        // а как можно икспас по другому написать? к чему привязаться?

        driver.findElement(By.id("address_first_name")).clear(); // очищаем строку
        driver.findElement(By.id("address_first_name")).sendKeys("First name EDIT"); // редактируем строку
        driver.findElement(By.id("address_last_name")).clear();
        driver.findElement(By.id("address_last_name")).sendKeys("Last name EDIT");
        driver.findElement(By.name("address[address1]")).clear();
        driver.findElement(By.name("address[address1]")).sendKeys("Address1 EDIT");
        driver.findElement(By.name("address[address2]")).clear();
        driver.findElement(By.name("address[address2]")).sendKeys("Address2 EDIT");
        driver.findElement(By.xpath("//option[@value='TX']")).click(); // меняем штат
        driver.findElement(By.xpath("//input[@value='Update Address']")).click(); // кликаем обновить
        driver.findElement(By.cssSelector("a[data-test='list']")).click(); // кликаем список


        // 4. Удаление адреса
        driver.findElement(By.xpath("//tbody/tr/td[7]/a")).click();  // кликаем удалить список

        driver.switchTo().alert().accept(); // соответствует нажатию кнопки OK всплывающее окно


        // 5. Выход пользователя
        driver.findElement(By.xpath("//a[@class='nav-item nav-link'][2]")).click(); // кликаем на выход пользователя

        driver.close();
        driver.quit();

    }

}