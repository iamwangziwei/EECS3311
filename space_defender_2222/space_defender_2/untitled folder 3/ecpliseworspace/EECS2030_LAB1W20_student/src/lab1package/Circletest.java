package lab1package;

import static org.junit.Assert.*;

import org.junit.Test;





	import java.awt.Color;
	import java.lang.reflect.Constructor;
	import java.lang.reflect.Field;
	import java.lang.reflect.Modifier;

	
	import org.junit.runners.MethodSorters;
	import org.junit.FixMethodOrder;

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public class Circletest {

		@Test
		public void test00() {
			Circle c = new Circle();
			for (Field f : Circle.class.getDeclaredFields()) {
				if (f.getName().equals("color")) {
					this.checkColor(f, c, Color.BLUE);
				}
				else if (f.getName().equals("radius")) {
					this.checkRadius(f, c, 1.0);
				}
			}
		}
		
		
		
		@Test
		public void test01() {
			Circle c = new Circle(1.5, Color.RED);
			for (Field f : Circle.class.getDeclaredFields()) {
				if (f.getName().equals("color")) {
					this.checkColor(f, c, Color.RED);
				}
				else if (f.getName().equals("radius")) {
					this.checkRadius(f, c, 1.5);
				}
			}
		}
		
		@Test
		public void test02() {
			Circle c = new Circle(0.0, Color.CYAN);
			for (Field f : Circle.class.getDeclaredFields()) {
				if (f.getName().equals("color")) {
					this.checkColor(f, c, Color.CYAN);
				}
				else if (f.getName().equals("radius")) {
					this.checkRadius(f, c, 0.0);
				}
			}
		}
		
		@Test(expected = IllegalArgumentException.class) 
		public void test03() {
			Circle c = new Circle(-0.0001, Color.BLACK);
		}
		
		
		private void checkColor(Field f, Circle c, Color exp) {
			f.setAccessible(true);
			try {
				Color color = (Color) f.get(c);
				assertEquals("Circle constructor failed to set the color correctly\n", 
						exp, color);
			}
			catch (IllegalAccessException x) {
				fail("cannot access field \"color\"");
			}
		}
		
		private void checkRadius(Field f, Circle c, double exp) {
			f.setAccessible(true);
			try {
				double radius = f.getDouble(c);
				assertEquals("Circle constructor failed to set the radius correctly\n", 
						exp, radius, 1e-9);
			}
			catch (IllegalAccessException x) {
				fail("cannot access field \"radius\"");
			}
		}

	}


