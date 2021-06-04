
public class Main {
	

	

	public static void main(String[] args) {
		
		String currentDir=System.getProperty("user.dir");

		Receipt r1 = new Receipt(currentDir+"/test_1.txt");	
		
		r1.calculateTotal();
		
		System.out.println("Output 1");
		
		r1.printReceipt();
		
		System.out.println();

		Receipt r2 = new Receipt(currentDir+"/test_2.txt");

		r2.calculateTotal();
		
		System.out.println("Output 2");
		
		r2.printReceipt();
		
		System.out.println();
		
		Receipt r3 = new Receipt(currentDir+"/test_3.txt");
		
		r3.calculateTotal();
		
		System.out.println("Output 3");
		r3.printReceipt();
		
	}

}
