package expressions;

public class TimesAll extends ExpressionCollector {

	void evaluate() {
		if (super.getExpressions().length == 0)
			value = 1;
		else {
			int valuenum = 1;
			Expression[] e = super.getExpressions();

			for (Expression ee : e) {
				ee.evaluate();

				int re = (int) ee.getValue();
				valuenum = valuenum * re;

			}

			value = valuenum;
		}
	}
}
