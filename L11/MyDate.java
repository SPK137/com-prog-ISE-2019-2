public class MyDate{

	private static String[] strMonths = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	private static String[] strDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private static int[] daysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};
	private int year,month,day;
	private int dayOfWeek;

	public MyDate(int year, int month, int day) {

		if( !isValidDate(year, month, day) ){
			System.out.println("Invalid year, month, or day!");
		}
		else{
			setYear(year);
			setMonth(month);
			setDay(day);
			dayOfWeek = MyDate.getDayOfWeek(year, month, day);
		}

	}

	public static boolean isLeapYear(int year){
		return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	}

	public static boolean isValidDate(int year, int month, int day){
		boolean isValidDay = ( day >= 1 && day <= daysInMonths[month-1] + ( isLeapYear(year) && month == 2 ? 1 : 0 ) );
		boolean isValidMonth = ( month >= 1 && month <= 12 );
		boolean isValidYear = ( year >= 1 && year <= 9999 );
		return isValidYear && isValidMonth && isValidDay;
	}

	public static int getDayOfWeek(int year, int month, int day) {
		int dow = 0;
		int[] centuryIndex = { 6, 4, 2, 0 };
		int[] nonLeapYearMonthIndex = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
		int[] leapYearMonthIndex = { 6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

		int year1 = (int) Math.floor(year / 100.0);
		int year2 = year % 100;
		int centuryNum = centuryIndex[(year1 % 4)];

		int monthNum = nonLeapYearMonthIndex[month-1];
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			monthNum = leapYearMonthIndex[month-1];
		}

		dow = (centuryNum + year2 + (int) Math.floor(year2 / 4) + monthNum + day) % 7;
		return dow;
	}

	public void setDate(int newYear, int newMonth, int newDay){
		setYear(newYear);
		setMonth(newMonth);
		setDay(newDay);
	}

	public int getYear(){
		return year;
	}

	public int getMonth(){
		return month;
	}

	public int getDay(){
		return day;
	}

	public void setYear(int newYear){
		year = newYear;
	}

	public void setMonth(int newMonth){
		month = newMonth;
	}

	public void setDay(int newDay){
		day = newDay;
	}

	public String toString(){
		return strDays[dayOfWeek] + " " + day + " " + strMonths[month-1] + " " + year; 
	}

	public MyDate nextDay(){

		int newDay = day+1;
		int newMonth = month;
		int newYear = year;
		if( isValidDate(year, month, day+1) )
			newDay = day+1;
		else{
			if( isValidDate(year, month+1, 1) ){
				newDay = 1;
				newMonth = month+1;
			}
			else{
				if( isValidDate(year+1, 1, 1) ){
					newDay = 1;
					newMonth = 1;
					newYear = year+1;
				}
				else
					System.out.println("This date is out of range.");
			}

		}

		return new MyDate(newYear, newMonth, newDay);
	}

	public MyDate nextMonth(){

		int newDay = 1;
		int newMonth = month+1;
		int newYear = year;
		if( isValidDate(year, month+1, 1) ){
			newDay = 1;
			newMonth = month+1;
		}
		else{
			if( isValidDate(year+1, 1, 1) ){
				newDay = 1;
				newMonth = 1;
				newYear = year+1;
			}
			else
				System.out.println("This date is out of range.");
		}

		return new MyDate(newYear, newMonth, newDay);
	}

	public MyDate nextYear(){

		int newDay = 1;
		int newMonth = 1;
		int newYear = year+1;
		if( isValidDate(year+1, 1, 1) ){
			newDay = 1;
			newMonth = 1;
			newYear = year+1;
		}
		else
			System.out.println("This date is out of range.");

		return new MyDate(newYear, newMonth, newDay);
	}

	public MyDate previousDay(){

		int newDay = day-1;
		int newMonth = month;
		int newYear = year;
		if( isValidDate(year, month, day-1) )
			newDay = day-1;
		else{
			if( isValidDate(year, month-1, daysInMonths[(month-1)-1] + ( isLeapYear(year) && month-1 == 2 ? 1:0 ))){
				newDay = daysInMonths[(month-1)-1] + ( isLeapYear(year) && month-1 == 2 ? 1 : 0 );
				newMonth = month-1;
			}
			else{
				if( isValidDate(year-1, 12, daysInMonths[(month-1)-1] + ( isLeapYear(year) && month-1 == 2 ? 1 : 0 )) ){
					newDay = daysInMonths[(month-1)-1] + ( isLeapYear(year) && month-1 == 2 ? 1 : 0 );
					newMonth = 12;
					newYear = year-1;
				}
				else
					System.out.println("This date is out of range.");
			}

		}

		return new MyDate(newYear, newMonth, newDay);
	}

	public MyDate previousMonth(){

		int newDay = 1;
		int newMonth = month-1;
		int newYear = year;
		if( isValidDate(year, month-1, 1) ){
			newDay = 1;
			newMonth = month-1;
		}
		else{
			if( isValidDate(year-1, 12, 1) ){
				newDay = 1;
				newMonth = 12;
				newYear = year-1;
			}
			else
				System.out.println("This date is out of range.");
		}

		return new MyDate(newYear, newMonth, newDay);
	}

	public MyDate previousYear(){

		int newDay = 1;
		int newMonth = 1;
		int newYear = year-1;

		if( isValidDate(year-1, 1, 1) ){
			newDay = 1;
			newMonth = 1;
			newYear = year-1;
		}
		else
			System.out.println("This date is out of range.");

		return new MyDate(newYear, newMonth, newDay);
	}

}