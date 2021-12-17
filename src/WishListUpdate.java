	import java.util.*;
	import java.io.*;

	public class WishListUpdate {

		private String item, brand, color,comment;
		private int price,priority;
		public WishListUpdate() {
		
			item = "";
			comment = "";
			brand = "";
			color = "";
			priority=0;
			price=0;
		}
		
		public void setItem(String item){
		
			this.item = item;

		}
		
		public void setBrand(String brand) {
			this.brand=brand;
		}
		public void setColor(String color) {
			this.color=color;
		}
		public void setComment(String comment) {
			this.comment=comment;
		}
		public void setPrice(int price) {
			this.price=price;
		}
		public void setPriority(int priority) {
			this.priority=priority;
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
//		public void saveToFile() throws IOException {
			
//			PrintWriter outFile = new PrintWriter(new FileOutputStream(new File("Customers_Inventory.txt"), true));
//	  	outFile.println(getFullName() + " " + getGender() + " " 
//		  	+ getLocation() + " " + getContact() + " " + getStatus());
//		 	outFile.close();
	 //	}
	}

