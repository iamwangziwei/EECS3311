package aggregation;

public class Line {

	private Point p1;
	private Point p2;
	
	public Line(Point p1, Point p2) {
		// TODO Auto-generated constructor stub
		this.p1 = p1;
		this.p2 = p2;
	}

	public Line(Line l1) {
		// TODO Auto-generated constructor stub
		this.p1=l1.p1;
		this.p2 = l1.p2;
	}

	public Point getStart() {
		// TODO Auto-generated method stub
		return this.p1;
		
	}

	public Point getEnd() {
		// TODO Auto-generated method stub
		return this.p2;
	}
	
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(this.getClass() != obj.getClass() || obj == null)
			return false;
		Line l = (Line)obj;
		if(this.p1.equals(l.p1) && this.p2.equals(l.p2))
			return true;
		else 
			return false;
}
}
