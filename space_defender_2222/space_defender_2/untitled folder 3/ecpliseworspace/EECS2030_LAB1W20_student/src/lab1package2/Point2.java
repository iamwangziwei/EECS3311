package lab1package2;

public class Point2 {

	/**
	 * A simple class for representing points in 2D Cartesian coordinates. Every
	 * <code>Point2D</code> instance has an x and y coordinate.
	 * 
	 * 
	 *
	 */

	private double x;
	private double y;

	/**
	 * Initialize the point to have coordinates <code>(0, 0)</code>.
	 */
	public Point2() {

	}

	/**
	 * Initialize the point to have coordinates <code>(x, y)</code>.
	 * 
	 * @param x the x-coordinate of the point
	 * @param y the y-coordinate of the point
	 */
	public Point2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Initialize a point to have the same coordinates as <code>other</code>.
	 * 
	 * @param other another point
	 */
	public Point2(Point2 other) {
	}

	/**
	 * Returns the x-coordinate of this point.
	 * 
	 * @return the x-coordinate of this point
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * Returns the y-coordinate of this point.
	 * 
	 * @return the y-coordinate of this point
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * Sets the x-coordinate of this point to <code>newX</code>.
	 * 
	 * @param newX the new x-coordinate of this point
	 */
	public void setX(double newX) {
		this.x = newX;
	}

	/**
	 * Sets the y-coordinate of this point to <code>newY</code>.
	 * 
	 * @param newY the new y-coordinate of this point
	 */
	public void setY(double newY) {
		this.y = newY;
	}

	/**
	 * Sets the x-coordinate and y-coordinate of this point to <code>newX</code> and
	 * <code>newY</code>, respectively.
	 * 
	 * @param newX the new x-coordinate of this point
	 * @param newY the new y-coordinate of this point
	 */
	public void set(double newX, double newY) {
		this.x = newX;
		this.y = newY;
	}

	/**
	 * Move the point in the x direction by an amount dx. The new x coordinate of
	 * the point is equal to <code>(this.getX() + dx)</code>.
	 * 
	 * @param dx the change in the x coordinate of this point
	 */
	public void moveX(double dx) {
		this.x = this.getX() + dx;
	}

	/**
	 * Move the point in the y direction by an amount dy. The new y coordinate of
	 * the point is equal to <code>(this.getY() + dy)</code>.
	 * 
	 * @param dy the change in the y coordinate of this point
	 */
	public void moveY(double dy) {
		this.y = this.getY() + dy;
	}

	/**
	 * Returns the distance between this point and another point.
	 * 
	 * @param other another point
	 * @return the distance between this point and another point
	 */
	public double distanceTo(Point2 other) {
		return Math.sqrt(Math.pow((this.getX() - other.getX()), 2) + Math.pow((this.getY() - other.getY()), 2));
	}

	/**
	 * Determines if two points are almost equal (similar). Two points are similar
	 * if the distance between them is smaller than the specified tolerance.
	 * 
	 * @param other the other point to compare
	 * @param tol   the threshold distance between this point and other
	 * @return true if the distance between this point and other is strictly less
	 *         than tol
	 */
	public boolean similarTo(Point2 other, double tol) {
		if (this.distanceTo(other) < tol)
			return true;
		else
			return false;

	}

	/**
	 * Returns a string representation of this point. The string representation of
	 * this point is the x and y-coordinates of this point, separated by a comma and
	 * space, inside a pair of parentheses.
	 * 
	 * @return a string representation of this point
	 */
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

}
