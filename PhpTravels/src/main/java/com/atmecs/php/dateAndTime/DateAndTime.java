package com.atmecs.php.dateAndTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * To get current date and time
 * 
 * @author ranjitha.selvam
 *
 */

public class DateAndTime {
	public DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
	public Date currentDate = new Date();
	public Calendar calender = Calendar.getInstance();

	/**getting exact date by passing month
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String gettingMonth(String value) throws Exception {
		calender.setTime(currentDate);
		int newValue = Integer.parseInt(value);
		calender.add(Calendar.MONTH, newValue);
		Date getDate = calender.getTime();
		System.out.println("One month later than the current date :" + dateFormat.format(getDate));
		return dateFormat.format(getDate);
	}

	/**getting exact date by passing days
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String gettingDay(String value) throws Exception {
		calender.setTime(currentDate);
		int newValue = Integer.parseInt(value);
		calender.add(Calendar.DAY_OF_MONTH, newValue);
		Date getDate = calender.getTime();
		System.out.println("" + dateFormat.format(getDate));
		return dateFormat.format(getDate);

	}
}
