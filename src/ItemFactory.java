
public class ItemFactory {

	public Item getItem(String name) {
		
		if(name==null)
			return null;
		
		if(name.equalsIgnoreCase("book") || name.equalsIgnoreCase("books"))
			return new Book();
		
		return null;
	}
	
}