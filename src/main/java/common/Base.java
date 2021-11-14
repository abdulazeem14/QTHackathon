package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
    public static WebDriver objWD;

    public static WebDriver initializeDriver(String browsername){

        if (browsername.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            objWD = new ChromeDriver();

        } else if (browsername.equals("firefox")) {
            objWD = new FirefoxDriver();
        } else if (browsername.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            objWD = new EdgeDriver();
        } else {
            objWD = new InternetExplorerDriver();
        }
        return objWD;
    }
}
