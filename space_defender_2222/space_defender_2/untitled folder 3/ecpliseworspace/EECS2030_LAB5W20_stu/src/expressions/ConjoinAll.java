package expressions;

public class ConjoinAll extends ExpressionCollector {
	void evaluate() {
		value = true;
		Expression[] e = super.getExpressions();
		boolean valuebool = (boolean) value;
		for (Expression ee : e) {
			ee.evaluate();

			boolean re = (boolean) ee.getValue();
			valuebool = valuebool && re;

		}
		value = valuebool;
	}
}
