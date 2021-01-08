
public class NonResidentStudent extends Student {

	private double rate = 0.0;
	
	NonResidentStudent (String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	public void setDiscountRate(double d) {
		// TODO Auto-generated method stub
		this.rate = d;
	}

	public double getDiscountRate() {
		// TODO Auto-generated method stub
		return this.rate;
	}

	public double getTuition(){
		double base = super.getTuition();
		return base * rate;
		
	}
	
}
