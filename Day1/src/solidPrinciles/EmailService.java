package solidPrinciles;

import java.sql.Date;

public class EmailService {

	void sendEmail(Email email) {
		System.out.println("Mail sent!");
	}
}

class Email{
	
	String sender;
	String reveiver;
	String msg;
	Date date;
	
}