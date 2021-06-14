public class ItemFactory {

	String itemType;
	
	double price;
	
	int quantity;
	
	boolean imported;
	
	boolean exempted;
	
	public Item getItem(String name) {
		
		if(name==null)
			return null;
		
		//formatting to ensure proper name of item gets printed
		
		String itemName=name.substring(1,name.lastIndexOf("at")-1);
		
		if(name.toLowerCase().contains("book") || name.toLowerCase().contains("books"))
			return new Book(itemName,0,0,false,true);
		
		if(name.toLowerCase().contains("pill") || name.toLowerCase().contains("pills"))
			return new Medicine(itemName,0,0,false,true);
		
		if(name.toLowerCase().contains("chocolate") || name.toLowerCase().contains("chocolates"))
			return new Food(itemName,0,0,false,true);
		else
			return new Misc(itemName,0,0,false,false);
	
	
	}
	
}