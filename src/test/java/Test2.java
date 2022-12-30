import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Test2 extends BaseTest {

    @Test
    public void getPicture() {
//        Открыть в режиме "киоск"
        driver.manage().window().fullscreen();
//        Открыть сайт
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
//        Находим элемент на странице
        WebElement element = driver.findElement(By.xpath("//img[1]"));
//        Элемент имеет постоянное наложение, используем JavascriptExecutor для щелчка на сам элемент
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        System.out.println("Элемент отображается на странице:" + element.isDisplayed());
    }
}

