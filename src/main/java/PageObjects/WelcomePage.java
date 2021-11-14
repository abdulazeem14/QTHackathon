package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div/div/a[2]")
    public WebElement clickToEnter;
}
