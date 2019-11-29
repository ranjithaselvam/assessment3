package com.atmecs.php.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.php.base.Base;
import com.atmecs.php.config.Constant;
import com.atmecs.php.dateAndTime.DateAndTime;
import com.atmecs.php.findObject.FindObject;
import com.atmecs.php.helper.Helper;
import com.atmecs.php.helper.Waits;
import com.atmecs.php.report.Reports;

public class PhpTravels extends Base {

	public Reports report = new Reports();
	public Helper helper = new Helper();
	public Waits wait = new Waits();
	public DateAndTime dateAndTime = new DateAndTime();
	public FindObject find = new FindObject();

	@BeforeClass
	public void browserLaunch() {
		report.logInfo("Step 1 : Browser Opening");
		getBrowser(utils.propertyRead(Constant.config_file, "browserName"));
		report.logInfo("Step 2 : Enter url");
		getUrl(utils.propertyRead(Constant.config_file, "url"));
	}

	/**
	 * Entering booking details(passing user inputs)
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void BookingHotel() throws Exception {

		wait.implicitlyWait(driver);
		report.logInfo("Step 3:Click on hotel");
		helper.clickOnWebElement(driver, Constant.homePageLoc_path, "loc_hotel");
		Actions action = new Actions(driver);
		// action.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);

		report.logInfo("Step 4:Verify user is landed into Home page ");
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (currentUrl.contains("net")) {
			System.out.println("user landed successfully");
		}

		else {
			System.out.println("User not landed ");
		}

		report.logInfo("Step 5:Select Destination City as Bangalore");
		String city = utils.propertyRead(Constant.bookingData_file, "destination");
		helper.inputValuesToTheWebelement(driver, Constant.homePageLoc_path, "loc_destination", city);
		action.sendKeys(Keys.ENTER);

		report.logInfo("Step 6:Check-In Date should be greater than 10days");
		helper.clickOnWebElement(driver, Constant.homePageLoc_path, "loc_checkin");
		String checkin = utils.propertyRead(Constant.bookingData_file, "checkindays");
		String moreThanTenDays = dateAndTime.gettingDay(checkin);
		helper.inputValuesToTheWebelement(driver, Constant.homePageLoc_path, "loc_checkin", moreThanTenDays);

		report.logInfo("Step 7:Check-out Date should be +2 days of Check-In Date");
		helper.clickOnWebElement(driver, Constant.homePageLoc_path, "loc_checkout");
		String checkout = utils.propertyRead(Constant.bookingData_file, "checkoutdays");
		String plusTwoDays = dateAndTime.gettingDay(checkout);
		helper.inputValuesToTheWebelement(driver, Constant.homePageLoc_path, "loc_checkout", plusTwoDays);

		find.findObject(driver, utils.propertyRead(Constant.homePageLoc_path, "loc_adult")).click();
		report.logInfo("Step 8:Increased Passengers list  Adults : 4 ");
		find.findObject(driver, utils.propertyRead(Constant.homePageLoc_path, "loc_adult")).click();

		find.findObject(driver, utils.propertyRead(Constant.homePageLoc_path, "loc_child")).click();
		report.logInfo("Step 9:Increased Passengers list  child : 2 ");
		find.findObject(driver, utils.propertyRead(Constant.homePageLoc_path, "loc_child")).click();

		report.logInfo("Step 10:Perform Search for the Hotels");
		helper.clickOnWebElement(driver, Constant.homePageLoc_path, "loc_search");

	}

	/** verify user page redirection and validate all the data which we have entered in home page by clicking on Modify button
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void validatePageRedirection() throws Exception {
		wait.implicitlyWait(driver);

		report.logInfo("Step 11:Verify user redirected to search page or not");
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("bangalore")) {
			System.out.println("User redirected into next page");
		} else {
			System.out.println("user not able to redirect");
		}

		report.logInfo("Step 12:validate all the data which we have entered in home page by clicking on Modify button");
		helper.clickOnWebElement(driver, Constant.hotelPageLoc_file, "loc_modify");

		String actualCity = helper.getText(driver,
				utils.propertyRead(Constant.hotelPageLoc_file, "loc_modify_designation"));
		String expectedCity = utils.propertyRead(Constant.bookingData_file, "city");
		helper.pageValidation(actualCity, expectedCity);

		String actualCheckin = helper.getText(driver,
				utils.propertyRead(Constant.hotelPageLoc_file, "loc_modify_checkin"));
		String expectedCheckin = utils.propertyRead(Constant.bookingData_file, "checkin");
		helper.pageValidation(actualCheckin, expectedCheckin);

		String actualCheckout = helper.getText(driver,
				utils.propertyRead(Constant.hotelPageLoc_file, "loc_modify_checkout"));
		String expectedCheckout = utils.propertyRead(Constant.bookingData_file, "checckout");
		helper.pageValidation(actualCheckout, expectedCheckout);

		String actualAdult = helper.getText(driver, utils.propertyRead(Constant.hotelPageLoc_file, "loc_modify_adult"));
		String expectedAdult = utils.propertyRead(Constant.bookingData_file, "adult");
		helper.pageValidation(actualAdult, expectedAdult);

		String actualChild = helper.getText(driver, utils.propertyRead(Constant.hotelPageLoc_file, "loc_modify_child"));
		String expecteChild = utils.propertyRead(Constant.bookingData_file, "child");
		helper.pageValidation(actualChild, expecteChild);

	}

	/**
	 * booking hotel having 4 star with low price
	 * 
	 */

	@Test(priority = 3)
	public void identifyHotel() {

		helper.scrollToBottomOfThePage(driver, utils.propertyRead(Constant.hotelPageLoc_file, "loc_viewmore"));
		report.logInfo("Step 13 :Click on VIEW MORE button until to load all the hotels list");
		helper.clickOnWebElement(driver,Constant.hotelPageLoc_file,"loc_viewmore");

		report.logInfo("Step 14 :Identifing hotel having 4-star rating with low cost");
		List<WebElement> ratingFromWebsite = driver.findElements(By.xpath(utils.propertyRead(Constant.hotelPageLoc_file, "loc_rating")));
		for (WebElement rating : ratingFromWebsite) {
			String allRatingValues = rating.getText();
			System.out.println("Rating :" + allRatingValues);
		}

		report.logInfo("Step 15 :Identifing hotel having low price");
		List<WebElement> pricefromWebsite = driver.findElements(By.cssSelector(utils.propertyRead(Constant.hotelPageLoc_file, "loc_price")));

		List<String> addPrice = new ArrayList<String>();
		for (WebElement price : pricefromWebsite) {
			String allPriceValue = price.getText();
			System.out.println("Price :" + allPriceValue);
			addPrice.add(price.getText());
		}
		List<String> sortedPrices = new ArrayList<String>(addPrice);
		Collections.sort(sortedPrices);
		System.out.println("sorted:" + sortedPrices.equals(addPrice));

	}

	@AfterClass
	public void closeBrowser() {
		report.logInfo("Step 16 :close browser");
		driverClose();
	}

}
