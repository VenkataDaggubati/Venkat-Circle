package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;
    public String browserName;
    public String url;


    public WebDriver browserInitialization() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/Resources/Data.properties");
        prop.load(fis);
        browserName = prop.getProperty("browser");
        url = prop.getProperty("url");

        if(browserName.equals("chrome"))
        {   String webDriver = ("webdriver.chrome.driver");
            String exePath = ("src/test/java/Resources/chromedriver.exe");
            System.setProperty(webDriver,exePath);
            //WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if(browserName.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;

    }
}
