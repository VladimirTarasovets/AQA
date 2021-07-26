package task16_FrameworkJUnit.locators;

import org.openqa.selenium.By;

import java.io.File;

public class Locators {

    public static final By FIRST_NAME = By.id("address_first_name");
    public static final By LAST_NAME = By.id("address_last_name");
    public static final By ADDRESS1 = By.name("address[address1]");
    public static final By ADDRESS2 = By.name("address[address2]");
    public static final String PICTURE = new File("src/main/resources/IMG.jpg").getAbsolutePath();


}
