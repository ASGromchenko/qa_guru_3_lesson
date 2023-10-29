import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public abstract class Config {

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-win64-118.0.5993.70.exe");
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000;

    }
}
