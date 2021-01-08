package eecs2030.lab1;
import eecs2030.lab1.Hounsfield;
/**
 * A class that represents a windowed view of Hounsfield units. A Hounsfield
 * window is defined by two values: (1) the window level, and (2) the window
 * width. The window level is the Hounsfield unit value that the window is
 * centered on. The window width is the range of Hounsfield unit values that the
 * window is focused on.
 * 
 * <p>
 * A window has a lower and upper bound. The lower bound is defined as the
 * window level minus half the window width:
 * 
 * <p>
 * lo = level - (width / 2)
 * 
 * <p>
 * The upper bound is defined as the window level plus half the window width:
 * 
 * <p>
 * hi = level + (width / 2)
 * 
 * <p>
 * Hounsfield units are mapped by the window to a real number in the range of
 * {@code 0} to {@code 1}. A Hounsfield unit with a value less than lo is mapped
 * to the value {@code 0}. A Hounsfield unit with a value greater than hi is
 * mapped to the value {@code 1}. A Hounsfield unit with a value v between lo
 * and hi is mapped to the value:
 * 
 * <p>
 * (v - lo) / width
 * 
 *
 */
public class HounsfieldWindow {
	public int level;
	public int width;
	
	
	
	public HounsfieldWindow(int level, int width) {
		checkValue(level);
		checkWidth(width);
		this.level = level;
		this.width = width;
	}
	
	
	public HounsfieldWindow() {
		this.level = 0;
		this.width=400;
	}
	
	public int getLevel() {
		return  this.level;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	
	public int setLevel(int level) {
		checkValue(level);
		int temp = this.level;
		this.level = level;
		return temp;
	}
	private static void checkValue(int level) {
		if((level>3071)||(level<-1024)) {
			throw new IllegalArgumentException();
		}
	}
	
	private static void checkWidth(int width) {
		if(width<=0) {
			throw new IllegalArgumentException();
		}
	
	}
	public int setWidth(int width) {
		checkWidth(width);
		int temp = this.width;
		this.width = width;
		return temp;
	}
	
	
	private static double[] mapValues(int winWidth) {
		final int n = winWidth / 2 * 2 + 1;
		double[] result = new double[n];
		for (int i = 0; i < n; i++) {
			if (winWidth % 2 == 0) {
				result[i] = (0.0 + i) / winWidth;
			}
			else {
				result[i] = (1.0 + 2 * i) / (2 * winWidth);
			}
		}
		return result;
	}
	
	
	public double map(Hounsfield value) {
		double[] EXP = HounsfieldWindow.mapValues(width);
		int h =(this.level - this.width / 2);
		
		return  h;
	}
}
