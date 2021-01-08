
public class ResidentStudent extends Student{

	private double rate = 0.0;
	
	
	ResidentStudent (String name) { super(name); }

	public void setPremiumRate(double d) {
		// TODO Auto-generated method stub
		this.rate =d;
	}

	
	
	public double getPremiumRate() {
		// TODO Auto-generated method stub
		return this.rate;
	}
	
	public double getTuition() {
		double base = super.getTuition();
		return base * rate;
	}
}
