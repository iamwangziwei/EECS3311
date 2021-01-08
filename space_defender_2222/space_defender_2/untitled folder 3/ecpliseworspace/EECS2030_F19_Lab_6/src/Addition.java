
public class Addition extends Expression {
	
	
	Addition (int left, int right)  {super(left,right); }
	
	
	public Object getValue() 
	{
		return (int)this.left + this.right;
	}
}
