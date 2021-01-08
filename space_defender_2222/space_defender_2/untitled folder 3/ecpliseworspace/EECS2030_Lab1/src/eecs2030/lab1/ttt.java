
public class Temperature 
	{private double degrees;
	private String units;
	
	
	public Temperature() 
	{this.degrees = 0.0;this.units = "C";}
	
	public void setUnits(String units) {
	if (units == "C" || units == "F") 
	{this.units = units;}
	}