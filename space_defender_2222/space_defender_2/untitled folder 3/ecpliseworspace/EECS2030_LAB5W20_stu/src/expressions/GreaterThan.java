package expressions;

public class GreaterThan extends Expression {

	GreaterThan(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	void evaluate() {
		if (super.left > super.right)
			value = true;
		else
			value = false;

	}
}
