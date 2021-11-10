import java.util.*;
import java.io.*;

///////////////////////////////////////////////Customer Class///////////////////////////////
public class WishList {

	private String item, brand, color,comment;
	private int price,priority;
	public WishList() {
	
		item = "";
		comment = "";
		brand = "";
		color = "";
		priority=0;
		price=0;
	}
	
	public void setCustomer(String item, String brand, String color, String comment){
	
		this.item = item;
		this.brand = brand;
		this.color = color;
		this.comment = comment;
	}
	
	public String getItemName() {
		return this.item;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getComment() {
		return this.comment;
	}

	
	public int getPriority() {
		return this.priority;
	}
	public int getPrice() {
		return this.price;
	}
//	public void saveToFile() throws IOException {
		
//		PrintWriter outFile = new PrintWriter(new FileOutputStream(new File("Customers_Inventory.txt"), true));
//  	outFile.println(getFullName() + " " + getGender() + " " 
//	  	+ getLocation() + " " + getContact() + " " + getStatus());
//	 	outFile.close();
 //	}
}