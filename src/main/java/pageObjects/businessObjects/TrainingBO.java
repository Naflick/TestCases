package pageObjects.businessObjects;

import org.junit.Assert;
import pageObjects.TrainingPage;

public class TrainingBO {
    private TrainingPage trainingPage;
    public TrainingBO(){
        trainingPage = new TrainingPage();
    }
    public TrainingPage clickSkillsDropDownButtom(){
        trainingPage.clickSkillsDropDownButtom();
        return new TrainingPage();
    }
    public void verefySkillsDropDownResult(String textInput){
        trainingPage
                .clearSkillsDropDownInput()
                .skillsDropDownInput(textInput);
        Assert.assertFalse(" ",trainingPage.skillsDropDownCheckResult(textInput));

    }
    public void verefySkillsDropDownVoidResult(String textInput){
        trainingPage
                .clearSkillsDropDownInput()
                .skillsDropDownInput(textInput);
        Assert.assertFalse(" ",trainingPage.skillsDropDownCheckVoidResult());
    }
    public TrainingPage clickLocationDropDownButtom(){
        trainingPage.clickLocationDropDownButtom();
        return new TrainingPage();
    }
    public void verefyLocationDropDownResult(String textInput, String supportTextInput){
        trainingPage
                .clearlocationDropDownInput()
                .locationDropDownInput(textInput);
        Assert.assertFalse(" ",trainingPage.locationDropDownCheckResult(textInput)||trainingPage.locationDropDownCheckResult(supportTextInput));

    }
    public void verefyLocationDropDownVoidResult(String textInput){
        trainingPage
                .clearlocationDropDownInput()
                .locationDropDownInput(textInput);
        Assert.assertFalse(" ",trainingPage.locationDropDownCheckVoidResult());
    }
}
