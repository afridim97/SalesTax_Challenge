public class ItemFactory {

	String itemType;
	
	double price;
	
	int quantity;
	
	boolean imported;
	
	boolean exempted;
	
	public Item getItem(String name) {
		
		if(name==null)
			return null;
		
		if(name.equalsIgnoreCase("book") || name.equalsIgnoreCase("books"))
			return new Book("book",0,0,false,true);
		
		if(name.equalsIgnoreCase("pill") || name.equalsIgnoreCase("pills"))
			return new Medicine("medicine",0,0,false,true);
		
		if(name.equalsIgnoreCase("chocolate") || name.equalsIgnoreCase("chocolates"))
			return new Food("food",0,0,false,true);
		else
			return new Misc("other",0,0,false,false);
	
	
	}
	
}