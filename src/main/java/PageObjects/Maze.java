package PageObjects;

import org.apache.hc.core5.http2.hpack.HPackDecoder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Maze {

    public WebDriver wd;
    public List<WebElement> maze(int i) {
        By maze = By.xpath("//*[@id=\"maze\"]/tr["+i+"]/td");
        return wd.findElements(maze);
    }
    public WebElement up(){
        By up=By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div[2]/div/a");
        return wd.findElement(up);
    }
    public WebElement down(){
        By down=By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div[3]/div/a[2]");
        return wd.findElement(down);
    }
    public WebElement right(){
        By right=By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div[3]/div/a[3]");
        return wd.findElement(right);
    }
    public WebElement left(){
        By left=By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div[3]/div/a[1]");
        return wd.findElement(left);
    }
    public WebElement submit(){
        By submit=By.xpath("//*[@id=\"crystalMazeFormSubmit\"]");
        return wd.findElement(submit);
    }
    public Maze(WebDriver wd){
        this.wd=wd;
    }
}
