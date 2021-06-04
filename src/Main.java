
public class Main {
	

	

	public static void main(String[] args) {
	

		Receipt r1 = new Receipt("C:\\Users\\99002538\\eclipse-workspace\\SalesTax_Challenge\\test_1.txt");	
		
		r1.calculateTotal();
		
		System.out.println("Output 1");
		
		r1.printReceipt();
		
		System.out.println();

		Receipt r2 = new Receipt("C:\\Users\\99002538\\eclipse-workspace\\SalesTax_Challenge\\test_2.txt");

		r2.calculateTotal();
		
		System.out.println("Output 2");
		
		r2.printReceipt();
		
		System.out.println();
		
		Receipt r3 = new Receipt("C:\\Users\\99002538\\eclipse-workspace\\SalesTax_Challenge\\test_3.txt");
		
		r3.calculateTotal();
		
		System.out.println("Output 3");
		r3.printReceipt();
		
	}

}
