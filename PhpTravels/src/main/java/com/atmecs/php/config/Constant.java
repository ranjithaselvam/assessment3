package com.atmecs.php.config;
/**
 * Purpose :To maintain all path as constant for reusable
 * 
 * @author ranjitha.selvam
 *
 */

public class Constant {
	

		/**
		 * find element specified time
		 * 
		 */
		public  final static long element_wait = 30;
		public  final static long polling_wait = 5;

		/**
		 * different browser drivers path
		 * 
		 */
		public static final String chrome_file = "./drivers/chromedriver.exe";
		public static final String fireFox_file = "./drivers/geckodriver.exe";
		public static final String internetExplorer_file = "./drivers/IEDriverServer.exe";
		public static final String config_file = "./config.properties";
		public static final String log4j_file = "./log4j.properties";


		//php travels locators
		public static final String homePageLoc_path="./src/test/resources/pageobject/homepage.properties";
		public static final String hotelPageLoc_file="./src/test/resources/pageobject/hotelpage.properties";
		
		
		
		//php travels data
		public static final String bookingData_file="./src/test/resources/testdata/bookingdetails.properties";
		public static final String HotelData_file="./src/test/resources/testdata/identifyhotels.xlsx";
	}



