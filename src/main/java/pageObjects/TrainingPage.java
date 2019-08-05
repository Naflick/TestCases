package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TrainingPage extends AbstractPage {

    public TrainingPage clickSkillsDropDownButtom(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Skills')]/..//*[contains(@ng-click,'openSkillsDropDown')]"))).click();
        return this;
    }
    public TrainingPage skillsDropDownInput(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down drop-down-skills drop-down-visibility')]/input"))).sendKeys(text);
        return this;
    }
    public boolean skillsDropDownCheckResult(String text){
        boolean check = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down-skills')]//*[contains(@class,'drop-down__input-search__list')]//label[contains(text(),'')]"))).getText().contains(text);
        return check;
    }
    public TrainingPage clearSkillsDropDownInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down drop-down-skills drop-down-visibility')]/input"))).clear();
        return this;
    }
    public boolean skillsDropDownCheckVoidResult(){
        List<WebElement> list = DriverFactory.getDriver().findElements(By.xpath("//*[contains(@class,'drop-down-skills')]//*[contains(@class,'drop-down__input-search__list')]"));
        boolean check = false;
        if (list.size() == 0){
            check =true;
        }
        return check;
    }
}
