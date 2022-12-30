import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Test3 extends BaseTest {

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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clearAndEnter(By.xpath("//*[@class='new-log-reg__form js-login']/descendant::*[@placeholder='Электронная почта']"), login);
        clearAndEnter(By.xpath("//*[@class='new-log-reg__form js-login']/descendant::*[@placeholder='Введите пароль']"), pas);
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).submit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clearAndEnter(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

}
