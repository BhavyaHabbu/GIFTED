import java.util.*;
import java.io.*;

/////////////////////////////////////////////Car class/////////////////////////////////////
public class UserProfile {

	private String firstName,lastName,gender,socialMediaLink,birthDate,mobileNo,friendFirstName,friendLastName,friendMobileNo,userID,loginUID,viewLoginUID;

	
	
	public UserProfile() {
	
		firstName = "";
		lastName = "";
		gender = "";
		socialMediaLink="";
		mobileNo="";
		birthDate="";
		friendLastName="";
		friendMobileNo="";
		userID="";
		loginUID="";
		
	}
	
	public void setUserProfile(String fN, String lN, String gen,String mN, String bD,String sML,String uID ){
	//	public void setProfile(String fN, String lN, String gen,String mN ){
		//public void setProfile(String fN, String lN){	
		firstName = fN;
		lastName = lN;
		gender=gen;
		mobileNo = mN;	
		birthDate=bD;
	    userID=uID;
	    
	}
	
	public void setFriend(String fFN,String fLN, String fMN){
		//	public void setProfile(String fN, String lN, String gen,String mN ){
			//public void setProfile(String fN, String lN){	
			friendFirstName=fFN;
			friendLastName=fLN;
			friendMobileNo=fMN;
	
		}
	public void setLoginUserID(String lUID) {
		loginUID=lUID;
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
	public String getUserID() {
		return userID;
}
	public String getLoginUID() {
		return loginUID;
}
	public String getViewLoginUID() {
		return viewLoginUID;
	}
	public void setViewLoginUserID(String lVUID) {
		viewLoginUID=lVUID;
	}
//	public void saveToFile() throws IOException {
		
//		PrintWriter outFile = new PrintWriter(new FileOutputStream(new File("Cars_Inventory.txt"), true));
//			outFile.println(getCar() + " " + getCarPrice());
//			outFile.close();
//  }
}