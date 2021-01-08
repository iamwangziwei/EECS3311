package lab1package2;

public class Rectangle {

	private int H;
	private int W;
	private int A;

	public Rectangle(int h, int w) {
		// TODO Auto-generated constructor stub
		this.H = h;
		this.W = w;
		this.A = w * h;
	}

	public Rectangle() {
		// TODO Auto-generated constructor stub

	}

	public int getH() {
		// TODO Auto-generated method stub
		return this.H;
	}

	public int getW() {
		// TODO Auto-generated method stub
		return this.W;
	}

	public int getA() {
		// TODO Auto-generated method stub
		return this.A;
	}

	public void setH(int h) {
		// TODO Auto-generated method stub
		this.H = h;
	}

	public void setW(int w) {
		// TODO Auto-generated method stub
		this.W = w;
	}

}
