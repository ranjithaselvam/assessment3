package com.atmecs.php.report;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.php.config.Constant;
/**
 * Purpose:Display the test result
 * 
 * @author ranjitha.selvam
 *
 */

public class Reports {
	public Logger logger = null;

	/**
	 * Which keeps track of the record when any event happens or any software run.
	 * 
	 * @param message
	 */

	public void logInfo(String message) {
		PropertyConfigurator.configure(Constant.log4j_file);
		logger = Logger.getLogger(Reports.class.getName());
		logger.info(message);
	}

	/**
	 * Designates error events that might still allow the application to continue
	 * running.
	 * 
	 * @param message
	 */
	public void logError(String message) {
		PropertyConfigurator.configure(Constant.log4j_file);
		logger = Logger.getLogger(Reports.class.getName());
		logger.error(message);
	}

	/**
	 * Designates potentially harmful situations.
	 * 
	 * @param message
	 */
	public void logWarn(String message) {
		PropertyConfigurator.configure(Constant.log4j_file);
		logger = Logger.getLogger(Reports.class.getName());
		logger.warn(message);
	}

}
	