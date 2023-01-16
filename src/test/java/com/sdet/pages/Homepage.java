package com.sdet.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class Homepage {

	WebDriver wd = null;
	public Homepage(WebDriver driver) {
		this.wd = driver;
		PageFactory.initElements(wd, this);
	}


	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement txtSearchBox;
	
	@FindBy(xpath = "//div[@class='a-section aok-relative s-image-square-aspect']/img")
	List<WebElement> lnkAllPens;
	
	@FindBy(xpath = "//span[@id='a-autoid-0-announce']")
	WebElement lnkSortBy;
	
	
	@FindBy(xpath = "//a[@id='s-result-sort-select_1']")
	WebElement lnkPriceSelection;

	@FindBy(xpath = "//span[contains(text(),'BL77BP2A')]")
	WebElement lnkAddPen;
	
	@FindBy(xpath = "//span[@id='a-autoid-0-announce']")
	WebElement Qty;
	@FindBy(xpath = "//a[@id='quantity_1']")
	WebElement selectQty;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCart;
	
	@FindBy(xpath = "//*[@id='attach-sidesheet-view-cart-button']/span/input")
	WebElement lnkCart;
	
	@FindBy(xpath = "//input[@value='Delete']")
	WebElement lnkDelete;
	
	@FindBy(xpath = "//span[contains(text(),'was removed from Shopping Cart')]")
	WebElement lblConfirmMessage;
	
	
	public void searchAndAddGelPen(String item) throws InterruptedException {
		// Search Text
		txtSearchBox.sendKeys(item + Keys.ENTER);
		Thread.sleep(3000);
		
		// Verify all items text
		Assert.assertTrue(searchGelPenText());
		
		// Sort low to high
		lnkSortBy.click();
		Thread.sleep(1000);
		lnkPriceSelection.click();
		Thread.sleep(1000);
		
		//Select pen
		lnkAddPen.click();
		Thread.sleep(1000);
		
		//Select Quantity
		Qty.click();
		Thread.sleep(1000);
		selectQty.click();
		
		//Add to cart
		addToCart.click();
		Thread.sleep(1000);
		
	}
	
	public boolean searchGelPenText() {
		boolean flag = false;
		for (WebElement item1 : lnkAllPens) {
			if (item1.getAttribute("alt").toLowerCase().contains("pen")) {
				flag = true;
			}
		}
		return flag;
	}
	
	public void verifyCart() throws InterruptedException {
		
		lnkCart.click();
		Thread.sleep(1000);
		lnkDelete.click();
		Thread.sleep(1000);
		Assert.assertTrue(lblConfirmMessage.isDisplayed());
	}
}
