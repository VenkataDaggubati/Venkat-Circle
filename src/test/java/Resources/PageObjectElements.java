package Resources;

import org.openqa.selenium.By;

public class PageObjectElements {

    public By AcceptCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    public By BookAppointmentButton = By.xpath("//a[@class='f-btn f-btn-tertiary f-btn--no-shadow']");
    public By TreatmentInputTextBox = By.xpath("//input[@id='treatment']");
    public By TreatmentSuggestion = By.xpath("//a[contains(text(),'Knee replacement surgery')]");
    public By LocationInputTextBox = By.xpath("//input[@id='location']");
    public By SearchButton = By.xpath("//button[normalize-space()='Search']");
    public By ConsultantResultCard = By.xpath("//div[@class='consultant-result-card__details']");

    public By ConsultantName = By.xpath("//h3[@class='consultant-result-card__name']");
    public By ConsultantTitle = By.xpath("//p[@class='consultant-result-card__title']");
    public By ConsultantFee = By.xpath("//p[@class='consultant-result-card__fee']");
    public  By ConsultantAddress = By.xpath("//li[@class='consultant-result-card__hospital-item']");

}
