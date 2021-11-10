import java.util.*;
import java.io.*;

/////////////////////////////////////////////Car class/////////////////////////////////////
public class UserProfile {

	private String firstName,lastName,gender,socialMediaLink,birthDate,mobileNo,friendFirstName,friendLastName,friendMobileNo;

	
	
	public UserProfile() {
	
		firstName = "";
		lastName = "";
		gender = "";
		socialMediaLink="";
		mobileNo="";
		birthDate="";
		friendFirstName="";
		friendLastName="";
		friendMobileNo="";
		
		
	}
	
	public void setProfile(String fN, String lN, String gen,String mN, String bD,String sML,String fFN,String fLN, String fMN ){
	//	public void setProfile(String fN, String lN, String gen,String mN ){
		//public void setProfile(String fN, String lN){	
		firstName = fN;
		lastName = lN;
		gender=gen;
		mobileNo = mN;	
		birthDate=bD;
		socialMediaLink=sML;
		friendFirstName=fFN;
		friendLastName=fLN;
		friendMobileNo=fMN;
	
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getGender() {
		return gender;
	}
		
	public String getMobileNo() {
		return mobileNo;
	}
	public String getSocialMediaLink() {
			return socialMediaLink;
	}
	public String getBirthDate() {
		return birthDate;
}
//	public void saveToFile() throws IOException {
		
//		PrintWriter outFile = new PrintWriter(new FileOutputStream(new File("Cars_Inventory.txt"), true));
//			outFile.println(getCar() + " " + getCarPrice());
//			outFile.close();
//  }
}