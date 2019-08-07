package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TrainingPage extends AbstractPage {

    private By skillsDropDownButtom = By.xpath("//*[contains(text(),'Skills')]/..//*[contains(@ng-click,'openSkillsDropDown')]");
    private By skillsDropDownInput = By.xpath("//*[contains(@class,'drop-down drop-down-skills drop-down-visibility')]/input");
    private By skillsDropDownCheckResult = By.xpath("//*[contains(@class,'drop-down-skills')]//*[contains(@class,'drop-down__input-search__list')]//label[contains(text(),'')]");
    private By clearSkillsDropDownInput = By.xpath("//*[contains(@class,'drop-down drop-down-skills drop-down-visibility')]/input");
    private By skillsDropDownCheckVoidResult = By.xpath("//*[contains(@class,'drop-down-skills')]//*[contains(@class,'drop-down__input-search__list')]");
    private By locationDropDownButtom = By.xpath("//*[contains(text(),'Locations')]/..//*[contains(@ng-click,'openLocationsDropDown')]");
    private By locationDropDownInput = By.xpath("//*[contains(@class,'drop-down drop-down-locations drop-down-visibility')]/input");
    private By locationDropDownCheckResult = By.xpath("//*[contains(@class,'drop-down-locations')]//*[contains(@class,'drop-down__input-search__list')]//label[contains(text(),'')]");
    private By clearlocationDropDownInput = By.xpath("//*[contains(@class,'drop-down drop-down-locations drop-down-visibility')]/input");
    private By locationDropDownCheckVoidResult = By.xpath("//*[contains(@class,'drop-down-locations')]//*[contains(@class,'drop-down__input-search__list')]");


    public TrainingPage clickSkillsDropDownButtom(){
        AbstractPage.getElement(skillsDropDownButtom).click();
        return this;
    }
    public TrainingPage skillsDropDownInput(String text){
        AbstractPage.getElement(skillsDropDownInput).sendKeys(text);
        return this;
    }
    public boolean skillsDropDownCheckResult(String text){
        return AbstractPage.getElement(skillsDropDownCheckResult).getText().contains(text);
    }
    public TrainingPage clearSkillsDropDownInput(){
        AbstractPage.getElement(clearSkillsDropDownInput).clear();
        return this;
    }
    public boolean skillsDropDownCheckVoidResult(){
        List<WebElement> list = DriverFactory.getDriver().findElements(skillsDropDownCheckVoidResult);
        boolean check = false;
        if (list.size() == 0){
            check =true;
        }
        return check;
    }
    public TrainingPage clickLocationDropDownButtom(){
        AbstractPage.getElement(locationDropDownButtom).click();
        return this;
    }
    public TrainingPage locationDropDownInput(String text){
        AbstractPage.getElement(locationDropDownInput).sendKeys(text);
        return this;
    }
    public boolean locationDropDownCheckResult(String text){
        return AbstractPage.getElement(locationDropDownCheckResult).getText().contains(text);
    }
    public TrainingPage clearlocationDropDownInput(){
        AbstractPage.getElement(clearlocationDropDownInput).clear();
        return this;
    }
    public boolean locationDropDownCheckVoidResult(){
        List<WebElement> list = DriverFactory.getDriver().findElements(locationDropDownCheckVoidResult);
        boolean check = false;
        if (list.size() == 0){
            check =true;
        }
        return check;
    }
}
