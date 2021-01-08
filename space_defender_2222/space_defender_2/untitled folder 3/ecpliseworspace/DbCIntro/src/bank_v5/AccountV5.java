package bank_v5;

import errors.*;

public class AccountV5 {
	private String owner;
	private int balance;
	
	public String getOwner() {
		return owner;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public AccountV5(String owner, int balance)
		throws BalanceNegativeException
	{
		if(balance < 0) { /* negated precondition */
			throw new BalanceNegativeException();
		}
		else {
			this.owner = owner;
			this.balance = balance;
		}
		assert this.getBalance() > 0 : owner + "Invariant: positive balance";
	}
	
	public void withdraw(int amount)
		throws 
			WithdrawAmountNegativeException, 
			WithdrawAmountTooLargeException
	{
		int oldBalance = this.balance;
		if(amount < 0) { /* negated precondition */
			throw new WithdrawAmountNegativeException();
		}
		else if (balance < amount) { /* negated precondition */
			throw new WithdrawAmountTooLargeException();
		}
		else {
			/* WRONT IMPLEMENTATION */
			this.balance = this.balance + amount;
		}
		assert this.getBalance() > 0 : owner + "Invariant: positive balance";
		assert this.getBalance() == oldBalance - amount : "Postcondition: balance deducted";
	}
	
	public String toString() {
		return owner + "'s current balance is: " + balance; 
	}
}
