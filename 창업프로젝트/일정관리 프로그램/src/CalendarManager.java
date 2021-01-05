import java.util.Calendar;

public class CalendarManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar time = Calendar.getInstance();
		
		System.out.println(time.getTime());
		System.out.println(time.get(Calendar.DAY_OF_WEEK));
		System.out.println(time.get(Calendar.MONTH) + 1);
		System.out.println(time.get(Calendar.DAY_OF_MONTH));
		System.out.println(time.get(Calendar.HOUR_OF_DAY));
		System.out.println(time.get(Calendar.MINUTE));
		System.out.println(time.get(Calendar.SECOND));
		System.out.println(time.get(Calendar.YEAR));
	}

}
