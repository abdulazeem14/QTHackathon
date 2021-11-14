package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RandomAccess {
    public static WebDriver wd;
    public RandomAccess(WebDriver wd){
        this.wd=wd;
    }
    public WebElement randomAccess(int i) {
        By ra = By.xpath("//*[@id=\"c1submitbutton"+i+"\"]");
        return wd.findElement(ra);
    }
}
