package lab1package2;
import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointTester {
	
	


		@Test
		public void test01_getX() {
			Point2 p = new Point2();
			assertTrue("(new Point2()).getX() did not return 0.0\n",
					p.getX() == 0.0);
			
			double x = 1.0;
			double y = -1.0;
			p = new Point2(x, y);
			assertTrue("(new Point2(1.0, -1.0)).getX() did not return 1.0\n",
					p.getX() == x);
		}

		@Test
		public void test02_getY() {
			Point2 p = new Point2();
			assertTrue("(new Point2()).getY() did not return 0.0\n",
					p.getY() == 0.0);
			
			double x = 1.0;
			double y = -1.0;
			p = new Point2(x, y);
			assertTrue("(new Point2(1.0, -1.0)).getY() did not return -1.0\n",
					p.getY() == y);
		}

		@Test
		public void test03_setX() {
			Point2 p = new Point2();
			
			double x = 1.0;
			p.setX(x);
			assertTrue("p.setX(1.0) did not set x to 1.0\n",
					p.getX() == x);
		}

		@Test
		public void test04_setY() {
			Point2 p = new Point2();
			
			double y = -1.0;
			p.setY(y);
			assertTrue("p.setY(-1.0) did not set y to -1.0\n",
					p.getY() == y);
		}

		@Test
		public void test05_set() {
			Point2 p = new Point2();
			
			double x = 1.0;
			double y = -1.0;
			p.set(x, y);
			assertTrue("p.set(1.0, -1.0) did not set x to 1.0 and y to -1.0\n",
					p.getX() == x && p.getY() == y);
		}

		@Test
		public void test06_moveX() {
			double x = -1.0;
			double y = 5.0;
			double dx = 25.5;
			Point2 p = new Point2(x, y);
			p.moveX(dx);
			
			assertTrue("p.moveX(25.5) did not add 25.5 to x\n",
					p.getX() == x + dx);
			assertTrue("p.moveX(25.5) changed y!\n",
					p.getY() == y);
			
		}
		
		@Test
		public void test07_moveY() {
			double x = -1.0;
			double y = 5.0;
			double dy = -25.5;
			Point2 p = new Point2(x, y);
			p.moveY(dy);
			
			assertTrue("p.moveY(-25.5) did not add -25.5 to y\n",
					p.getY() == y + dy);
			assertTrue("p.moveY(-25.5) changed x!\n",
					p.getX() == x);
		}
		
		@Test
		public void test08_distanceTo() {
			double x = -1.0;
			double y = 5.0;
			Point2 p = new Point2(x, y);
			                       
 			double dx = -1.0;
			double dy = 1.0;
			Point2 q = new Point2(x + dx, y + dy);
			
			assertEquals("p.distanceTo(p) should return 0.0\n", 
					0.0, p.distanceTo(p), 1e-9);
			assertEquals("p.distanceTo(q) should return sqrt(2)\n", 
					Math.hypot(dx, dy), p.distanceTo(q), 1e-9);
			assertEquals("q.distanceTo(p) should return sqrt(2)\n", 
					Math.hypot(dx, dy), q.distanceTo(p), 1e-9);
		}
		
		@Test
		public void test09_similarTo() {
			Point2 p = new Point2();
			double delta = 0.001;
			Point2 q = new Point2(delta, 0.0);
			Point2 r = new Point2(0.0, delta);
			
			double tol = 1.001 * delta;
			assertTrue("(0, 0) and (0.001, 0) are similar for tol = " + tol,
					p.similarTo(q, tol));
			assertTrue("(0, 0) and (0, 0.001) are similar for tol = " + tol,
					p.similarTo(r, tol));
			
			tol = 0.999 * delta;
			assertFalse("(0, 0) and (0.001, 0) are not similar for tol = " + tol,
					p.similarTo(q, tol));
			assertFalse("(0, 0) and (0, 0.001) are not similar for tol = " + tol,
					p.similarTo(r, tol));
			
			tol = 1.001 * Math.hypot(delta, delta);
			Point2 s = new Point2(-delta, -delta);
			assertTrue("(0, 0) and (0.001, 0.001) are similar for tol = " + tol,
					p.similarTo(s, tol));
			
			tol = 0.999 * Math.hypot(delta, delta);
			assertFalse("(0, 0) and (0.001, 0.001) are not similar for tol = " + tol, 
					p.similarTo(s, tol));
		}
		
		@Test
		public void test10_toString() {
			double x = -1.0 / 3.0;
			double y = 1.0000000001;
			Point2 p = new Point2(x, y);
			
			String expected = "(" + x + ", " + y + ")";
			assertEquals(expected, p.toString());
		}

		
		
		
		
	}


