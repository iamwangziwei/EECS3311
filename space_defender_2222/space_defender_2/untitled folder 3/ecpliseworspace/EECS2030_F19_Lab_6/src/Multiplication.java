
public class Multiplication extends Expression {

	public Multiplication(int left, int right ) {
		super(left,right);
		
	}
	
	public Object getValue() 
	{
		return (int)this.left * this.right;
	}
}
