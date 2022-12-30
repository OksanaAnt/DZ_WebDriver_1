import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test1 extends BaseTestForTest1 {
    @Test
    public void headlessMode() {
    driver.manage().window().fullscreen();
    driver.get("https://duckduckgo.com/");
    clearAndEnter(By.id("search_form_input_homepage"), "ОТУС");
    driver.findElement(By.id("search_button_homepage")).submit();


//     Проверить что в поисковой выдаче первый результат Онлайн‑курсы для профессионалов, дистанционное обучен
        WebElement element = driver.findElement(By.xpath("//div[@id='links']//h2//span[contains(text(),'дистанционное')]"));
        System.out.println("Элемент отображается на странице:" + element.isDisplayed());
}
    private void clearAndEnter(By by, String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
}