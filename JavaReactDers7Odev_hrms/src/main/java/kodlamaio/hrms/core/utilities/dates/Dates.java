package kodlamaio.hrms.core.utilities.dates;

import java.time.LocalDate;
import java.time.ZoneId;

public class Dates {
	static public LocalDate getLocalDate() {
		ZoneId z = ZoneId.of( "Turkey/Istanbul" ) ;
		LocalDate today = LocalDate.now( z ) ;
		return today;
	}
}
