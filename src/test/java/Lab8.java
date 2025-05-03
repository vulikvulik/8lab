import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Lab8 {
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/geckodriver.exe");
        FirefoxDriver options = new FirefoxDriver();
        driver = new FirefoxDriver();

        driver.get("https://playground.learnqa.ru/puzzle/triangle&quot");
    }
    @org.junit.jupiter.api.Test
    public void testTriangle(){
        //1: Убеждаемся, что кнопка "Я сдаюсь" есть на странице
        WebElement surrenderButton = driver.findElement(By.xpath("//button[text()='Я сдаюсь']"));
        assertNotNull(surrenderButton, "Кнопка 'Я сдаюсь' не найдена на странице");

        //2: Кликнуть по кнопке с текстом “Я сдаюсь”
        surrenderButton.click();

        //3: Проверяем, что на странице появились элементы: а)ссылка с текстом “Ссылка на ответы”,
        WebElement answerLink = driver.findElement(By.xpath("//a[text()='Ссылка на ответы']"));
        assertNotNull(answerLink, "Ссылка с текстом 'Ссылка на ответы' не найдена на странице");

        //4: Проверяем, что на странице появились элементы: б) кнопка с текстом “Спрятать ответы”.
        WebElement hideButton = driver.findElement(By.xpath("//button[text()='Спрятать ответы']"));
        assertNotNull(hideButton, "Кнопка 'Спрятать ответы' не найдена на странице");
    }

    @AfterEach
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}

