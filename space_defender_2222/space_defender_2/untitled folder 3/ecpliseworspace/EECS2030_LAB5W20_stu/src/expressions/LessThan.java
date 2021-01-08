package expressions;

public class LessThan extends Expression {

	LessThan(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	void evaluate() {
		if (super.left < super.right)
			value = true;
		else
			value = false;
	}
}
