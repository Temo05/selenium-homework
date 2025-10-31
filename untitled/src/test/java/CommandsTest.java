import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CommandsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        browser.get("http://the-internet.herokuapp.com/dynamic_controls");
        Thread.sleep(1000);

        WebElement enableBtn = browser.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enableBtn.click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        WebElement textBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-example\"]/input")));
        Thread.sleep(700);

        WebElement msgBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Thread.sleep(700);

        if (textBox.isEnabled() && msgBox.getText().equals("It's enabled!")) {
            System.out.println("შეყვანის ველი გააქტიურდა და ტექსტი ჩანს");
        }

        wait.until(ExpectedConditions.textToBePresentInElement(enableBtn, "Disable"));
        System.out.println("ღილაკის ტექსტი წარმატებით შეიცვალა");
        Thread.sleep(800);

        textBox.sendKeys("bootcamp");
        Thread.sleep(600);

        textBox.clear();
        Thread.sleep(600);

        browser.get("http://the-internet.herokuapp.com/drag_and_drop");
        Thread.sleep(1000);

        WebElement boxA = browser.findElement(By.id("column-a"));
        WebElement boxB = browser.findElement(By.id("column-b"));

        int posA = boxA.getLocation().getY();
        int posB = boxB.getLocation().getY();

        if (posA == posB) {
            System.out.println("სვეტები A და B წარმატებით არიან გასწორებული");
        } else {
            System.out.println("❌ სვეტები არასწორად დგას");
        }

        Thread.sleep(800);
        browser.quit();
    }
}
