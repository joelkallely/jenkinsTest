package baseClasses;

import java.util.Calendar;

public class TimePicker {
	public int min = 0;
	public int hour = 0;
	public int sec = 0;
	public int day = 0;
	public int month = 0;
	public int am_pm = 0;
	
	public void gteDateTime() {
	Calendar rightNow =Calendar.getInstance();
   	  hour = rightNow.get(Calendar.HOUR);
   	  min = rightNow.get(Calendar.MINUTE);
   	  am_pm = rightNow.get(Calendar.AM_PM);
   	  day = rightNow.get(Calendar.DAY_OF_MONTH);
   	  month = rightNow.get(Calendar.MONTH)+1;
   	 min+=2;
   	 int rem = min%5;
   	 rem = 5-rem;
   	 min+=rem;
   	 if(min>59){
   		 min-=60;
   		 hour++;
   	 }
	}

}
