package composition;

public class Point {

	private double start;
	private double end;
	
	public Point(double i, double j) {
		// TODO Auto-generated constructor stub
		this.start = i;
		this.end = j;
		
	}

	
	
	public Point(Point p3) {
		// TODO Auto-generated constructor stub
		start = p3.start;
		end = p3.end;
	}

	public double getX() {
		
		return start;
	}
	
	public void setX(int x) {
		this.start=x;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Point other = (Point) obj;
		return 
			this.start == other.start
			&&
			this.end  == other.end ;
	}
}
