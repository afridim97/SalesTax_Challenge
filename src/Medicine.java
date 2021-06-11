
public class Medicine extends Item{

	Medicine(){
		
		super();
	}
	
	Medicine(String itemType,double price,int quantity,boolean exempted,boolean imported){
		
		super(itemType,price,quantity,true,imported);
		
	}
	
}
