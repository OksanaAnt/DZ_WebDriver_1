import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestСookie {
    WebDriver driver;

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    private String login = "degap85327@paxven.com";
    private String pas = "Jrcfyf!1";

    @Test
    public void cookieTest() {
//        Открыть в полноэкранном режиме
        driver.manage().window().maximize();
//        Открыть https://otus.ru
        driver.get("https://otus.ru");
//        Авторизоваться на сайте
        loginInOtus();
//        Получить все cookies
        System.out.println(driver.manage().getCookies());
    }

    private void loginInOtus() {

        driver.findElement(By.cssSelector(".header3__button-sign-in")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-container new-log-reg-container']//input[@placeholder='Электронная почта']")));

        clearAndEnter(By.cssSelector("div[class='new-log-reg__body'] input[name='email']"), login);
        clearAndEnter(By.cssSelector("div[class='new-log-reg__body'] input[name='password'"), pas);
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).submit();
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
