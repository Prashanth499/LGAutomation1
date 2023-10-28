    package testbase;

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;

    import utils.TestUtils;

    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.time.Duration;
    import java.util.Properties;

    public class WebTestBase {
        public static WebDriver driver;
        public static Properties prop;

        public WebTestBase() {
            try {
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
                prop = new Properties();
                prop.load(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }  catch (IOException ignored) {
            }
        }

        public static void initialization() {
                String browserName = prop.getProperty("browser");
                if (browserName.equalsIgnoreCase("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
                    driver = new ChromeDriver(options);

                }

            driver.navigate().to(prop.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.PAGE_LOAD_WAIT));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
            driver.manage().deleteAllCookies();
        }
    }






