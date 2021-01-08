package myUtil;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList<String> arrL = new MyArrayList<>();
		System.out.println("Initial Size: " + arrL.size());
		System.out.println( "isEmpty():" + arrL.isEmpty() );

		arrL.add("EECS");   arrL.add("2030");
		arrL.add("Class");  arrL.add("Example about");
		arrL.add("Array");  arrL.add("List");
		arrL.add(1,"XXX");
		System.out.println("Current Size: " + arrL.size());
		System.out.println("Content: " + arrL);
		System.out.println("indexOf Class: " +arrL.indexOf("Class")+"\n");


		arrL.remove("Array");
		System.out.println("Current Size: " + arrL.size());
		System.out.println("Content: " + arrL);
		System.out.println("Contains Array: " +arrL.contains("Array"));
		System.out.println("indexOf Class: " +arrL.indexOf("Class")+"\n");


		arrL.remove(2);
		System.out.println("Current Size: " + arrL.size());
		System.out.println("Content: " + arrL);
		System.out.println("indexOf Class: " +arrL.indexOf("Class")+"\n");  
		
		
		MyArrayList<Integer> arrL2 = new MyArrayList<>();
		arrL2.add(7);   arrL2.add(3);
		arrL2.add(5);  arrL2.add(6);
		arrL2.add(8);  arrL2.add(9);
		arrL2.add(3,999);
		System.out.println("Current Size: " + arrL2.size());
		System.out.println("Content: " + arrL2);
		
		
		
		

	}
	
	public static void print(MyArrayList<Object> a){
		for(int i=0; i<a.size();i++) {
			System.out.println(a.get(i) + " ");
		}
		System.out.println();
	}

}
