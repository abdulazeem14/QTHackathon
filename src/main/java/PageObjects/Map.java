package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Map {
    @FindBy(how= How.XPATH,using="//*[@id=\"mapsChallengeSubmit\"]")
    public WebElement proceed;
}
