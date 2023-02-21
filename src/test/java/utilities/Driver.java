package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    driver classından driver ı getdriver() ile kullanıyoruz
    sonradan projeye katılan insanların Driver class ından obje oluşturarak
    driver kullanmaya calısmalarını engellemek isin driver calss ını
    SINGLETON PATERN ile düzenleyebiliriz.
  bunun icin driver classının parametresiz constructor ını olusturup access modifier ının PRİVATE yapmamız yeterli olur.

    private Driver (){} yaparız
     */

    private Driver(){

    }
    static WebDriver driver ;

    public static WebDriver getDriver (){

        String browser=ConfigReader.getProperty("browser");

        if(driver==null) {

            switch (browser) {

                case "chrome":

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }

        return driver;
    }
    public static void closeDriver () {

        if (driver != null) {

            driver.close();
            driver = null;
        }
    }
    public static void quitDriver () {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}