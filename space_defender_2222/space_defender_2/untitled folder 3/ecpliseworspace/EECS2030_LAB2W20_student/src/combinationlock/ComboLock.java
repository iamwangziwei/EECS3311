package combinationlock;


	/**
	   A class to simulate a combination lock.
	*/
	public class ComboLock
	{
	   private int secret1;
	   private int secret2;
	   private int secret3;

	   // 0: nothing entered, 1: secret1 done, 2: secret2 done, 
	   // 3: secret3 done and unlocked
	   private int lockState;

	   private int currentNumber;
	   private boolean validSoFar;

	   /**
	      Initializes the combination of the lock.
	      @param secret1 first number to turn right to
	      @param secret2 second number to turn left to
	      @param secret3 third number to turn right to
	   */
	   public ComboLock(int secret1, int secret2, int secret3)
	   {
	      this.secret1 = secret1;
	      this.secret2 = secret2;
	      this.secret3 = secret3;
	   }

	   /**
	      Resets the state of the lock so that it can be opened again.
	   */
	   public void reset()
	   {
	     this.lockState = 0;
	   }

	   /**
	      Turns lock left given number of ticks.
	      @param ticks number of ticks to turn left
	   */
	   public void turnLeft(int ticks)
	   {
	      if (this.currentNumber - ticks < 0) {
	    	  this.currentNumber = 40 + (this.currentNumber - ticks);
	      }
	      else {
	    	  this.currentNumber = this.currentNumber - ticks;
	      }
	   }

	   /**
	      Turns lock right given number of ticks
	      @param ticks number of ticks to turn right
	   */
	   public void turnRight(int ticks)
	   {
	      if (this.currentNumber + ticks > 39) {
	    	  this.currentNumber = this.currentNumber + ticks - 40;
	      }
	      else {
	    	  this.currentNumber = this.currentNumber + ticks;
	      }
	   }

	   /**
	      Returns true if the lock can be opened now
	      @return true if lock is in open state
	   */
	   public boolean open()
	   {
		   switch (this.lockState) {
		   case 0:
			   if (this.currentNumber == this.secret1) {
			    	  this.lockState = 1;			    	  
			   }
		   break;
		   case 1:
			   if (this.currentNumber == this.secret2) {
				      this.lockState = 2;				     
			   }
		   break;
		   case 2:
			   if (this.currentNumber == this.secret3) {
				      this.lockState = 3;				     
			   }
		   break;
		   }
		   if (this.lockState == 3) {
			   return true;
		   }
		   else 
			   return false;
	   }
	}



