package aggregation;

public class LineCollector {
	private final int max = 100;
    private Line[] lines ;
    private int index;
    
	public LineCollector() {
		// TODO Auto-generated constructor stub
		lines = new Line[max];
		index = 0;
	}
	public LineCollector(LineCollector lc1) {
		// TODO Auto-generated constructor stub
		this.index=lc1.index;
		this.lines = lc1.lines;
	}
	public void addLine(Line l1) {
		// TODO Auto-generated method stub
		lines[index] = l1;
		index++;
	}
	public Line getLineAt(int i) {
		// TODO Auto-generated method stub
		return lines[i];
	}
	public Line[] getLines() {
		// TODO Auto-generated method stub
		return lines;
	}
	
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null || this.getClass() != obj.getClass())
			return false;
		LineCollector lc = (LineCollector) obj;
		if(this.lines.equals(lc.lines) && lc.index == this.index)
			return true;
		else
			return false;
	}

}
