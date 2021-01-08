package bank_v2;

import errors.BalanceNegativeException;
import errors.WithdrawAmountNegativeException;
import errors.WithdrawAmountTooLargeException;

/* 
 * Improvement from AccountV1: Preconditions added to constructor and withdraw. 
 */
public class AccountV2 {
	private String owner;
	private int balance;
	
	public String getOwner() {
		return owner;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public AccountV2(String owner, int balance)
		throws BalanceNegativeException
	{
		if(balance < 0) { /* negated precondition */
			throw new BalanceNegativeException();
		}
		else {
			this.owner = owner;
			this.balance = balance;
		}
	}
	
	public void withdraw(int amount)
		throws 
			WithdrawAmountNegativeException, 
			WithdrawAmountTooLargeException
	{
		if(amount < 0) { /* negated precondition */
			throw new WithdrawAmountNegativeException();
		}
		else if (balance < amount) { /* negated precondition */
			throw new WithdrawAmountTooLargeException();
		}
		else {
			this.balance = this.balance - amount;
		}
	}
	
	public String toString() {
		return owner + "'s current balance is: " + balance; 
	}
}
