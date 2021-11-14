package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StartPage {
    @FindBy(how = How.XPATH,using = "//*[@id=\"start\"]")
    public WebElement start;

}
