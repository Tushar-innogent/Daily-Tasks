package solidPrinciples;

import java.util.Date;

//EmailService has single responsibility i.e., Receiving & Sending Mail
//but if we give logging functionality to this class then it will violates Single Responsibility principle
public class EmailService {

	void sendEmail(Email email) {
		System.out.println("Mail sent! \n"+email);
	}
	void receiveMail() {
		System.out.println("Mail Received!");
	}
}

class Email{
	
	String sender;
	String reveiver;
	String msg;
	Date date;
	
	@Override
	public String toString() {
		return "Email [sender=" + sender + ", reveiver=" + reveiver + ", msg=" + msg + ", date=" + date + "]";
	}
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReveiver() {
		return reveiver;
	}

	public void setReveiver(String reveiver) {
		this.reveiver = reveiver;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}