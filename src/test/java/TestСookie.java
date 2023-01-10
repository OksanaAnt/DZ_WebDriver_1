import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class TestСookie {
    WebDriver driver;
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        clearAndEnter(By.xpath("//div[@class='modal-container new-log-reg-container']//input[@placeholder='Электронная почта']"), login);
        clearAndEnter(By.xpath("//div[@class='modal-container new-log-reg-container']//input[@placeholder='Введите пароль']"), pas);
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
