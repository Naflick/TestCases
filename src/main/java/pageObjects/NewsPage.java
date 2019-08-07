package pageObjects;

import org.openqa.selenium.By;

public class NewsPage extends AbstractPage {

    private By newsButtom = By.xpath("//*[contains(@class,'tab-nav__list separated-list')]//span[contains(text(),'News')]");
    private By successStoriesButoom = By.xpath("//*[contains(@class,'tab-nav__list separated-list')]//span[contains(text(),'Success Stories')]");
    private By materialsButoom = By.xpath("//*[contains(@class,'tab-nav__list separated-list')]//span[contains(text(),'Materials')]");
    private By videosButoom = By.xpath("//*[contains(@class,'tab-nav__list separated-list')]//span[contains(text(),'Videos')]");

    public boolean checkNewsButoomIsDisplay(){
        return AbstractPage.getElement(newsButtom).isDisplayed();
    }
    public boolean checkSuccessStoriesButoomIsDisplay(){
        return AbstractPage.getElement(successStoriesButoom).isDisplayed();
    }
    public boolean checkMaterialsButoomIsDisplay(){
        return AbstractPage.getElement(materialsButoom).isDisplayed();
    }
    public boolean checkVideosButoomIsDisplay(){
        return AbstractPage.getElement(videosButoom).isDisplayed();
    }
}
