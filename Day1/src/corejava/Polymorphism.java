package corejava;

// Taking bank example for overriding concept

class BankAccount{

	private static double amount;
	
	public void deposit(double depositAmmount) {
		BankAccount.amount += depositAmmount;
	}
	
	public String withdrawal(double withdrawAmmount) {
		if(withdrawAmmount <= amount) {
			amount -= withdrawAmmount;
			return "Amount Successfully Withdrawn";
		}
		return "Insufficient Amount in Account";
	}
	
	public void interestCalculation(double amount) {
		
//		rate of interest 7% 
		
	}
}

// calculating interest with different rate of interest 
public class Polymorphism extends BankAccount{
	
	@Override
	public void interestCalculation(double amount) {
		
		// rate of interest 11%
	}
	
}
