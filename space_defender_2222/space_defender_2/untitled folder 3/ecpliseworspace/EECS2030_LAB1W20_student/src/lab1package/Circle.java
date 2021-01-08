package lab1package;

import java.awt.Color;

public class Circle {
	private double radius;
	private Color color;

	public Circle(double r, Color c) {
		// TODO Auto-generated constructor stub
		if (r < 0)
			throw new IllegalArgumentException();
		this.radius = r;
		this.color = c;
	}

	public Circle() {
		// TODO Auto-generated constructor stub
		this.radius = 1.0;
		this.color = Color.BLUE;
	}

}
