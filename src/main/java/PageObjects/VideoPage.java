package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VideoPage {
    @FindBy(how = How.XPATH,using = "//*[@id=\"movie_player\"]/div[4]/button")
    public WebElement playBtn;
    @FindBy(how = How.XPATH,using = "//*[@id=\"movie_player\"]/div[25]/div[2]/div[1]/span/button")
    public WebElement muteBtn;
    @FindBy(how = How.XPATH,using = "//*[@id=\"aVideoSubmit\"]")
    public WebElement proceed;
}
