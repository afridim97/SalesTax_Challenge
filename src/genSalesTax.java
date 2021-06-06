
public class genSalesTax{
		
	
	public static void main(String[] args) {
		
	String fileLocation=System.getProperty("user.dir");
		
	for(int i=0;i<args.length;i++) {
		
		//let args[i] be the name of the test file
		
		Receipt r= new Receipt(fileLocation+"/"+args[i]);	
		
		r.printReceipt();
		
		}
	
	}
	
}
	
