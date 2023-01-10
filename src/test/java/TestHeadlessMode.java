import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestHeadlessMode {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }
    @Test
    public void headlessMode() {
        driver.manage().window().fullscreen();
        driver.get("https://duckduckgo.com/");
        clearAndEnter(By.id("search_form_input_homepage"), "ОТУС");
        driver.findElement(By.id("search_button_homepage")).submit();


//     Проверить что в поисковой выдаче первый результат Онлайн‑курсы для профессионалов
        WebElement element = driver.findElement(By.xpath("//div[@id='links']//a[@href='https://otus.ru/']/span[contains(text(),'для профессионалов')][1]"));
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