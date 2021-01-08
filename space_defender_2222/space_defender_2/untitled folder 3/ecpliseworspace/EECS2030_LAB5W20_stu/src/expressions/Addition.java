package expressions;

public class Addition extends Expression {

	Addition(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	void evaluate() {
		value = super.left + super.right;
	}
}
