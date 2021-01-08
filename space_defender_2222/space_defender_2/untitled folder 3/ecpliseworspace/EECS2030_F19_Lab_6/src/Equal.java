
public class Equal extends Expression {

	Equal (int left, int right)  {super(left,right); }
	
	public Object getValue() 
	{
		if(this.left == this.right)
			return true;
		else return false;
	}
	
}
