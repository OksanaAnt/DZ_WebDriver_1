import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestHeadlessMode {
    WebDriver driver;

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void headlessMode() {
        driver.manage().window().fullscreen();
        driver.get("https://duckduckgo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_form_input_homepage")));
        clearAndEnter(By.id("search_form_input_homepage"), "ОТУС");
        driver.findElement(By.id("search_button_homepage")).submit();

//     Проверить что в поисковой выдаче первый результат Онлайн‑курсы для профессионалов
        WebElement element = driver.findElement(By.xpath("//div[@id='links']//a[@href='https://otus.ru/']/span[contains(text(),'курсы для профессионалов')][position()=1]"));
        System.out.println("Элемент отображается на странице:" + element.isDisplayed());
    }

    private void clearAndEnter(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    @AfterEach
    public void close() {
        if (driver != null)
            driver.quit();
    }
}