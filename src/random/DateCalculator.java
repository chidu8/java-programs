package random;

import java.util.Calendar;
import java.util.Date;

/*
Write a business_days_from_now() method, which takes as an input a number of business days, and returns a Date object which is that many business days from now. For this, a business day is only a weekday and not a weekend.

for example:
Today is Wednesday the 8th.
business_days_from_now(5)

Current Date: Jan 8, 2013 Wednesday

Output: Wednesday the 15th
*/

public class DateCalculator {

		// LOGIC: If we're given access to Java's Date class: 
		// public static Date businessDaysFromNow (int numBusinessDays, Date today) {
		// 		Date current = today;
		//		int count = numBusinessDays;
		//		while (count!=0) {
		//			String day = current.getDayPart();	
		//			if (day.equals("Saturday") ||day.equals("Sunday")) {
		//				//do nothing
		//			}
		//			else {
		//				count--;
		//			}
		//			current = current.increment(1);
		//		}
		//		if (count==0) {
		//			return current;
		//		}
		//		else {
		//			return null;
		//		}
		// }
	
		public static Date businessDaysFromNow(int businessDays, Date date) {

			final long ONE_DAY = 1000L * 60 * 60 * 24;
			int numBusinessDaysTillFirstMonday=0;//for sat and sun
			int day = date.getDay();
			Date resultDate;
			if (day>0 || day<6) {
				numBusinessDaysTillFirstMonday = 8-day-2;
			}
			if (businessDays < numBusinessDaysTillFirstMonday) {
				resultDate = new Date(date.getTime() + businessDays * ONE_DAY);
			}
			else {
				int weekendDays = 2;
				businessDays = businessDays-numBusinessDaysTillFirstMonday;
				int weeks = businessDays / 5;
				int extraDays = businessDays % 5;
				weekendDays = weekendDays + 2*weeks;
				int totalDays = businessDays + numBusinessDaysTillFirstMonday +weekendDays;
				resultDate =  new Date(date.getTime() + totalDays * ONE_DAY);;
			}
			return resultDate;
		}
	
	public static void main(String[] args) {
		
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		System.out.println(businessDaysFromNow(10,tomorrow));
	}

}
