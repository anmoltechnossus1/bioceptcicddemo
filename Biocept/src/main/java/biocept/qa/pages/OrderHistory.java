package biocept.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class OrderHistory extends BioceptBase{
	
	@FindBy(tagName="h3")
	WebElement title;
	
	@FindBy(css="input[aria-controls='dataTable']")
	WebElement searchElement;
	
	@FindBy(css="button[onclick*='RedirectUser']")
	WebElement techOnlyProfessionalInterpretationEle ;
	
	
	
	
	public OrderHistory(){
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle(){
		return title.getText();
	}
	
	public void search (String AccessionID){
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dataTable_processing")));
		ExplicitWait.waitUntilElementToBeVisible(searchElement).sendKeys(AccessionID);
		
	}
	
	public boolean techOnlyProfessionalInterpretationButton(){
		return techOnlyProfessionalInterpretationEle.isDisplayed();
	}
	
	public void clickOnTechOnlyProfessionalInterpretationButton(){
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dataTable_processing")));
		ExplicitWait.waitUntilElementToBeVisible(techOnlyProfessionalInterpretationEle).click();
		
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    ExplicitWait.invisibilityOfLoader();
	}
	
	
	
}
