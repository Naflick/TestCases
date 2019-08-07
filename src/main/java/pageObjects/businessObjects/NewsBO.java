package pageObjects.businessObjects;

import org.junit.Assert;
import pageObjects.NewsPage;

public class NewsBO {
     private NewsPage newsPage;

     public NewsBO(){
         newsPage = new NewsPage();
     }
     public void verefiNewsButtomIsDisplay(){
         Assert.assertTrue("",newsPage.checkNewsButoomIsDisplay());
     }
    public void verefiSuccessStoriesButtomIsDisplay(){
        Assert.assertTrue("",newsPage.checkSuccessStoriesButoomIsDisplay());
    }
    public void verefiMaterialssButtomIsDisplay(){
        Assert.assertTrue("",newsPage.checkMaterialsButoomIsDisplay());
    }
    public void verefiVideosButtomIsDisplay(){
        Assert.assertTrue("",newsPage.checkVideosButoomIsDisplay());
    }
}
