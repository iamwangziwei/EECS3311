package expressions;

public class DisjoinAll extends ExpressionCollector {
	void evaluate() {
		value = false;
		Expression[] e = super.getExpressions();
		boolean valuebool = (boolean) value;
		for (Expression ee : e) {
			ee.evaluate();

			boolean re = (boolean) ee.getValue();
			valuebool = valuebool || re;

		}
		value = valuebool;
	}
}
