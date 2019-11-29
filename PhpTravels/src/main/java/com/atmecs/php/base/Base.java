package com.atmecs.php.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.atmecs.php.config.Constant;
import com.atmecs.php.utils.Utils;
/**
 * Different browser setup to run the script in different  browser.
 * 
 * @author ranjitha.selvam
 *
 */

public class Base {
	    public WebDriver driver;
		public Utils utils = new Utils();
		
        /**
		 * Different browser setup(Chrome,Firefox,Internetexplorer)
		 * 
		 */

		public void getBrowser(String browserType) {
			try {

				if (browserType.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", Constant.chrome_file);
					driver = new ChromeDriver();
				} else if (browserType.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", Constant.fireFox_file);
					driver = new FirefoxDriver();
				} else if (browserType.equalsIgnoreCase("internetExplorer")) {
					System.setProperty("webdriver.ie.driver", Constant.internetExplorer_file);
					driver = new InternetExplorerDriver();
				}

				driver.manage().window().maximize();
			} catch (Exception e)

			{
				e.printStackTrace();
			}
		}

		/**
		 * Get url from property file.
		 * 
		 */
		public void getUrl(String url)
		{
			try {
				driver.get(url);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		/**
		 * Close the current browse
		 * 
		 */
		public void driverClose() {
			try {
				driver.close();

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}





