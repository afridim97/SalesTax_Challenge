


public class genSalesTax{
		
	
	public static void main(String[] args) {
		
		String fileLocation=System.getProperty("user.dir");

		Receipt r1 = new Receipt(fileLocation+"/test_1.txt");	
		
		System.out.println("Output 1");
		
		r1.printReceipt();
		
	}
	
}