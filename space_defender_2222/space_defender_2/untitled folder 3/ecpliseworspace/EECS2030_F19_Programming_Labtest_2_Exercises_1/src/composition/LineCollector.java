package composition;

public class LineCollector {

	private Line[] lines;
	
	private int num=0;
	public LineCollector() {
		// TODO Auto-generated constructor stub
		lines = new Line[20];
		
	}
	
	
	public LineCollector(LineCollector lc1) {
		// TODO Auto-generated constructor stub
		this.lines = lc1.lines;
		this.num = lc1.num;
	}


	


	public void addLine(Line l1) {
		// TODO Auto-generated method stub
		Line lll = new Line(l1);
		lines[num] = lll;
		num++;
	}


	public Line getLineAt(int i) {
		// TODO Auto-generated method stub
		Line l = new Line(lines[i]);
		return l;
	}


	public Line[] getLines() {
		// TODO Auto-generated method stub
		Line[] ll = new Line[num];
		for(int i=0;i<num;i++) {
			ll[i] = lines[i];
		}
		return ll;
	}

	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(this.getClass() != obj.getClass() || obj == null)
			return false;
		LineCollector lc = (LineCollector)obj;
		if(this.lines.equals(lc.lines)&&this.num == lc.num)
			return true;
		else
			return false;
	}

	

}
