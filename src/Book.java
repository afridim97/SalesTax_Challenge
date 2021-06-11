
public class Book extends Item{

	Book(){
		
		super();
	}
	
	Book(String itemType,double price,int quantity,boolean exempted,boolean imported){
		
		super(itemType,price,quantity,true,imported);
		
	}
	
}
