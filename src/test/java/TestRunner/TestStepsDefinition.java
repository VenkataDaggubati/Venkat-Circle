package TestRunner;

import Resources.Base;
import Resources.PageObjectElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class TestStepsDefinition extends Base {

    PageObjectElements uimap = new PageObjectElements();

    @Given("I am a patient wanting a {string}")
    public void setSearchTreatment(String searchTreatment) {
        try {
            System.out.println("----------------------------------------------------");
            System.out.println("Step 1: Launching the Browser");
            driver = browserInitialization();
            System.out.println("Step 2: Accepting the Cookies");
            driver.findElement(uimap.AcceptCookies).click();
            System.out.println("Step 3: Clicking on Book a Appointment Button");
            driver.findElement(uimap.BookAppointmentButton).click();
            System.out.println("Step 4: Searching for the Treatment: " + searchTreatment);
            driver.findElement(uimap.TreatmentInputTextBox).sendKeys(searchTreatment);
            Thread.sleep(2000);
            driver.findElement(uimap.TreatmentInputTextBox).sendKeys(Keys.ENTER);
            driver.findElement(uimap.TreatmentSuggestion).click();

        }
        catch (Exception e) {
            System.out.println("Failed with exception: " + e);
        }

    }

    @When("I put in my location {string} and date of leave {string}")
    public void setLocationAndDate(String location, String date) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            System.out.println("Step 5: Entering the Location: " + location);
            driver.findElement(uimap.LocationInputTextBox).sendKeys(location);
            driver.findElement(uimap.LocationInputTextBox).click();
            Thread.sleep(2000);
            driver.findElement(uimap.LocationInputTextBox).sendKeys(Keys.ARROW_DOWN);
            driver.findElement(uimap.LocationInputTextBox).sendKeys(Keys.ENTER);
            System.out.println("Step 6: Clicking on Search Button");
            webDriverWait.until(ExpectedConditions.elementToBeClickable(uimap.SearchButton));
            driver.findElement(uimap.SearchButton).click();
            Thread.sleep(5000);
            System.out.println("Step 7: Select the Date: " + date);
            driver.findElement(By.xpath("(//span[@aria-label='"+date+"'])[1]")).click();
        }
        catch (Exception e) {
            System.out.println("Failed with exception: " + e);
        }
    }
    @Then("I can get a consultants availability and location provided to make my decision")
    public void getConsultantDetails() {
        try {
            Thread.sleep(5000);
            Assert.assertEquals("There are No Results",true, driver.findElement(uimap.ConsultantResultCard).isDisplayed());

            System.out.println("The Consultant results are as following: ");

            List<WebElement> ConsultantNameElement = driver.findElements(uimap.ConsultantName);
            List<WebElement> ConsultantTitleElement = driver.findElements(uimap.ConsultantTitle);
            List<WebElement> ConsultantFeeElement = driver.findElements(uimap.ConsultantFee);
            List<WebElement> ConsultantAddressElement = driver.findElements(uimap.ConsultantAddress);


            for(int i =0; i<ConsultantNameElement.size(); i++)
            {
                System.out.println(i+1 + ". " + ConsultantNameElement.get(i).getText());
                System.out.println("Title: " + ConsultantTitleElement.get(i).getText());
                System.out.println("Fees: " + ConsultantFeeElement.get(i).getText());
                System.out.println("Distance from your location and Address: " + ConsultantAddressElement.get(i).getText());
                System.out.println("----------------------------------------------------------------------------------------");;
            }

            driver.close();
        }
        catch (Exception e) {
            System.out.println("Failed with exception: " + e);
        }
    }

}
