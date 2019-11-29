package com.atmecs.php.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.php.config.Constant;
/**
 * Purpose:To avoid unable to locate the element.
 * 
 * @author ranjitha.selvam
 *
 */
public class Waits {
	public Wait<WebDriver> wait;
	public WebDriverWait webDriverWait;

	/**
	 * To wait for certain conditions (Expected Conditions) or the maximum time
	 * exceeded before throwing an "ElementNotVisibleException" exception.
	 * 
	 */

	public void waitForElementVisibility(WebDriver driver, WebElement element) {

		try {
			webDriverWait = new WebDriverWait(driver, Constant.element_wait);
			webDriverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Web driver will wait for that time before throwing an exception.(all web
	 * element)
	 * 
	 */
	public void implicitlyWait(WebDriver driver) {
		try {
			Timeouts timeouts = driver.manage().timeouts();
			timeouts.implicitlyWait(Constant.element_wait, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Ignore specific types of exception waiting such as NoSuchElementExceptions
	 * while searching for an element on the page.
	 * 
	 * @param driver
	 */

	@SuppressWarnings("deprecation")
	public void fluentWait(WebDriver driver) {

		try {
			wait = new FluentWait<WebDriver>(driver).withTimeout(Constant.element_wait, TimeUnit.SECONDS)
					.pollingEvery(Constant.polling_wait, TimeUnit.SECONDS).ignoring(Exception.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * Set the amount of time to wait for a page load to complete before throwing an
	 * error.
	 * 
	 * @param driver
	 */

	public static void pageLoadTimeOut(WebDriver driver) {
		try {
			driver.manage().timeouts().pageLoadTimeout(Constant.element_wait, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

