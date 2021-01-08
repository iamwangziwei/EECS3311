package expressions;

public class Equal extends Expression {

	Equal(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	void evaluate() {
		if (super.left == super.right)
			value = true;
		else
			value = false;
	}
}
