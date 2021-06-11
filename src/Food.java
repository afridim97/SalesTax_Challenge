
public class Food extends Item{


	Food(){
		
		super();
	}
	
	Food(String itemType,double price,int quantity,boolean exempted,boolean imported){
		
		super(itemType,price,quantity,true,imported);
		
	}
	
	
}
