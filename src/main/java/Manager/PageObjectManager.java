package Manager;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
    public static WebDriver wd;
    private StartPage startPage;
    private WelcomePage welcomePage;
    private RandomAccess randomAccess;
    private VideoPage videoPage;
    private Maze maze;
    private Map map;
    public StartPage getStartPage(){
        return (startPage==null)?startPage= PageFactory.initElements(wd,StartPage.class):startPage;
    }
    public WelcomePage getWelcomePage(){
        return (welcomePage==null)?welcomePage=PageFactory.initElements(wd,WelcomePage.class):welcomePage;
    }
    public RandomAccess getRandomAccess(){
        return (randomAccess==null)?randomAccess=new RandomAccess(wd):randomAccess;
    }
    public VideoPage getVideoPage(){
        return (videoPage==null)?videoPage=PageFactory.initElements(wd,VideoPage.class):videoPage;
    }
public PageObjectManager(WebDriver wd){
        this.wd=wd;

}
public Maze getMaze(){
        return (maze==null)?maze=new Maze(wd):maze;
}
public Map getMap(){
        return (map==null)?PageFactory.initElements(wd,Map.class):map;
}


}
