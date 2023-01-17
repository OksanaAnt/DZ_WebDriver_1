import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPicture {
    WebDriver driver;
    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void getPicture() {
//        Открыть в режиме "киоск"
        driver.manage().window().maximize();
//        Открыть сайт
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
//        Находим элемент на странице
        WebElement element = driver.findElement(By.xpath("//img[1]"));
//        Элемент имеет постоянное наложение, используем JavascriptExecutor для щелчка на сам элемент
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        System.out.println("Элемент отображается на странице:" + element.isDisplayed());
    }
    @AfterEach
    public void close() {
        if (driver != null)
            driver.quit();
    }
}

