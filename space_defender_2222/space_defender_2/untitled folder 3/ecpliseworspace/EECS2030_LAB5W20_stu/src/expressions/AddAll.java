package expressions;

public class AddAll extends ExpressionCollector {
	void evaluate() {
		int valuenum = (int) value;
		Expression[] e = super.getExpressions();

		for (Expression ee : e) {
			ee.evaluate();

			int re = (int) ee.getValue();
			valuenum = valuenum + re;

		}
		value = valuenum;
	}
}