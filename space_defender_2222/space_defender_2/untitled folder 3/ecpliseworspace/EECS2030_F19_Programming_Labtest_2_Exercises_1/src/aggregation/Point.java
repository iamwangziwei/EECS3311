package aggregation;

public class Point {

	
	private int p1=0;
	private int p2=0;
	
	public Point(int i, int j) {
		// TODO Auto-generated constructor stub
		p1=i;
		p2=j;
	}
	public Point(Point p) {
		// TODO Auto-generated constructor stub
		this.p1=p.p1;
		this.p2=p.p2;
	}
	public int getX() {
		return this.p1;
	}
	public void setX(int i) {
		this.p1=i;
	}
	
	public boolean equals(Object pp) {
		if(this==pp)
			return true;
		if(this.getClass() != pp.getClass() || pp== null)
			return false;
		Point ppp = (Point)pp;
		if(this.p1==ppp.p1 && this.p2==ppp.p2)
			return true;
		else 
			return false;
	}

}
