package bank_v1;

public class AccountV1 {
	private String owner;
	private int balance;
	
	public String getOwner() {
		return owner;
	}
	
	public int getBalance() {
		return balance;
	}

	public AccountV1(String owner, int balance) {
		this.owner = owner;
		this.balance = balance;
	}

	public void withdraw(int amount) {
		this.balance = this.balance - amount;
	}
	
	public String toString() {
		return owner + "'s current balance is: " + balance; 
	}
}