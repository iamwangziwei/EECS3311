
public class Subtraction extends Expression {
	
	public Subtraction(int left, int right) {
		super(left,right);
		
	}

	public Object getValue() 
	{
		return (int)this.left - this.right;
	}
}
