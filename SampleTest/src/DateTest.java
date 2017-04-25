import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest {

	public static void main(String[] args) {
	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
		Calendar cal = Calendar.getInstance();  
		System.out.println(dateFormat.format(cal.getTime()));
		java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
		//Here Reader Read the Pack query
		
		//send timestamp to systimestop 
		// means we need to execute to the  
		//update K_RXT_BTCH_RUN_CNTL set last_run_tmst=timestamp where btch_prc_nm='PK_DELTA'
		//I think we need to execute this query from java programme we need to use  jdbctemplate
		/*jdbcTemplate.update(
                "update K_RXT_BTCH_RUN_CNTL set last_run_tmst = ? where btch_prc_nm='PK_DELTA', 
                timestamp);*/
	System.out.println(timestamp);
	}

}
