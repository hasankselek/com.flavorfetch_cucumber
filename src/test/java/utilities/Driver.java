package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    // Driver class'i WebDriver objesini olusturacagimiz
    // ve gerekli ayarlari yapacagimiz class olucak

    // HEDEF :
    // configuration.properties'den hangi browser secilirse
    // bize o browseri uretecek bir class olusturmak

    // Driver class'inda bize driver objesi dondurucek
    // getDriver() methodu olusturacagiz

    private Driver(){

    }

    public static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver == null){
            String istenenBrowser = ConfigReader.getProperty("browser"); // firefox

            switch (istenenBrowser){
                case "firefox" : driver = new FirefoxDriver();break;
                case "edge" : driver = new EdgeDriver();break;
                case "safari" : driver = new SafariDriver();break;
                default: driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        return driver;

    }

    public static void quitDriver(){

        driver.quit();
        driver=null;

    }

}
