import Manager.PageObjectManager;
import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QTBot extends Base {
    public WebDriver wd;
    public PageObjectManager pageObjectManager;
    public static ArrayList<String> pth=new ArrayList<>();

    public QTBot(){
        this.wd=initializeDriver("Chrome");
        pageObjectManager=new PageObjectManager(wd);
        wd.get("http://54.80.137.197:5000/");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        wd.manage().window().maximize();
    }
    @Test
    public void enterTheDoor() throws InterruptedException, AWTException {
        pageObjectManager.getWelcomePage().clickToEnter.click();
        pageObjectManager.getStartPage().start.click();
        List <WebElement> r=  wd.findElements(By.xpath("//button"));
        for(WebElement ra:r){
            ra.click();
           // Thread.sleep(4000);
            if(wd.getCurrentUrl().equals("http://54.80.137.197:5000/c/a_video")){
                break;
            }
        }
        WebElement iframe=wd.findElement(By.xpath("//iframe"));
        wd.switchTo().frame(iframe);
        pageObjectManager.getVideoPage().playBtn.click();
        Thread.sleep(15000);
        pageObjectManager.getVideoPage().muteBtn.click();
        wd.switchTo().defaultContent();
        pageObjectManager.getVideoPage().proceed.click();
        int maze[][]=new int[10][10];
        boolean sflag=false;

for(int i=2;i<12;i++) {
    int j=0;

    for (WebElement m : pageObjectManager.getMaze().maze(i)) {
        if(j==0){
            if(m.getAttribute("class").contains("deep-purple")){
                sflag=true;
            }
        }

        if(j>=1&&j<11) {
            if(m.getAttribute("class").contains("blue-grey")) {
                if(sflag){
                    maze[i - 2][j - 1] = 1;
                    System.out.print(" 1 ");
                    sflag=false;
                }
                else {
                    if(j==10){
                        maze[i - 2][j - 1] = 2;
                        System.out.print(" 2 ");
                    }
                    else {
                        maze[i - 2][j - 1] = 3;
                        System.out.print(" 3 ");
                    }
                }
            }
            else
            {
                maze[i-2][j-1]=0;
                System.out.print(" 0 ");
            }
        }
        j++;

    }
    System.out.println("");
}
       isPath(maze, 10);
        for(int i=pth.size()-1;i>0;i--){
            System.out.println(pth.get(i));
        }
        pageObjectManager.getMaze().right().click();
        for(int i=pth.size()-1;i>0;i--){

            if(pth.get(i).equals("up")){
                pageObjectManager.getMaze().up().click();
            }
            else if(pth.get(i).equals("down"))
            {
                pageObjectManager.getMaze().down().click();
            }
            else if(pth.get(i).equals("right")){
                pageObjectManager.getMaze().right().click();
            }
            else if(pth.get(i).equals("left")){
                pageObjectManager.getMaze().left().click();
            }
        }
        pageObjectManager.getMaze().right().click();
        pageObjectManager.getMaze().right().click();
        pageObjectManager.getMaze().submit().click();
        Thread.sleep(3000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_I);
        for(int i=0;i<37;i++) {
            robot.keyPress(KeyEvent.VK_RIGHT);
            Thread.sleep(300);
        }
        for(int i=0;i<11;i++){
            robot.keyPress(KeyEvent.VK_UP);
            Thread.sleep(300);
        }
        pageObjectManager.getMap().proceed.click();


    }
    public static void isPath(
            int matrix[][], int n)
    {
        boolean visited[][]
                = new boolean[n][n];

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visited[i][j])
                    if (isPath(matrix, i, j, visited)) {
                        flag = true;
                        break;
                    }
            }
        }
        if (flag)
            System.out.println(" path is available");
        else
            System.out.println("path is not available");
    }
    public static boolean isSafe(int i, int j,int matrix[][])
    {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            return true;
        }
        return false;
    }
    public static boolean isPath(int matrix[][], int i, int j,boolean visited[][])
    {
        if (isSafe(i, j, matrix)&& matrix[i][j] != 0 && !visited[i][j]) {
            visited[i][j] = true;
            if (matrix[i][j] == 2) {
                return true;
            }
            boolean up = isPath(matrix, i - 1, j, visited);

            if (up) {
                pth.add("up");
                return true;
            }

            boolean left = isPath(matrix, i, j - 1, visited);
            if (left){
                pth.add("left");
                return true;}
            boolean down = isPath(matrix, i + 1, j, visited);
            if (down)
            {
                pth.add("down");
                return true;}
            boolean right = isPath(matrix, i, j + 1, visited);
            if (right){
                pth.add("right");
                return true;}
        }
        return false;
    }
}
