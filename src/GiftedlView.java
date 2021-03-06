
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.regex.Pattern;

//import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class GiftedlView extends JFrame{


	// as global declaration
	private WishList wishList = new WishList();// access class WishList as global declaration
	private UserProfile userProfile = new UserProfile();
	private WishListCreate wishListCreate = new WishListCreate();
	private WishListUpdate wishListUpdate = new WishListUpdate();
	private GiftedUpdateWishList giftedUpdateWishList= new GiftedUpdateWishList();
	Container pane = getContentPane();
	private JPanel mainP, createP, viewFreindsP,createEventP,createWishListUpdateProfileU, createWishListP, loginP, updateP, showEventP,viewLoginP,createWishListUpdateProfileP; // panels for CardLayout
	private JLabel titleL, profileC, profileInfo, profileV,friendFirstNameLV,friendMobileNoLV,friendLastNameLV, profileU,friendProfileInfo; // inside the panel of mainP
	private JButton mainNextC, mainNextV,mainNextU;
	private JLabel firstNameL, mainTitleL,lastNameL, mobileNoL,friendFirstNameInfoL, socialMediaL, birthDateL, eventL, genderL, loginUsernameL, loginUserPasswordL,viewLoginUsernameL,userIDPWD,firstNameLA,lastNameLA,
	loginUserLastNameL, loginPasswordL,createWishListInfoL, friendFirstNameL, friendLastNameL; // inside the panel of, createP
	private JLabel firstNameChecker, lastNameChecker, genderChecker, contactChecker,loginUserPWDChecker;
	private JTextField nameFirstTF, firstNameTF,friendMobileTFV, lastNameTF, locationTF, contactTF, mobileNoTF, genderTF, socialMediaTF,
	loginPasswordTF, loginUserIDTF, loginMobileNoTF, nameFriendFirstTF, lastFriendNameTF, friendFirstNameTF,viewLoginUserIDTF,
	friendLastNameTF;
	private JPasswordField	userPWDTF,loginUserPWDTF,viewLoginUserPWDTF;
	private JLabel createCommentUpdateLA,eventNameValueChecker,createPriceUpdateLA,createBrandUpdateLA,createColorUpdateLA,createPriorityUpdateLA,createItemUpdateLAA,createItemUpdateLAU,createBrandUpdateLAU,createColorUpdateLAU,socialMediaLinkChecker, DOBChecker,userIDChecker,loginUserIDChecker,eventNameChecker,viewLoginUserIDChecker,userPWDChecker,eventNameCreateChecker,eventNameUpdateChecker;
	private JButton createNextB, createBackB, loginNextB, loginBackB,updtateNextB,viewLoginBackB,viewLoginNextB;
	private JComboBox bMCB, bDCB, bYCB,cDECB,sECB,cUECB;
	private JTextField createTF,userIDTF,createColorUpdateTFU,createBrandUpdateTFU,createItemUpdateTFU,createCommentUpdateTFU ,createUpdateTFU,createPriceUpdateTFU,createPriorityUpdateTFU;
	private JLabel createEventL, updateEventL,userIDL,genderLA,mobileNoLA,updateL,birthDateLA,createItemUpdateLA,createItemLA, createWishListL, updateWishListL, showWishListL, showEventL,createEventUpdateL,createPriorityUpdateL,createPriceUpdateL,createCommentUpdateL,createColorUpdateL,createBrandUpdateL,createItemUpdateL,userIDPWDLA, userIDLA,
	friendMobileNoL;
	private JTextField createEventTF, friendFirstNameTFV,friendLastNameTFV,updateEventTF, createWishListTF, updateWishListTF,createPriorityUpdateTF, showWishListTF, friendMobileTF,createPriceUpdateTF,createCommentUpdateTF,createColorUpdateTF,createBrandUpdateTF,createItemUpdateTF;
	// private JLabel firstNameChecker, lastNameChecker, genderChecker,
	// contactChecker
	private JButton customerNextB, viewFreindeNextB,customerBackB, viewNextB, viewBackB,createWishListUpdateSaveBU,createWishListBackSaveBU,createWishListSaveB,updtateCreateNextB,createWishListUpdateSaveB,createWishListUpdateBackB,createWishListUpdateBackBU;
	private JComboBox cECB, uECB, showEventCB;
	private JLabel createItemL, createBrandL,viewLoginUserPasswordL,showItemL,viewLoginUserPWDChecker, createColorL, createCommentL, createPriceL, createPriorityL; // inside the
	private JTextField createItemTF, createBrandTF, createColorTF, createCommentTF, createPriceTF, createPriorityTF;
	private JButton createWishListBackB, showEventBackB;
	private JTextArea carDetailsTA;
	private  JTable jt;


	public GiftedlView()  {
		//======= Create main Page==============//
		pane.setLayout(new CardLayout());
		mainP = new JPanel(null);
		mainP.setBackground(Color.darkGray);

		ImageIcon titleImage = new ImageIcon("images/Gifted.JPG");
		titleL = new JLabel(titleImage);
		titleL.setBounds(220, 1, 450, 500);
		mainP.add(titleL);
		ImageIcon createImage = new ImageIcon("images/friendship-image.GIF");
		titleL = new JLabel(createImage);
		titleL.setBounds(1, 180, 310, 500);
	//	mainP.add(titleL);
	//	ImageIcon createImage2 = new ImageIcon("images/Gifted.PNG");
	//	titleL = new JLabel(createImage2);
	//	titleL.setBounds(650, 150, 330, 600);
	//	mainP.add(titleL);


		mainTitleL = new JLabel("Welcome to GIFTED");
		mainTitleL.setFont(new Font("Serif", Font.BOLD, 28));
		mainTitleL.setForeground(Color.MAGENTA);
		mainTitleL.setBounds(350, 10, 350, 25);
		mainP.add(mainTitleL);
		//		

		profileC = new JLabel("Create Profile");
		profileC.setFont(new Font("Serif", Font.BOLD, 23));
		profileC.setForeground(Color.CYAN);
		profileC.setBounds(50, 80, 150, 25);
		mainP.add(profileC);
		//==========button for create profile================//
		ImageIcon mainNextImage = new ImageIcon("images/customer.GIF");
		mainNextC = new JButton(mainNextImage);
		mainNextC.setBackground(Color.BLUE);
		mainNextC.addActionListener(new mainNextButton());
		mainNextC.setBounds(70,110, 100, 50);
		mainNextC.setRolloverEnabled(true);
		mainNextC.setRolloverIcon(mainNextImage);
		mainNextC.setPressedIcon(mainNextImage);
		mainNextC.setActionCommand("nextToMenuCreateProfile");
		mainP.add(mainNextC);

		profileV = new JLabel("View Profile");
		profileV.setFont(new Font("Serif", Font.BOLD, 23));
		profileV.setForeground(Color.CYAN);
		profileV.setBounds(700, 150, 150, 25);
		mainP.add(profileV);
		//============= button for view profile============//
		ImageIcon mainNextImage1 = new ImageIcon("images/next.GIF");
		mainNextV = new JButton(mainNextImage1);
		mainNextV.setBackground(Color.BLUE);
		mainNextV.addActionListener(new mainNextButton());
		mainNextV.setBounds(720, 180, 100, 50);
		mainNextV.setRolloverEnabled(true);
		mainNextV.setRolloverIcon(mainNextImage1);
		mainNextV.setPressedIcon(mainNextImage1);
		mainNextV.setActionCommand("nextToViewProfile");
		mainP.add(mainNextV);
		pane.add(mainP, "welcomeForm");



		profileU = new JLabel("Update Profile");
		profileU.setFont(new Font("Serif", Font.BOLD, 23));
		profileU.setForeground(Color.CYAN);
		profileU.setBounds(50, 250, 150, 25);
		mainP.add(profileU);
		//============= button for view profile============//
		ImageIcon mainNextImage2 = new ImageIcon("images/next.GIF");
		mainNextU= new JButton(mainNextImage2);
		mainNextU.setBackground(Color.BLUE);
		mainNextU.addActionListener(new mainNextButton());
		mainNextU.setBounds(70, 280, 100, 50);
		mainNextU.setRolloverEnabled(true);
		mainNextU.setRolloverIcon(mainNextImage2);
		mainNextU.setPressedIcon(mainNextImage2);
		mainNextU.setActionCommand("nextToupdateProfile");
		mainP.add(mainNextU);
		pane.add(mainP, "welcomeForm");
		//=========== Create profile information-2nd Page===============//
		createP = new JPanel(null);
		createP.setBackground(Color.DARK_GRAY);

		ImageIcon createImage1 = new ImageIcon("images/friendCreate.JPG");
		// Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
		titleL = new JLabel(createImage1);
		titleL.setBounds(520, 0, 500, 500);
		createP.add(titleL);

		profileInfo = new JLabel("Enter your information");
		profileInfo.setFont(new Font("Serif", Font.BOLD, 23));
		profileInfo.setForeground(Color.CYAN);
		profileInfo.setBounds(20, 1, 250, 100);
		createP.add(profileInfo);

		firstNameL = new JLabel("First Name:");
		firstNameL.setFont(new Font("Verdana", Font.BOLD, 15));
		firstNameL.setForeground(Color.CYAN);
		firstNameL.setBounds(50, 50, 250, 100);
		createP.add(firstNameL);
		
		firstNameLA = new JLabel("*");
		firstNameLA.setFont(new Font("Verdana", Font.BOLD, 10));
		firstNameLA.setForeground(Color.red);
		firstNameLA.setBounds(150, 50, 100, 100);
		createP.add(firstNameLA);

		lastNameL = new JLabel("Last Name:");
		lastNameL.setFont(new Font("Verdana", Font.BOLD, 15));
		lastNameL.setForeground(Color.CYAN);
		lastNameL.setBounds(50, 100, 250, 100);
		createP.add(lastNameL);
		
		lastNameLA = new JLabel("*");
		lastNameLA.setFont(new Font("Verdana", Font.BOLD, 10));
		lastNameLA.setForeground(Color.red);
		lastNameLA.setBounds(150, 100, 100, 100);
		createP.add(lastNameLA);

		genderL = new JLabel("Gender:");
		genderL.setFont(new Font("Verdana", Font.BOLD, 15));
		genderL.setForeground(Color.CYAN);
		genderL.setBounds(50, 150, 250, 100);
		createP.add(genderL);
		
		genderLA = new JLabel("*");
		genderLA.setFont(new Font("Verdana", Font.BOLD, 10));
		genderLA.setForeground(Color.red);
		genderLA.setBounds(120, 150, 100, 100);
		createP.add(genderLA);

		mobileNoL = new JLabel("Mobile No:");
		mobileNoL.setFont(new Font("Verdana", Font.BOLD, 15));
		mobileNoL.setForeground(Color.CYAN);
		mobileNoL.setBounds(50, 200, 100, 100);
		createP.add(mobileNoL);
		
		mobileNoLA = new JLabel("*");
		mobileNoLA.setFont(new Font("Verdana", Font.BOLD, 10));
		mobileNoLA.setForeground(Color.red);
		mobileNoLA.setBounds(145, 200, 100, 100);
		createP.add(mobileNoLA);
		

		socialMediaL = new JLabel("Social MediaLink:");
		socialMediaL.setFont(new Font("Verdana", Font.BOLD, 15));
		socialMediaL.setForeground(Color.CYAN);
		socialMediaL.setBounds(50, 300, 150, 100);
		createP.add(socialMediaL);

		birthDateL = new JLabel("Birth Date:");
		birthDateL.setFont(new Font("Verdana", Font.BOLD, 15));
		birthDateL.setForeground(Color.CYAN);
		birthDateL.setBounds(50, 250, 100, 100);
		createP.add(birthDateL);

		birthDateLA = new JLabel("*");
		birthDateLA.setFont(new Font("Verdana", Font.BOLD, 10));
		birthDateLA.setForeground(Color.red);
		birthDateLA.setBounds(145, 250, 100, 100);
		createP.add(birthDateLA);

		String[] birthMonthCB = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		bMCB = new JComboBox(birthMonthCB);
		bMCB.setBounds(200, 290, 60, 25);
		bMCB.setToolTipText("Select month of your Birthday");
		createP.add(bMCB);

		Integer[] birthDateCB = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25, 26, 27, 28, 29, 30, 31 };
		bDCB = new JComboBox(birthDateCB);
		bDCB.setBounds(270, 290, 60, 25);
		bDCB.setToolTipText("Select Date of you Birthday");
		createP.add(bDCB);

		Integer[] birthYearCB = { 1950, 1951, 1952, 1953, 1954, 1955, 1956, 1957, 1958, 1959, 1960, 1961, 1962, 1963, 1964, 1965, 1966, 1967, 1968, 1969, 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983,
				1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000,
				2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017,
				2018, 2019, 2020};
		bYCB = new JComboBox(birthYearCB);
		bYCB.setBounds(340, 290, 60, 25);
		bYCB.setToolTipText("Select your Birth year");
		createP.add(bYCB);


		userIDL = new JLabel("UserID:");
		userIDL.setFont(new Font("Verdana", Font.BOLD, 15));
		userIDL.setForeground(Color.CYAN);
		userIDL.setBounds(50, 340, 150, 100);
		createP.add(userIDL);
		
		userIDLA = new JLabel("*");
		userIDLA.setFont(new Font("Verdana", Font.BOLD, 10));
		userIDLA.setForeground(Color.red);
		userIDLA.setBounds(120, 340, 100, 100);
		createP.add(userIDLA);
		
		
		userIDPWD = new JLabel("Password:");
		userIDPWD.setFont(new Font("Verdana", Font.BOLD, 15));
		userIDPWD.setForeground(Color.CYAN);
		userIDPWD.setBounds(50, 380, 150, 100);
		createP.add(userIDPWD);
		
		userIDPWDLA = new JLabel("*");
		userIDPWDLA.setFont(new Font("Verdana", Font.BOLD, 10));
		userIDPWDLA.setForeground(Color.red);
		userIDPWDLA.setBounds(140, 380, 100, 100);
		createP.add(userIDPWDLA);

		// -----------------------------------------------------------------------------//
		nameFirstTF = new JTextField("");
		nameFirstTF.setVisible(true);
		nameFirstTF.setToolTipText("Enter your firstname");
		nameFirstTF.setHorizontalAlignment(JTextField.CENTER);
		nameFirstTF.setForeground(Color.GRAY);
		nameFirstTF.setBounds(200, 90, 250, 30);
		createP.add(nameFirstTF);

		lastNameTF = new JTextField("");
		lastNameTF.setVisible(true);
		lastNameTF.setToolTipText("Enter your lastname");
		lastNameTF.setHorizontalAlignment(JTextField.CENTER);
		lastNameTF.setForeground(Color.GRAY);
		lastNameTF.setBounds(200, 140, 250, 30);
		createP.add(lastNameTF);

		genderTF = new JTextField("");
		genderTF.setVisible(true);
		genderTF.setToolTipText("Enter your Gender");
		genderTF.setHorizontalAlignment(JTextField.CENTER);
		genderTF.setForeground(Color.GRAY);
		genderTF.setBounds(200, 190, 50, 30);
		createP.add(genderTF);

		mobileNoTF = new JTextField("");
		mobileNoTF.setVisible(true);
		mobileNoTF.setToolTipText("Enter your mobile number here");
		mobileNoTF.setHorizontalAlignment(JTextField.CENTER);
		mobileNoTF.setForeground(Color.GRAY);
		mobileNoTF.setBounds(200, 240, 250, 30);
		createP.add(mobileNoTF);

		socialMediaTF = new JTextField("");
		socialMediaTF.setVisible(true);
		socialMediaTF.setToolTipText("Enter your social media link here");
		socialMediaTF.setHorizontalAlignment(JTextField.CENTER);
		socialMediaTF.setForeground(Color.GRAY);
		socialMediaTF.setBounds(200, 340, 250, 30);
		createP.add(socialMediaTF);

		userIDTF = new JTextField("");
		userIDTF.setVisible(true);
		userIDTF.setToolTipText("Enter your user id here, It should be unique-alphanumeric");
		userIDTF.setHorizontalAlignment(JTextField.CENTER);
		userIDTF.setForeground(Color.GRAY);
		userIDTF.setBounds(200, 380, 250, 30);
		createP.add(userIDTF);
		
		userPWDTF = new JPasswordField(15);
		userPWDTF.setVisible(true);
		userPWDTF.setToolTipText("Enter your password here, It should be unique-alphanumeric");
		userPWDTF.setHorizontalAlignment(JTextField.CENTER);
		userPWDTF.setForeground(Color.GRAY);
		userPWDTF.setBounds(200, 420, 250, 30);
		createP.add(userPWDTF);

		pane.add(createP, "createProfileDetailForm");
		//=============data=============//
		firstNameChecker = new JLabel("");
		firstNameChecker.setFont(new Font("Serif", Font.BOLD, 14));
		firstNameChecker.setBounds(460, 50, 100, 100);
		createP.add(firstNameChecker);

		lastNameChecker = new JLabel("");
		lastNameChecker.setFont(new Font("Serif", Font.BOLD, 14));
		lastNameChecker.setBounds(460, 100, 100, 100);
		createP.add(lastNameChecker);

		genderChecker = new JLabel("");
		genderChecker.setFont(new Font("Serif", Font.BOLD, 14));
		genderChecker.setBounds(460, 150, 100, 100);
		createP.add(genderChecker);

		contactChecker = new JLabel("");
		contactChecker.setFont(new Font("Serif", Font.BOLD, 14));
		contactChecker.setBounds(460, 200, 100, 100);
		createP.add(contactChecker);

		DOBChecker = new JLabel("");
		DOBChecker.setFont(new Font("Serif", Font.BOLD, 14));
		DOBChecker.setBounds(460, 250, 100, 100);
		createP.add(DOBChecker);

		socialMediaLinkChecker = new JLabel("");
		socialMediaLinkChecker.setFont(new Font("Serif", Font.BOLD, 14));
		socialMediaLinkChecker.setBounds(460, 300, 100, 100);
		createP.add(socialMediaLinkChecker);

		userIDChecker = new JLabel("");
		userIDChecker.setFont(new Font("Serif", Font.BOLD, 14));
		userIDChecker.setBounds(460, 340, 100, 100);
		createP.add(userIDChecker);
		
		userPWDChecker = new JLabel("");
		userPWDChecker.setFont(new Font("Serif", Font.BOLD, 14));
		userPWDChecker.setBounds(460, 380, 100, 100);
		createP.add(userPWDChecker);
		
		//=============create event page==================//
		ImageIcon dateNextImage = new ImageIcon("images/create.GIF");
		createNextB = new JButton(dateNextImage);
		createNextB.setBackground(Color.GREEN);
		createNextB.addActionListener(new createNextButton());
		createNextB.setBounds(550, 500, 100, 50);
		createNextB.setActionCommand("nextToCreateProfile");
		createP.add(createNextB);
		createNextB.setToolTipText("NEXT");
		// =========to go back welcome section====//
		ImageIcon dateBackImage = new ImageIcon("images/back.GIF");
		createBackB = new JButton(dateBackImage);
		createBackB.setBackground(Color.GREEN);
		createBackB.setBounds(380, 500, 100, 50);
		createBackB.addActionListener(new createBackButton());
		createBackB.setActionCommand("backToWelcomeForm");
		createBackB.setToolTipText("BACK");
		createP.add(createBackB);
		pane.add(createP, "createProfileDetailForm");

		//==================create event page===============//
		createEventP = new JPanel(null);
		createEventP.setBackground(Color.DARK_GRAY);

		friendProfileInfo = new JLabel("Freindlist:");
		friendProfileInfo.setFont(new Font("Serif", Font.BOLD, 22));
		friendProfileInfo.setForeground(Color.CYAN);
		friendProfileInfo.setBounds(150, 1, 350, 100);
		createEventP.add(friendProfileInfo);

		friendFirstNameL = new JLabel("Friend's FirstName:");
		friendFirstNameL.setFont(new Font("Verdana", Font.BOLD, 15));
		friendFirstNameL.setForeground(Color.CYAN);
		friendFirstNameL.setBounds(50, 50, 250, 100);
		createEventP.add(friendFirstNameL);

		friendLastNameL = new JLabel("Friend's LastName:");
		friendLastNameL.setFont(new Font("Verdana", Font.BOLD, 15));
		friendLastNameL.setForeground(Color.CYAN);
		friendLastNameL.setBounds(50, 100, 250, 100);
		createEventP.add(friendLastNameL);

		friendMobileNoL = new JLabel("Friend's Mobile No:");
		friendMobileNoL.setFont(new Font("Verdana", Font.BOLD, 15));
		friendMobileNoL.setForeground(Color.CYAN);
		friendMobileNoL.setBounds(50, 150, 250, 100);
		createEventP.add(friendMobileNoL);

		createEventL = new JLabel("Create Event:");
		createEventL.setFont(new Font("Serif", Font.BOLD, 23));
		createEventL.setForeground(Color.CYAN);
		createEventL.setBounds(550, 1, 250, 100);
		createEventP.add(createEventL);

		String[] createEventCB = {};
		cECB=new JComboBox(createEventCB);
		cECB.setBounds(550, 90, 250, 30);
		try {
			String url = "jdbc:mysql://localhost:3306/gifted_project";
			String userName = "root";
			String password = "root";
			String sql= "select eventName from createevent";
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement st = con.createStatement();
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {
				String eventNameText=rs.getString("eventName");
				cECB.addItem(eventNameText);
			}
			st.close();
			con.close();
		}catch (Exception e) {
		}


		//	cECB.setToolTipText("Select month of your Birthday");
		createEventP.add(cECB);

		friendFirstNameTF = new JTextField("");
		friendFirstNameTF.setVisible(true);
		friendFirstNameTF.setToolTipText("Enter your friend's firstName");
		friendFirstNameTF.setHorizontalAlignment(JTextField.CENTER);
		friendFirstNameTF.setForeground(Color.GRAY);
		friendFirstNameTF.setBounds(230, 90, 250, 30);
		createEventP.add(friendFirstNameTF);

		friendLastNameTF = new JTextField("");
		friendLastNameTF.setVisible(true);
		friendLastNameTF.setToolTipText("Enter your friend's LastName");
		friendLastNameTF.setHorizontalAlignment(JTextField.CENTER);
		friendLastNameTF.setForeground(Color.GRAY);
		friendLastNameTF.setBounds(230, 140, 250, 30);
		createEventP.add(friendLastNameTF);

		friendMobileTF = new JTextField("");
		friendMobileTF.setVisible(true);
		friendMobileTF.setToolTipText("Enter your friend's mobileNo");
		friendMobileTF.setHorizontalAlignment(JTextField.CENTER);
		friendMobileTF.setForeground(Color.GRAY);
		friendMobileTF.setBounds(230, 190, 250, 30);
		createEventP.add(friendMobileTF);
		pane.add(createEventP, "createEventForm");
		// ==================BUTTONS for wishList section===========//

		ImageIcon createEventNextImage = new ImageIcon("images/create.GIF");
		customerNextB = new JButton(createEventNextImage);
		customerNextB.setBackground(Color.GREEN);
		customerNextB.setBounds(550, 300, 100, 50);
		customerNextB.setRolloverEnabled(true);
		customerNextB.setRolloverIcon(createEventNextImage);
		customerNextB.setPressedIcon(createEventNextImage);
		customerNextB.addActionListener(new createEventNextButton());
		customerNextB.setActionCommand("nextToCreateEvent");
		createEventP.add(customerNextB);
		customerNextB.setToolTipText("NEXT WISHLIST");

		//=========back to Create event page===========================//
		ImageIcon createEventBackImage = new ImageIcon("images/customer_back.GIF");
		customerBackB = new JButton(createEventBackImage);
		customerBackB.setBackground(Color.GREEN);
		customerBackB.setBounds(350, 300, 100, 50);
		customerBackB.setRolloverEnabled(true);
		customerBackB.setRolloverIcon(createEventBackImage);
		customerBackB.setPressedIcon(createEventBackImage);
		customerBackB.addActionListener(new createEventBackButton());
		customerBackB.setActionCommand("backToCreateProfile");
		createEventP.add(customerBackB);
		customerBackB.setToolTipText("BACK");
		pane.add(createEventP, "createEventForm");
//====================================================================================
		createWishListP = new JPanel(null);
		createWishListP.setBackground(Color.DARK_GRAY);
		ImageIcon createImageWishList = new ImageIcon("images/WishList.JPG");
		titleL = new JLabel(createImageWishList);
		titleL.setBounds(520, 0, 500, 600);
		createWishListP.add(titleL);
		
		createWishListInfoL = new JLabel("Wishlist information");
		createWishListInfoL.setFont(new Font("Serif", Font.BOLD, 18));
		createWishListInfoL.setForeground(Color.CYAN);
		createWishListInfoL.setBounds(20, 1, 250, 100);
		createP.add(createWishListInfoL);
		
		createItemL = new JLabel("Create Item:");
		createItemL.setFont(new Font("Verdana", Font.BOLD, 15));
		createItemL.setForeground(Color.CYAN);
		createItemL.setBounds(50, 1, 250, 100);
		createWishListP.add(createItemL);
		
		createItemLA = new JLabel("*");
		createItemLA.setFont(new Font("Verdana", Font.BOLD, 10));
		createItemLA.setForeground(Color.RED);
		createItemLA.setBounds(160, 1, 250, 100);
		createWishListP.add(createItemLA);

		createBrandL = new JLabel("Create Brand:");
		createBrandL.setFont(new Font("Verdana", Font.BOLD, 15));
		createBrandL.setForeground(Color.CYAN);
		createBrandL.setBounds(50, 50, 250, 100);
		createWishListP.add(createBrandL);

		createColorL = new JLabel("Create Color:");
		createColorL.setFont(new Font("Verdana", Font.BOLD, 15));
		createColorL.setForeground(Color.CYAN);
		createColorL.setBounds(50, 100, 250, 100);
		createWishListP.add(createColorL);

		createCommentL = new JLabel("Create Comment:");
		createCommentL.setFont(new Font("Verdana", Font.BOLD, 15));
		createCommentL.setForeground(Color.CYAN);
		createCommentL.setBounds(50, 150, 250, 100);
		createWishListP.add(createCommentL);

		createPriceL = new JLabel("Create price:");
		createPriceL.setFont(new Font("Verdana", Font.BOLD, 15));
		createPriceL.setForeground(Color.CYAN);
		createPriceL.setBounds(50, 200, 250, 100);
		createWishListP.add(createPriceL);

		createPriorityL = new JLabel("Create Priority:");
		createPriorityL.setFont(new Font("Verdana", Font.BOLD, 15));
		createPriorityL.setForeground(Color.CYAN);
		createPriorityL.setBounds(50, 250, 250, 100);
		createWishListP.add(createPriorityL);

		createItemTF = new JTextField(null);
		createItemTF.setHorizontalAlignment(JTextField.CENTER);
		createItemTF.setToolTipText("Enter the item name you wish to buy");
		createItemTF.setForeground(Color.GRAY);
		createItemTF.setBounds(250, 40, 250, 30);
		createWishListP.add(createItemTF);

		createBrandTF = new JTextField("");
		createBrandTF.setHorizontalAlignment(JTextField.CENTER);
		createBrandTF.setToolTipText("Enter the preferred brand");
		createBrandTF.setForeground(Color.GRAY);
		createBrandTF.setBounds(250, 90, 250, 30);
		createWishListP.add(createBrandTF);

		createColorTF = new JTextField(""); 
		createColorTF.setHorizontalAlignment(JTextField.CENTER);
		createColorTF.setToolTipText("Enter the preferred color of the item");
		createColorTF.setForeground(Color.GRAY);
		createColorTF.setBounds(250, 140, 250, 30);
		createWishListP.add(createColorTF);

		createCommentTF = new JTextField("");
		createCommentTF.setHorizontalAlignment(JTextField.CENTER);
		createCommentTF.setToolTipText("If you wish to add some more details about the item");
		createCommentTF.setForeground(Color.GRAY);
		createCommentTF.setBounds(250, 190, 250, 30);
		createWishListP.add(createCommentTF);

		createPriceTF = new JTextField(""); 
		createPriceTF.setHorizontalAlignment(JTextField.CENTER);
		createPriceTF.setToolTipText("Price of the item");
		createPriceTF.setForeground(Color.GRAY);
		createPriceTF.setBounds(250, 240, 250, 30);
		createWishListP.add(createPriceTF);

		createPriorityTF = new JTextField("");
		createPriorityTF.setHorizontalAlignment(JTextField.CENTER);
		createPriorityTF.setToolTipText("Priority you wish to give to the item");
		createPriorityTF.setForeground(Color.GRAY);
		createPriorityTF.setBounds(250, 290, 250, 30);
		createWishListP.add(createPriorityTF);
		pane.add(createWishListP, "createWishListForm");

		ImageIcon createWishListBackImage = new ImageIcon("images/customer_back.GIF");
		createWishListBackB = new JButton(createWishListBackImage);
		createWishListBackB.setBackground(Color.GREEN);
		createWishListBackB.setBounds(130, 400, 100, 50);
		createWishListBackB.setRolloverEnabled(true);
		createWishListBackB.setRolloverIcon(createWishListBackImage);
		createWishListBackB.setPressedIcon(createWishListBackImage);
		createWishListBackB.addActionListener(new createWishListBackButton());
		createWishListBackB.setActionCommand("backToCreateEvent");
		createWishListP.add(createWishListBackB);
		createWishListBackB.setToolTipText("NEXT");
		pane.add(createWishListP, "createWishListForm");

		ImageIcon wishListSavekImage = new ImageIcon("images/create.GIF");
		createWishListSaveB = new JButton(wishListSavekImage);
		createWishListSaveB.setBackground(Color.GREEN);
		createWishListSaveB.setBounds(330, 400, 100, 50);
		createWishListSaveB.setRolloverEnabled(true);
		createWishListSaveB.setRolloverIcon(wishListSavekImage);
		createWishListSaveB.setPressedIcon(wishListSavekImage);
		createWishListSaveB.addActionListener(new wishListSaveButton());
		createWishListSaveB.setActionCommand("saveWishlist");
		createWishListSaveB.setToolTipText("SAVE");
		createWishListP.add(createWishListSaveB);
		//pane.add(createWishListP, "createWishListForm");
//=============================updateProfile create wishlist==================================
		createWishListUpdateProfileP = new JPanel(null);
		createWishListUpdateProfileP.setBackground(Color.DARK_GRAY);

		createItemUpdateL = new JLabel("Create Item:");
		createItemUpdateL.setFont(new Font("Verdana", Font.BOLD, 15));
		createItemUpdateL.setForeground(Color.CYAN);
		createItemUpdateL.setBounds(50, 1, 250, 100);
		createWishListUpdateProfileP.add(createItemUpdateL);
		
		createItemUpdateLA = new JLabel("*");
		createItemUpdateLA.setFont(new Font("Verdana", Font.BOLD, 10));
		createItemUpdateLA.setForeground(Color.RED);
		createItemUpdateLA.setBounds(160, 1, 250, 100);
		createWishListUpdateProfileP.add(createItemUpdateLA);

		createBrandUpdateL = new JLabel("Create Brand:");
		createBrandUpdateL.setFont(new Font("Verdana", Font.BOLD, 15));
		createBrandUpdateL.setForeground(Color.CYAN);
		createBrandUpdateL.setBounds(50, 50, 250, 100);
		createWishListUpdateProfileP.add(createBrandUpdateL);

		createColorUpdateL = new JLabel("Create Color:");
		createColorUpdateL .setFont(new Font("Verdana", Font.BOLD, 15));
		createColorUpdateL .setForeground(Color.CYAN);
		createColorUpdateL .setBounds(50, 100, 250, 100);
		createWishListUpdateProfileP.add(createColorUpdateL );

		createCommentUpdateL = new JLabel("Create Comment:");
		createCommentUpdateL.setFont(new Font("Verdana", Font.BOLD, 15));
		createCommentUpdateL.setForeground(Color.CYAN);
		createCommentUpdateL.setBounds(50, 150, 250, 100);
		createWishListUpdateProfileP.add(createCommentUpdateL);

		createPriceUpdateL = new JLabel("Create price:");
		createPriceUpdateL.setFont(new Font("Verdana", Font.BOLD, 15));
		createPriceUpdateL.setForeground(Color.CYAN);
		createPriceUpdateL.setBounds(50, 200, 250, 100);
		createWishListUpdateProfileP.add(createPriceUpdateL);

		createPriorityUpdateL = new JLabel("Create Priority:");
		createPriorityUpdateL.setFont(new Font("Verdana", Font.BOLD, 15));
		createPriorityUpdateL.setForeground(Color.CYAN);
		createPriorityUpdateL.setBounds(50, 250, 250, 100);
		createWishListUpdateProfileP.add(createPriorityUpdateL);

		createItemUpdateTF = new JTextField("");
		createItemUpdateTF.setHorizontalAlignment(JTextField.CENTER);
		createItemUpdateTF.setToolTipText("Enter the item name you wish to buy");
		createItemUpdateTF.setForeground(Color.GRAY);
		createItemUpdateTF.setBounds(250, 40, 250, 30);
		createWishListUpdateProfileP.add(createItemUpdateTF);

		createBrandUpdateTF = new JTextField("");
		createBrandUpdateTF.setHorizontalAlignment(JTextField.CENTER);
		createBrandUpdateTF.setToolTipText("Enter the preferred brand");
		createBrandUpdateTF.setForeground(Color.GRAY);
		createBrandUpdateTF.setBounds(250, 90, 250, 30);
		createWishListUpdateProfileP.add(createBrandUpdateTF);

		createColorUpdateTF = new JTextField(""); 
		createColorUpdateTF.setHorizontalAlignment(JTextField.CENTER);
		createColorUpdateTF.setToolTipText("Enter the preferred color of the item");
		createColorUpdateTF.setForeground(Color.GRAY);
		createColorUpdateTF.setBounds(250, 140, 250, 30);
		createWishListUpdateProfileP.add(createColorUpdateTF);

		createCommentUpdateTF = new JTextField("");
		createCommentUpdateTF.setHorizontalAlignment(JTextField.CENTER);
		createCommentUpdateTF.setToolTipText("If you wish to add some more details about the item");
		createCommentUpdateTF.setForeground(Color.GRAY);
		createCommentUpdateTF.setBounds(250, 190, 250, 30);
		createWishListUpdateProfileP.add(createCommentUpdateTF);

		createPriceUpdateTF = new JTextField(""); 
		createPriceUpdateTF.setHorizontalAlignment(JTextField.CENTER);
		createPriceUpdateTF.setToolTipText("Price of the item");
		createPriceUpdateTF.setForeground(Color.GRAY);
		createPriceUpdateTF.setBounds(250, 240, 250, 30);
		createWishListUpdateProfileP.add(createPriceUpdateTF);

		createPriorityUpdateTF = new JTextField("");
		createPriorityUpdateTF.setHorizontalAlignment(JTextField.CENTER);
		createPriorityUpdateTF.setToolTipText("Priority you wish to give to the item");
		createPriorityUpdateTF.setForeground(Color.GRAY);
		createPriorityUpdateTF.setBounds(250, 290, 250, 30);
		createWishListUpdateProfileP.add(createPriorityUpdateTF);
		pane.add(createWishListUpdateProfileP, "createWishListUpdateProfileForm");

		ImageIcon createWishListBackImage11 = new ImageIcon("images/customer_back.GIF");
		createWishListUpdateBackB = new JButton(createWishListBackImage11);
		createWishListUpdateBackB.setBackground(Color.GREEN);
		createWishListUpdateBackB.setBounds(330, 400, 100, 50);
		createWishListUpdateBackB.setRolloverEnabled(true);
		createWishListUpdateBackB.setRolloverIcon(createWishListBackImage11);
		createWishListUpdateBackB.setPressedIcon(createWishListBackImage11);
		createWishListUpdateBackB.addActionListener(new createWishListUpdateBackButton());
		createWishListUpdateBackB.setActionCommand("backToCreateEvent");
		createWishListUpdateProfileP.add(createWishListUpdateBackB);
		createWishListUpdateProfileP.setToolTipText("BACK");
		pane.add(createWishListUpdateProfileP, "createWishListUpdateProfileForm");

		ImageIcon wishListSavekImage1 = new ImageIcon("images/create.GIF");
		createWishListUpdateSaveB = new JButton(wishListSavekImage1);
		createWishListUpdateSaveB.setBackground(Color.GREEN);
		createWishListUpdateSaveB.setBounds(530, 400, 100, 50);
		createWishListUpdateSaveB.setRolloverEnabled(true);
		createWishListUpdateSaveB.setRolloverIcon(wishListSavekImage1);
		createWishListUpdateSaveB.setPressedIcon(wishListSavekImage1);
		createWishListUpdateSaveB.addActionListener(new wishListUpdateSaveButton());
		createWishListUpdateSaveB.setActionCommand("saveWishlistUpdateProfile");
		createWishListUpdateSaveB.setToolTipText("SAVE");
		createWishListUpdateProfileP.add(createWishListUpdateSaveB);
		//pane.add(createWishListUpdateProfileP, "createWishListForm");

		// view profile details==========//
		loginP = new JPanel(null);
		loginP.setBackground(Color.DARK_GRAY);

		loginUsernameL = new JLabel("UserID:");
		loginUsernameL.setFont(new Font("Verdana", Font.BOLD, 15));
		loginUsernameL.setForeground(Color.CYAN);
		loginUsernameL.setBounds(50, 1, 250, 100);
		loginP.add(loginUsernameL);
		
		loginUserPasswordL = new JLabel("Password:");
		loginUserPasswordL.setFont(new Font("Verdana", Font.BOLD, 15));
		loginUserPasswordL.setForeground(Color.CYAN);
		loginUserPasswordL.setBounds(50, 50, 250, 100);
		loginP.add(loginUserPasswordL);

		loginUserIDTF = new JTextField(""); 
		loginUserIDTF.setHorizontalAlignment(JTextField.CENTER);
		loginUserIDTF.setToolTipText("Enter your userid");
		loginUserIDTF.setForeground(Color.GRAY);
		loginUserIDTF.setBounds(300, 40, 250, 30);
		loginP.add(loginUserIDTF);
		
	    loginUserPWDTF= new JPasswordField(15);
		loginUserPWDTF.setVisible(true);
		loginUserPWDTF.setHorizontalAlignment(JTextField.CENTER);
		loginUserPWDTF.setToolTipText("Enter your passwod");
		loginUserPWDTF.setForeground(Color.GRAY);
		loginUserPWDTF.setBounds(300, 80, 250, 30);
		loginP.add(loginUserPWDTF);
		
		pane.add(loginP, "updateLoginForm");
		
		loginUserIDChecker=new JLabel("");
		loginUserIDChecker.setFont(new Font("Serif", Font.BOLD, 16));
		loginUserIDChecker.setBounds(320, 100, 500, 100);
		loginP.add(loginUserIDChecker);
		
		
		loginUserPWDChecker=new JLabel("");
		loginUserPWDChecker.setFont(new Font("Serif", Font.BOLD, 16));
		loginUserPWDChecker.setBounds(320, 250, 500, 100);
		loginP.add(loginUserPWDChecker);
		
		//===========Login page next button=============//
		ImageIcon loginNextImage = new ImageIcon("images/create.GIF");
		loginNextB = new JButton(loginNextImage);
		loginNextB.setBackground(Color.GREEN);
		loginNextB.setBounds(550, 200, 100, 50);
		loginNextB.setRolloverEnabled(true);
		loginNextB.setRolloverIcon(loginNextImage);
		loginNextB.setPressedIcon(loginNextImage);
		loginNextB.addActionListener(new loginNextButton());
		loginNextB.setActionCommand("nextToCreateLogin");
		loginP.add(loginNextB);
		loginNextB.setToolTipText("NEXT");

		//============bcak to login page==================//
		ImageIcon loginBackImage = new ImageIcon("images/customer_back.GIF");
		loginBackB = new JButton(loginBackImage);
		loginBackB.setBackground(Color.GREEN);
		loginBackB.setBounds(350, 200, 100, 50);
		loginBackB.setRolloverEnabled(true);
		loginBackB.setRolloverIcon(loginBackImage);
		loginBackB.setPressedIcon(loginBackImage);
		loginBackB.addActionListener(new loginBackButton());
		loginBackB.setActionCommand("backToLogin");
		loginP.add(loginBackB);
		loginBackB.setToolTipText("BACK");

		pane.add(loginP, "updateLoginForm");
		//======================================//
		viewLoginP = new JPanel(null);
		viewLoginP.setBackground(Color.DARK_GRAY);

		viewLoginUsernameL = new JLabel("UserID:");
		viewLoginUsernameL.setFont(new Font("Verdana", Font.BOLD, 15));
		viewLoginUsernameL.setForeground(Color.CYAN);
		viewLoginUsernameL.setBounds(50, 1, 250, 100);
		viewLoginP.add(viewLoginUsernameL);

		
		viewLoginUserPasswordL = new JLabel("Password:");
		viewLoginUserPasswordL.setFont(new Font("Verdana", Font.BOLD, 15));
		viewLoginUserPasswordL.setForeground(Color.CYAN);
		viewLoginUserPasswordL.setBounds(50, 50, 250, 100);
		viewLoginP.add(viewLoginUserPasswordL);
		
		viewLoginUserIDTF = new JTextField(""); 
		viewLoginUserIDTF.setHorizontalAlignment(JTextField.CENTER);
		viewLoginUserIDTF.setToolTipText("Enter your userid");
		viewLoginUserIDTF.setForeground(Color.GRAY);
		viewLoginUserIDTF.setBounds(300, 40, 250, 30);
		viewLoginP.add(viewLoginUserIDTF);
		
	    viewLoginUserPWDTF= new JPasswordField(15);
	    viewLoginUserPWDTF.setVisible(true);
	    viewLoginUserPWDTF.setHorizontalAlignment(JTextField.CENTER);
	    viewLoginUserPWDTF.setToolTipText("Enter your passwod");
	    viewLoginUserPWDTF.setForeground(Color.GRAY);
	    viewLoginUserPWDTF.setBounds(300, 80, 250, 30);
		viewLoginP.add(viewLoginUserPWDTF);
		

		pane.add(viewLoginP, "viewLoginForm");
		
		viewLoginUserIDChecker=new JLabel("");
		viewLoginUserIDChecker.setFont(new Font("Serif", Font.BOLD, 16));
		viewLoginUserIDChecker.setBounds(320, 100, 500, 100);
		viewLoginP.add(viewLoginUserIDChecker);
		
		viewLoginUserPWDChecker=new JLabel("");
		viewLoginUserPWDChecker.setFont(new Font("Serif", Font.BOLD, 16));
		viewLoginUserPWDChecker.setBounds(320, 250, 500, 100);
		loginP.add(viewLoginUserPWDChecker);
		
		//===========Login page next button=============//
		ImageIcon viewLoginNextImage = new ImageIcon("images/create.GIF");
		viewLoginNextB = new JButton(viewLoginNextImage);
		viewLoginNextB.setBackground(Color.GREEN);
		viewLoginNextB.setBounds(550, 200, 100, 50);
		viewLoginNextB.setRolloverEnabled(true);
		viewLoginNextB.setRolloverIcon(viewLoginNextImage);
		viewLoginNextB.setPressedIcon(viewLoginNextImage);
		viewLoginNextB.addActionListener(new viewLoginNextButton());
		viewLoginNextB.setActionCommand("nextToViewProfileLogin");
		viewLoginP.add(viewLoginNextB);
		viewLoginNextB.setToolTipText("NEXT");

		//============bcak to login page==================//
		ImageIcon viewLoginBackImage = new ImageIcon("images/customer_back.GIF");
		viewLoginBackB = new JButton(viewLoginBackImage );
		viewLoginBackB.setBackground(Color.GREEN);
		viewLoginBackB.setBounds(350, 200, 100, 50);
		viewLoginBackB.setRolloverEnabled(true);
		viewLoginBackB.setRolloverIcon(viewLoginBackImage );
		viewLoginBackB.setPressedIcon(viewLoginBackImage );
		viewLoginBackB.addActionListener(new viewLoginBackButton());
		viewLoginBackB.setActionCommand("backToLogin");
		viewLoginP.add(viewLoginBackB);
		viewLoginBackB.setToolTipText("BACK");
		pane.add(viewLoginP, "viewLoginForm");
		//======================================//
		createWishListUpdateProfileU = new JPanel(null);
		createWishListUpdateProfileU.setBackground(Color.DARK_GRAY);

		createItemUpdateLAU = new JLabel("Update Item:");
		createItemUpdateLAU.setFont(new Font("Verdana", Font.BOLD, 15));
		createItemUpdateLAU.setForeground(Color.CYAN);
		createItemUpdateLAU.setBounds(50, 1, 250, 100);
		createWishListUpdateProfileU.add(createItemUpdateLAU);
		
		createItemUpdateLAA = new JLabel("*");
		createItemUpdateLAA.setFont(new Font("Verdana", Font.BOLD, 10));
		createItemUpdateLAA.setForeground(Color.RED);
		createItemUpdateLAA.setBounds(165, 1, 250, 100);
		createWishListUpdateProfileU.add(createItemUpdateLAA);

		createBrandUpdateLA = new JLabel("Update Brand:");
		createBrandUpdateLA.setFont(new Font("Verdana", Font.BOLD, 15));
		createBrandUpdateLA.setForeground(Color.CYAN);
		createBrandUpdateLA.setBounds(50, 50, 250, 100);
		createWishListUpdateProfileU.add(createBrandUpdateLA);

		createColorUpdateLA = new JLabel("Update Color:");
		createColorUpdateLA .setFont(new Font("Verdana", Font.BOLD, 15));
		createColorUpdateLA .setForeground(Color.CYAN);
		createColorUpdateLA .setBounds(50, 100, 250, 100);
		createWishListUpdateProfileU.add(createColorUpdateLA );

		createCommentUpdateLA = new JLabel("Update Comment:");
		createCommentUpdateLA.setFont(new Font("Verdana", Font.BOLD, 15));
		createCommentUpdateLA.setForeground(Color.CYAN);
		createCommentUpdateLA.setBounds(50, 150, 250, 100);
		createWishListUpdateProfileU.add(createCommentUpdateLA);

		createPriceUpdateLA = new JLabel("Update price:");
		createPriceUpdateLA.setFont(new Font("Verdana", Font.BOLD, 15));
		createPriceUpdateLA.setForeground(Color.CYAN);
		createPriceUpdateLA.setBounds(50, 200, 250, 100);
		createWishListUpdateProfileU.add(createPriceUpdateLA);

		createPriorityUpdateLA = new JLabel("Update Priority:");
		createPriorityUpdateLA.setFont(new Font("Verdana", Font.BOLD, 15));
		createPriorityUpdateLA.setForeground(Color.CYAN);
		createPriorityUpdateLA.setBounds(50, 250, 250, 100);
		createWishListUpdateProfileU.add(createPriorityUpdateLA);

		createItemUpdateTFU = new JTextField("");
		createItemUpdateTFU.setHorizontalAlignment(JTextField.CENTER);
		createItemUpdateTFU.setToolTipText("Enter the item name you wish to buy");
		createItemUpdateTFU.setForeground(Color.GRAY);
		createItemUpdateTFU.setBounds(250, 40, 250, 30);
		createWishListUpdateProfileU.add(createItemUpdateTFU);

		createBrandUpdateTFU = new JTextField("");
		createBrandUpdateTFU.setHorizontalAlignment(JTextField.CENTER);
		createBrandUpdateTFU.setToolTipText("Enter the preferred brand");
		createBrandUpdateTFU.setForeground(Color.GRAY);
		createBrandUpdateTFU.setBounds(250, 90, 250, 30);
		createWishListUpdateProfileU.add(createBrandUpdateTFU);

		createColorUpdateTFU = new JTextField(""); 
		createColorUpdateTFU.setHorizontalAlignment(JTextField.CENTER);
		createColorUpdateTFU.setToolTipText("Enter the preferred color of the item");
		createColorUpdateTFU.setForeground(Color.GRAY);
		createColorUpdateTFU.setBounds(250, 140, 250, 30);
		createWishListUpdateProfileU.add(createColorUpdateTFU);

		createCommentUpdateTFU = new JTextField("");
		createCommentUpdateTFU.setHorizontalAlignment(JTextField.CENTER);
		createCommentUpdateTFU.setToolTipText("If you wish to add some more details about the item");
		createCommentUpdateTFU.setForeground(Color.GRAY);
		createCommentUpdateTFU.setBounds(250, 190, 250, 30);
		createWishListUpdateProfileU.add(createCommentUpdateTFU);

		createPriceUpdateTFU = new JTextField(""); 
		createPriceUpdateTFU.setHorizontalAlignment(JTextField.CENTER);
		createPriceUpdateTFU.setToolTipText("Price of the item");
		createPriceUpdateTFU.setForeground(Color.GRAY);
		createPriceUpdateTFU.setBounds(250, 240, 250, 30);
		createWishListUpdateProfileU.add(createPriceUpdateTFU);

		createPriorityUpdateTFU = new JTextField("");
		createPriorityUpdateTFU.setHorizontalAlignment(JTextField.CENTER);
		createPriorityUpdateTFU.setToolTipText("Priority you wish to give to the item");
		createPriorityUpdateTFU.setForeground(Color.GRAY);
		createPriorityUpdateTFU.setBounds(250, 290, 250, 30);
		createWishListUpdateProfileU.add(createPriorityUpdateTFU);
		pane.add(createWishListUpdateProfileU, "createWishListUpdateUpdateProfileForm");

		ImageIcon createWishListBackImage2 = new ImageIcon("images/customer_back.GIF");
		createWishListUpdateBackBU = new JButton(createWishListBackImage2);
		createWishListUpdateBackBU.setBackground(Color.GREEN);
		createWishListUpdateBackBU.setBounds(330, 400, 100, 50);
		createWishListUpdateBackBU.setRolloverEnabled(true);
		createWishListUpdateBackBU.setRolloverIcon(createWishListBackImage2);
		createWishListUpdateBackBU.setPressedIcon(createWishListBackImage2);
		createWishListUpdateBackBU.addActionListener(new createWishListUpdateUpdateBackButton());
		createWishListUpdateBackBU.setActionCommand("backToCreateEvent");
		createWishListUpdateProfileU.add(createWishListUpdateBackBU);
		createWishListUpdateProfileU.setToolTipText("BACK");
		pane.add(createWishListUpdateProfileU, "createWishListUpdateUpdateProfileForm");

		ImageIcon wishListSavekImage2 = new ImageIcon("images/create.GIF");
		createWishListUpdateSaveBU = new JButton(wishListSavekImage2);
		createWishListUpdateSaveBU.setBackground(Color.GREEN);
		createWishListUpdateSaveBU.setBounds(530, 400, 100, 50);
		createWishListUpdateSaveBU.setRolloverEnabled(true);
		createWishListUpdateSaveBU.setRolloverIcon(wishListSavekImage2);
		createWishListUpdateSaveBU.setPressedIcon(wishListSavekImage2);
		createWishListUpdateSaveBU.addActionListener(new wishListUpdateUpdateSaveButton());
		createWishListUpdateSaveBU.setActionCommand("updateWishListList");
		createWishListUpdateSaveBU.setToolTipText("SAVE");
		createWishListUpdateProfileU.add(createWishListUpdateSaveBU);
		//pane.add(createWishListUpdateProfileP, "createWishListForm");
		
		//==================================================//
		updateP = new JPanel(null);
		updateP.setBackground(Color.DARK_GRAY);
//		ImageIcon imageUpdateProfile = new ImageIcon("images/updateProfile1.JPG");
//		// Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
//		updateL = new JLabel(imageUpdateProfile);
//		updateL.setBounds(280, 0, 800, 575);
//		updateP.add(updateL);

		updateEventL = new JLabel(" Update your profile");
		updateEventL.setFont(new Font("Serif", Font.BOLD, 26));
		updateEventL.setForeground(Color.CYAN);
		updateEventL.setBounds(350, 1, 250, 100);
		updateP.add(updateEventL);

		showEventL = new JLabel(" Update Existing Event");
		showEventL.setFont(new Font("Serif", Font.BOLD, 23));
		showEventL.setForeground(Color.CYAN);
		showEventL.setBounds(500, 50, 250, 100);
		updateP.add(showEventL);

		String[] showEventCB = {};
		sECB=new JComboBox(showEventCB);
		sECB.setBounds(500, 140, 125, 30);
		try {
			String url = "jdbc:mysql://localhost:3306/gifted_project";
			String userName = "root";
			String password = "root";
			String sql= "select eventName from createevent";
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement st = con.createStatement();
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {
				String eventNameUpdateText=rs.getString("eventName");
				sECB.addItem(eventNameUpdateText);
			}
			st.close();
			con.close();
		}catch (Exception e) {
		}
		updateP.add(sECB);
		eventNameUpdateChecker=new JLabel("");
		eventNameUpdateChecker.setFont(new Font("Serif", Font.BOLD, 14));
		eventNameUpdateChecker.setBounds(500, 140, 500, 100);
		updateP.add(eventNameUpdateChecker);

		createEventUpdateL = new JLabel(" Create New Event");
		createEventUpdateL.setFont(new Font("Serif", Font.BOLD, 23));
		createEventUpdateL.setForeground(Color.CYAN);
		createEventUpdateL.setBounds(45, 50, 250, 100);
		updateP.add(createEventUpdateL );
		
		eventNameCreateChecker=new JLabel("");
		eventNameCreateChecker.setFont(new Font("Serif", Font.BOLD, 14));
		eventNameCreateChecker.setBounds(50, 140, 500, 100);
		updateP.add(eventNameCreateChecker);
		
		String[] createEventUpdateCB = {};
		cUECB=new JComboBox(createEventUpdateCB );
		cUECB.setBounds(45, 140, 125, 30);
		try {
			String url = "jdbc:mysql://localhost:3306/gifted_project";
			String userName = "root";
			String password = "root";
			String sql= "select eventName from createevent";
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement st = con.createStatement();
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {
				String eventNameUpdateText=rs.getString("eventName");
				cUECB.addItem(eventNameUpdateText);
			}
			st.close();
			con.close();
		}catch (Exception e) {
		}


		//	cECB.setToolTipText("Select month of your Birthday");
		updateP.add(cUECB);
		pane.add(updateP, "updateProfileForm");

		//========== vieProfile buttons==================//

		ImageIcon updateProfileNextImage = new ImageIcon("images/create.GIF");
		updtateCreateNextB = new JButton(updateProfileNextImage);
		updtateCreateNextB .setBackground(Color.BLUE);
		updtateCreateNextB .setBounds(220, 130, 100, 50);
		updtateCreateNextB .setRolloverEnabled(true);
		updtateCreateNextB .setRolloverIcon(updateProfileNextImage);
		updtateCreateNextB .setPressedIcon(updateProfileNextImage);
		updtateCreateNextB .addActionListener(new updateProfileCreateEventButton());
		updtateCreateNextB .setActionCommand("nextToUpdateProfileCreateEvent");
		updateP.add(updtateCreateNextB );
		updtateCreateNextB.setToolTipText("Create Event");

		//============back to view profile button=================//
		ImageIcon updateProfileBackImage = new ImageIcon("images/customer_back.GIF");
		viewBackB = new JButton(updateProfileBackImage);
		viewBackB.setBackground(Color.GREEN);
		viewBackB.setBounds(350, 275, 100, 50);
		viewBackB.setRolloverEnabled(true);
		viewBackB.setRolloverIcon(updateProfileBackImage);
		viewBackB.setPressedIcon(updateProfileBackImage);
		viewBackB.addActionListener(new updateProfileBackButton());
		viewBackB.setActionCommand("backToupdateProfile");
		updateP.add(viewBackB);
		pane.add(updateP, "updateProfileForm");
		viewBackB.setToolTipText("BACK");
		//========================update event button==========================
		
		//========== vieProfile buttons==================//

		ImageIcon updateProfileNextImage1 = new ImageIcon("images/create.GIF");
		updtateNextB = new JButton(updateProfileNextImage1);
		updtateNextB.setBackground(Color.BLUE);
		updtateNextB.setBounds(700, 130, 100, 50);
		updtateNextB.setRolloverEnabled(true);
		updtateNextB.setRolloverIcon(updateProfileNextImage1);
		updtateNextB.setPressedIcon(updateProfileNextImage1);
		updtateNextB.addActionListener(new updateProfileUpdateEventButton());
		updtateNextB.setActionCommand("nextToUpdateProfileUpdateEvent");
		updateP.add(updtateNextB);
		updtateNextB.setToolTipText("Update Event");

		//=============show event and wishlist page===============
		viewFreindsP = new JPanel(null);
		viewFreindsP.setBackground(Color.DARK_GRAY);
		
		friendFirstNameInfoL = new JLabel("Enter your friend's detail:");
		friendFirstNameInfoL.setFont(new Font("Verdana", Font.BOLD, 20));
		friendFirstNameInfoL.setForeground(Color.CYAN);
		friendFirstNameInfoL.setBounds(20, 1, 350, 100);
		viewFreindsP.add(friendFirstNameInfoL);
		
		friendFirstNameLV = new JLabel("Friend's FirstName:");
		friendFirstNameLV.setFont(new Font("Verdana", Font.BOLD, 15));
		friendFirstNameLV.setForeground(Color.CYAN);
		friendFirstNameLV.setBounds(50, 50, 250, 100);
		viewFreindsP.add(friendFirstNameLV);

		friendLastNameLV = new JLabel("Friend's LastName:");
		friendLastNameLV.setFont(new Font("Verdana", Font.BOLD, 15));
		friendLastNameLV.setForeground(Color.CYAN);
		friendLastNameLV.setBounds(50, 100, 250, 100);
		viewFreindsP.add(friendLastNameLV);

		friendMobileNoLV = new JLabel("Friend's Mobile No:");
		friendMobileNoLV.setFont(new Font("Verdana", Font.BOLD, 15));
		friendMobileNoLV.setForeground(Color.CYAN);
		friendMobileNoLV.setBounds(50, 150, 250, 100);
		viewFreindsP.add(friendMobileNoLV);
		
		friendFirstNameTFV = new JTextField("");
		friendFirstNameTFV.setVisible(true);
		friendFirstNameTFV.setToolTipText("Enter your friend's firstName");
		friendFirstNameTFV.setHorizontalAlignment(JTextField.CENTER);
		friendFirstNameTFV.setForeground(Color.GRAY);
		friendFirstNameTFV.setBounds(230, 90, 250, 30);
		viewFreindsP.add(friendFirstNameTFV);

		friendLastNameTFV = new JTextField("");
		friendLastNameTFV.setVisible(true);
		friendLastNameTFV.setToolTipText("Enter your friend's LastName");
		friendLastNameTFV.setHorizontalAlignment(JTextField.CENTER);
		friendLastNameTFV.setForeground(Color.GRAY);
		friendLastNameTFV.setBounds(230, 140, 250, 30);
		viewFreindsP.add(friendLastNameTFV);

		friendMobileTFV = new JTextField("");
		friendMobileTFV.setVisible(true);
		friendMobileTFV.setToolTipText("Enter your friend's mobileNo");
		friendMobileTFV.setHorizontalAlignment(JTextField.CENTER);
		friendMobileTFV.setForeground(Color.GRAY);
		friendMobileTFV.setBounds(230, 190, 250, 30);
		viewFreindsP.add(friendMobileTFV);
		pane.add(viewFreindsP, "viewProfileForm");

		
		eventNameValueChecker=new JLabel("");
		eventNameValueChecker.setFont(new Font("Serif", Font.BOLD, 14));
		eventNameValueChecker.setBounds(220, 220, 500, 100);
		viewFreindsP.add(eventNameValueChecker);
		
		ImageIcon showEventBackImage = new ImageIcon("images/customer_back.GIF");
		showEventBackB = new JButton(showEventBackImage);
		showEventBackB.setBackground(Color.GREEN);
		showEventBackB.setBounds(350, 300, 100, 50);
		showEventBackB.setRolloverEnabled(true);
		showEventBackB.setRolloverIcon(showEventBackImage);
		showEventBackB.setPressedIcon(showEventBackImage);
		showEventBackB.addActionListener(new showEventBackButton());
		showEventBackB.setActionCommand("backToLoginViewPage");
		viewFreindsP.add(showEventBackB);
		pane.add(viewFreindsP, "viewProfileForm");
		showEventBackB.setToolTipText("BACK");
		
		
		ImageIcon updateProfileNextImage5 = new ImageIcon("images/create.GIF");
		viewFreindeNextB = new JButton(updateProfileNextImage5);
		viewFreindeNextB.setBackground(Color.GREEN);
		viewFreindeNextB.setBounds(550, 300, 100, 50);
		viewFreindeNextB.setRolloverEnabled(true);
		viewFreindeNextB.setRolloverIcon(updateProfileNextImage5);
		viewFreindeNextB.setPressedIcon(updateProfileNextImage5);
		viewFreindeNextB.addActionListener(new viewFriendsProfile());
		viewFreindeNextB.setActionCommand("nextToViewEvent");
		viewFreindsP.add(viewFreindeNextB);
		viewFreindeNextB.setToolTipText("View Event");
	}



	//////////////////////////////////////////////////////////// CTROLLERS//////////////////////////////////////////////
	// -------------------------------------main (go to createProfileForm)-----------//
	private class mainNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			loginUserIDTF.setText(null);
			if (event.getActionCommand().equals("nextToMenuCreateProfile")) {
				cL.show(pane, "createProfileDetailForm");
			}
			if (event.getActionCommand().equals("nextToupdateProfile")) {
					cL.show(pane, "updateLoginForm");
			}
			if (event.getActionCommand().equals("nextToViewProfile")) {
				viewLoginUserIDTF.setText(null);
				viewLoginUserPWDTF.setText(null);
				cL.show(pane, "viewLoginForm");
			}
		}
	}

	//========= create profile actionlistener===============//
	private class createNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("nextToCreateProfile")) {
				//	System.out.println(nameFirstTF.getText());
				if (!(Pattern.matches("^[a-zA-Z]+$",nameFirstTF.getText())) || nameFirstTF.getText().isEmpty() ) { // checker for firstname
					firstNameChecker.setForeground(Color.RED);
					firstNameChecker.setText("Invalid!");
				}

				else {
					firstNameChecker.setForeground(Color.GREEN);
					firstNameChecker.setText("Valid");
				}


				if (!(Pattern.matches("^[a-zA-Z]+$",lastNameTF.getText())) || lastNameTF.getText().isEmpty()) { // for last name
					lastNameChecker.setForeground(Color.RED);
					lastNameChecker.setText("Invalid!");
				}

				else {
					lastNameChecker.setForeground(Color.GREEN);
					lastNameChecker.setText("Valid");
				}

				if ((genderTF.getText().isEmpty())|| (!(genderTF.getText().equals("M"))&&!(genderTF.getText().equals("F")) && !(genderTF.getText().equals("f"))&&!(genderTF.getText().equals("m")))) { // for gender
					genderChecker.setForeground(Color.RED);
					genderChecker.setText("Invalid!");
				}
				else {

					genderChecker.setForeground(Color.GREEN);
					genderChecker.setText("valid!");
				}

				if ((mobileNoTF.getText().isEmpty())|| !(Pattern.matches("^\\d{10}$", mobileNoTF.getText()))) { // for contact
					contactChecker.setForeground(Color.RED);
					contactChecker.setText("Invalid!");
				}
				else {
					contactChecker.setForeground(Color.GREEN);
					contactChecker.setText("valid!");
				}
		
				if((userIDTF.getText().isEmpty())|| !(Pattern.matches("^[a-zA-Z0-9]+$", userIDTF.getText()))) {
					userIDChecker.setForeground(Color.RED);
					userIDChecker.setText("Invalid!");
				}
				else
				{
					userIDChecker.setForeground(Color.GREEN);
					userIDChecker.setText("valid!");
				}
				
				String passwordUser = new String(userPWDTF.getPassword()); 
					if((passwordUser.length()== 0 )|| !(Pattern.matches("^[a-zA-Z0-9]+$", passwordUser))) {
					userPWDChecker.setForeground(Color.RED);
					userPWDChecker.setText("Invalid!");
				}
				else
				{
					userPWDChecker.setForeground(Color.GREEN);
					userPWDChecker.setText("valid!");
		}
				if (Pattern.matches("^[a-zA-Z]+$",nameFirstTF.getText()) && Pattern.matches("^[a-zA-Z]+$",lastNameTF.getText()) && (genderTF.getText().equals("M") || genderTF.getText().equals("F")|| genderTF.getText().equals("m")||genderTF.getText().equals("f")) && Pattern.matches("^\\d{10}$", mobileNoTF.getText())) {		
					String firstNameText = nameFirstTF.getText();
					String lastNameText = lastNameTF.getText();
					String genderText = genderTF.getText();
					String mobileNoText = mobileNoTF.getText();
					String month = String.valueOf(bMCB.getSelectedItem());
					DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH);
					TemporalAccessor accessor = parser.parse(month);
					int monthValue = accessor.get(ChronoField.MONTH_OF_YEAR);
					String date = String.valueOf(bDCB.getSelectedItem());
					String year = String.valueOf(bYCB.getSelectedItem());
					String DOBText = year + "-" + monthValue + "-" + date;
					String socialMediaText = socialMediaTF.getText();
					String userIDText = String.valueOf(userIDTF.getText());
					String userIDPWDText = String.valueOf(userPWDTF.getPassword());
					String eventName="";
					userProfile.setUserProfile(firstNameText, lastNameText, genderText, mobileNoText, DOBText,
							socialMediaText, userIDText,userIDPWDText,eventName);
					socialMediaTF.setText(null);
					nameFirstTF.setText(null);
					lastNameTF.setText(null);
					genderTF.setText(null);
					mobileNoTF.setText(null);
					userIDTF.setText(null);
					userPWDTF.setText(null);
					try {
						String url = "jdbc:mysql://localhost:3306/gifted_project";
						String userName = "root";
						String password = "root";
						Connection con = DriverManager.getConnection(url, userName, password);
						Statement st = con.createStatement();
						String sql = "INSERT INTO createprofile(userID,firstName,lastName,gender,mobileNumber,DOB,handlerLink,userPassword) VALUES ('" +userIDText+ "','" + firstNameText + "','" + lastNameText + "','" + genderText + "','" + mobileNoText
								+ "','" + DOBText + "','" + socialMediaText + "','"+userIDPWDText+"' )";
						
						st.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Inserted successfully!"); 
						cL.show(pane, "createEventForm");
						st.close();
						con.close();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "SQLException:\n" + e, "Error: CreateProfile(wrong data)", JOptionPane.ERROR_MESSAGE);
					}
				}

			} 
		}
	}

	private class createEventNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			if (event.getActionCommand().equals("nextToCreateEvent")) {
				firstNameChecker.setText(null);
				lastNameChecker.setText(null);
				genderChecker.setText(null);
				contactChecker.setText(null);
				userIDChecker.setText(null);
				userPWDChecker.setText(null);
				
				try {
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";
					String friendFirstNameText = friendFirstNameTF.getText();
					String friendLastNameText = friendLastNameTF.getText();
					String friendMobileNoText = friendMobileTF.getText();
					userProfile.setFriend(friendFirstNameText, friendLastNameText, friendMobileNoText);
					String userIDText=userProfile.getUserID();
					//System.out.println(userIDText);
					friendFirstNameTF.setText(null);
					friendLastNameTF.setText(null);
					friendMobileTF.setText(null);
					Connection con = DriverManager.getConnection(url, userName, password);
					Statement st = con.createStatement();
					String sql= "select createprofile_ID from createprofile where userId='"+userIDText+"'";
					ResultSet rs =st.executeQuery(sql);
					int createprofile_IDText=0;
					while(rs.next()){
						createprofile_IDText=rs.getInt("createprofile_ID");
					}
					// System.out.println("profile id=" + createprofile_IDText );
					String sqlInsertFreindDetail="INSERT INTO friendlist(createprofile_ID,friendFN,friendLN,friendMN) VALUES('"+createprofile_IDText+"', '"+friendFirstNameText+"','"+friendLastNameText+"', '"+friendMobileNoText+"')";
					st.executeUpdate(sqlInsertFreindDetail);
					JOptionPane.showMessageDialog(null, "Inserted successfully!");
					cL.show(pane, "createWishListForm");
					st.close();
					con.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Event is already created!");
				}
			}


		}
	}
	//================save button wishlist========================//
	private class wishListSaveButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			if (event.getActionCommand().equals("saveWishlist")) {
				cL.show(pane, "createWishListForm");
				String itemText = createItemTF.getText();
				String brandText = createBrandTF.getText();
				String colorText = createColorTF.getText();
				String commentText = createCommentTF.getText();
				int priceText=0,priorityText=0;
				if(!(createPriceTF.getText().equals(""))&&!(createPriorityTF.getText().equals(""))) {
					priceText = Integer.parseInt(createPriceTF.getText());
					priorityText = Integer.parseInt(createPriorityTF.getText());
					wishList.setPriority(priorityText);
					wishList.setPrice(priceText);
				}
				wishList.setItem(itemText);
				wishList.setColor(colorText);
				wishList.setBrand(brandText);
				wishList.setComment(commentText);
                wishList.setPrice(priceText);
                wishList.setPriority(priorityText);
				createItemTF.setText(null);
				createBrandTF.setText(null);
				createColorTF.setText(null);
				createCommentTF.setText(null);
				createPriceTF.setText(null);
				createPriorityTF.setText(null);
				String userIDText=userProfile.getUserID();
				try {
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";

					Connection con = DriverManager.getConnection(url, userName, password);
					Statement st = con.createStatement();
					String sql= "select createprofile_ID from createprofile where userId='"+userIDText+"'";
					ResultSet rs =st.executeQuery(sql);
					int createprofile_IDText=0,createEventIDText=0;
					while(rs.next()){
						createprofile_IDText=rs.getInt("createprofile_ID");
					}
					String eventNameText=String.valueOf(cECB.getSelectedItem());
					//System.out.println(eventNameText);
					String sqlProfile= "select eventID from createevent where eventName='"+eventNameText+"'";
					ResultSet profileID =st.executeQuery(sqlProfile);
					while(profileID.next()) {
						createEventIDText=profileID.getInt("eventID");
					}
					//System.out.println("eventID");
					String sqlWishlist = "INSERT INTO createwishlist(createprofile_ID,eventID,itemName,brand,color,commentItem,price,priority) VALUES ('"+createprofile_IDText+"','"+createEventIDText+"', '"+itemText+ "','" + brandText + "','" + colorText + "','" + commentText +"','" + priceText + "','"+ priorityText+" ')";
					st.executeUpdate(sqlWishlist);
					JOptionPane.showMessageDialog(null, "Inserted successfully!");  
					st.close();
					con.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "SQLException:\n" + e, "Error: CreateWishList(wrong data)", JOptionPane.ERROR_MESSAGE);
				}
			}

		} 
	}
//================ save wishlist update profile button=======================//
	private class wishListUpdateSaveButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			if (event.getActionCommand().equals("saveWishlistUpdateProfile")) {
				String itemText = createItemUpdateTF.getText();
				String brandText = createBrandUpdateTF.getText();
				String colorText = createColorUpdateTF.getText();
				String commentText = createCommentUpdateTF.getText();
				int priceText=0,priorityText=0;
				if(createPriceUpdateTF.getText().length()>0 ) {
					priceText = Integer.parseInt(createPriceUpdateTF.getText());
			}
				if(createPriorityUpdateTF.getText().length()>0 ) {
					priorityText = Integer.parseInt(createPriorityUpdateTF.getText());
				}
					wishListCreate.setPriority(priorityText);
					wishListCreate.setPrice(priceText);
							
				
				wishListCreate.setItem(itemText);
				wishListCreate.setColor(colorText);
				wishListCreate.setBrand(brandText);
				wishListCreate.setComment(commentText);
             
				createItemUpdateTF.setText(null);
				createBrandUpdateTF.setText(null);
				createColorUpdateTF.setText(null);
				createCommentUpdateTF.setText(null);
				createPriceUpdateTF.setText(null);
				createPriorityUpdateTF.setText(null);
				String userIDText=userProfile.getLoginUID();
				String eventNameText=userProfile.getEventName();
				//String userIDText=userProfile.getUserID();
				try {
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";

					Connection con = DriverManager.getConnection(url, userName, password);
					Statement st = con.createStatement();
					String sql= "select createprofile_ID from createprofile where userId='"+userIDText+"'";
					ResultSet rs =st.executeQuery(sql);
					int createprofile_IDText=0,createEventIDText=0;
					while(rs.next()){
						createprofile_IDText=rs.getInt("createprofile_ID");
					}			
					String sqlProfile= "select eventID from createevent where eventName='"+eventNameText+"'";
					ResultSet profileID =st.executeQuery(sqlProfile);
					while(profileID.next()) {
						createEventIDText=profileID.getInt("eventID");
					}
					String sqlWishlist = "INSERT INTO createwishlist(createprofile_ID,eventID,itemName,brand,color,commentItem,price,priority) VALUES ('"+createprofile_IDText+"','"+createEventIDText+"', '"+itemText+ "','" + brandText + "','" + colorText + "','" + commentText +"',"+priceText+"," +priorityText+")";
					st.executeUpdate(sqlWishlist);
					JOptionPane.showMessageDialog(null, "Inserted successfully!"); 
					cL.show(pane, "createWishListUpdateProfileForm");
					st.close();
					con.close();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please check all the field, itemName is mandatory");
				}
			}

		} 
	}
//===============================wishlistUpdateButton======================================//
	private class wishListUpdateUpdateSaveButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
				
			if (event.getActionCommand().equals("updateWishListList")) {
				String itemUpdateText = createItemUpdateTFU.getText();
				String brandUpdateText = createBrandUpdateTFU.getText();
				String colorUpdateText = createColorUpdateTFU.getText();
				String commentUpdateText = createCommentUpdateTFU.getText();
				String priceUpdateText=createPriceUpdateTFU.getText();
                String priorityUpdateText=createPriorityUpdateTFU.getText();
			    int priceUpdateTextInt=0, priorityUpdateTextInt=0;
			    if(priceUpdateText.length()>0) {
					priceUpdateTextInt = Integer.parseInt(createPriceUpdateTFU.getText());
			    }
			    else {
			    	priceUpdateTextInt=0;
			    }
			    if(priorityUpdateText.length()>0) {
					priorityUpdateTextInt = Integer.parseInt(createPriorityUpdateTFU.getText());
			    }
			    else
			    {
			    	priorityUpdateTextInt=0;
			    }
					wishListUpdate.setPriority(priorityUpdateTextInt);
					wishListUpdate.setPrice(priceUpdateTextInt);
												
				wishListUpdate.setItem(itemUpdateText);
				wishListUpdate.setColor(colorUpdateText);
				wishListUpdate.setBrand(brandUpdateText);
				wishListUpdate.setComment(commentUpdateText);
             
				createItemUpdateTFU.setText(null);
				createBrandUpdateTFU.setText(null);
				createColorUpdateTFU.setText(null);
				createCommentUpdateTFU.setText(null);
				createPriceUpdateTFU.setText(null);
				createPriorityUpdateTFU.setText(null);
				String userIDText=userProfile.getLoginUID();
				System.out.println("userIDText from the frontend" +userIDText);
				String eventNameTextUpdate=userProfile.getEventName();
				System.out.println("eventName from the frontend" +eventNameTextUpdate);
				try {
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";

					Connection con = DriverManager.getConnection(url, userName, password);
					Statement st = con.createStatement();
					String sql= "select createprofile_ID from createprofile where userId='"+userIDText+"'";
					ResultSet rs =st.executeQuery(sql);
					int createprofile_IDText=0,createEventIDText=0;
					while(rs.next()){
						createprofile_IDText=rs.getInt("createprofile_ID");
					}
				
				System.out.println("create profile id "+createprofile_IDText);
					String sqlProfile= "select eventID from createevent where eventName='"+eventNameTextUpdate+"'";
					ResultSet profileID =st.executeQuery(sqlProfile);
					while(profileID.next()) {
						createEventIDText=profileID.getInt("eventID");
					}
					
					String sqlWishlist = "update createwishlist "
							+" set brand='"+brandUpdateText+"',color='"+colorUpdateText+"',commentItem='"+commentUpdateText+"',price='"+priceUpdateTextInt +"',"
							+" priority='"+priorityUpdateTextInt+"'"
							+" where createprofile_ID='"+createprofile_IDText+"' and eventid='"+createEventIDText+"' and itemName='"+itemUpdateText+"'";
				    st.executeUpdate(sqlWishlist);
					String itemNameFromBackend="";
//					while(rs1.next()){
//						itemNameFromBackend=rs1.getString("itemName");
//					}
//					System.out.println("itemNameFromBackend "+ itemNameFromBackend);
//					System.out.println("wishlist item name"+ wishListUpdate.getItemName());
//					if(itemNameFromBackend.equals(wishListUpdate.getItemName()))
//					{
//						
//					}
//					else
//					{
//						JOptionPane.showMessageDialog(null, "Update is Not successful,Please check the itemname");  
//					}
					JOptionPane.showMessageDialog(null, "Updated successfully!");  
					cL.show(pane, "createWishListUpdateUpdateProfileForm");
					st.close();
					con.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Update is Not successful,Please check the itemname");
				}
			}

		} 
	}
	
	// login button
	private class loginNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			String userIDText = String.valueOf(loginUserIDTF.getText());
			String userPWDText= new String(loginUserPWDTF.getPassword());
//			String = String.valueOf(rootPaneCheckingEnabled)
			if((loginUserIDTF.getText().isEmpty()) || userPWDText.equals("")){
				loginUserIDChecker.setForeground(Color.RED);
				loginUserIDChecker.setText("UserID/Password is empty, please input details!");	
			}
			else
			{
				loginUserIDChecker.setText(null);
			userProfile.setLoginUserID(userIDText);
			userProfile.setLoginPWD(userPWDText);
			if (event.getActionCommand().equals("nextToCreateLogin")) {
				try {
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";
					Connection con = DriverManager.getConnection(url, userName, password);
					Statement st = con.createStatement();
					String sql= "select userID,userPassword from createprofile where userId='"+userIDText+"' AND userPassword='"+userPWDText+"'";
					ResultSet rs =st.executeQuery(sql);
					String userIDValue= "";
					String userPWDValue="";
					while(rs.next()){
						
						userIDValue=rs.getString("userID");
						userPWDValue=rs.getString("userPassword");
						}
				
						if(!(userIDValue.equals(userIDText))|| !(userPWDValue.equals(userPWDText))) {
						loginUserIDChecker.setForeground(Color.RED);
						loginUserIDChecker.setText("UserID/Password is Invalid!");		
						
					}
					else
						
					{	
						loginUserIDChecker.setText(null);
						loginUserPWDChecker.setText(null);
						cL.show(pane, "updateProfileForm");	
						
					}
				
					st.close();
					con.close();
					
				}catch (Exception e) {
					loginUserIDChecker.setText(null);
					loginUserPWDChecker.setText(null);
					JOptionPane.showMessageDialog(null, "This UserID/Password is Invalid!");
				}
			}			
			}
	
		}
	}

	private class loginBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			loginUserIDChecker.setText(null);
			loginUserIDTF.setText(null);
			loginUserPWDTF.setText(null);
			if (event.getActionCommand().equals("backToLogin")) {
				cL.show(pane, "welcomeForm");
			}
		}
	}

//view login
	private class viewLoginNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			String userViewIDText = String.valueOf(viewLoginUserIDTF.getText());
			String userViewPWDText= new String(viewLoginUserPWDTF.getPassword());
//			String = String.valueOf(rootPaneCheckingEnabled)
			if((viewLoginUserIDTF.getText().isEmpty()) || userViewPWDText.equals("")){
				viewLoginUserIDChecker.setForeground(Color.RED);
				viewLoginUserIDChecker.setText("UserID/Password is empty, please input details!");	
			}
			else
			{
			viewLoginUserIDChecker.setText(null);
			userProfile.setViewLoginUserID(userViewIDText);
			userProfile.setViewPWD(userViewPWDText);
			if (event.getActionCommand().equals("nextToViewProfileLogin")) {
				try {
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";
					Connection con = DriverManager.getConnection(url, userName, password);
					Statement st = con.createStatement();
					String sql= "select userID,userPassword from createprofile where userId='"+userViewIDText+"' AND userPassword='"+userViewPWDText+"'";
					ResultSet rs =st.executeQuery(sql);
					String userIDValue= "";
					String userPWDValue="";
					while(rs.next()){
						userIDValue=rs.getString("userID");
						userPWDValue=rs.getString("userPassword");
						}
			   		System.out.println("userID is "+ userIDValue);
					System.out.println("userPWD value  is "+ userPWDValue);
						if(!(userIDValue.equals(userViewIDText))|| !(userPWDValue.equals(userViewPWDText))) {
						viewLoginUserIDChecker.setForeground(Color.RED);
						viewLoginUserIDChecker.setText("UserID/Password is Invalid!");		
						
					}
					else
						
					{	
						viewLoginUserIDChecker.setText(null);
						loginUserPWDChecker.setText(null);
						cL.show(pane, "viewProfileForm");	
						
					}
				
					st.close();
					con.close();
					
				}catch (Exception e) {
					viewLoginUserIDChecker.setText(null);
					loginUserPWDChecker.setText(null);
					JOptionPane.showMessageDialog(null, "This UserID/Password is Invalid!");
				}
			}			
			}
		}
	}

	private class viewLoginBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			viewLoginUserIDChecker.setText(null);
			viewLoginUserPWDChecker.setText(null);
			if (event.getActionCommand().equals("backToLogin")) {
				cL.show(pane, "welcomeForm");
			}
		}
	}


	////////////////// view Profile next buttons---------------------
	private class updateProfileCreateEventButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			loginUserIDTF.setText(null);
			loginUserPWDTF.setText(null);
			CardLayout cL = (CardLayout) pane.getLayout();
			String userLoginIDText=userProfile.getLoginUID();
			String selectedEventText=String.valueOf(cUECB.getSelectedItem());
			userProfile.setLoginUserID(userLoginIDText);
			userProfile.setEventName(selectedEventText);
			if (event.getActionCommand().equals("nextToUpdateProfileCreateEvent")) {

				try {
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";
					Connection con = DriverManager.getConnection(url, userName, password);
					Statement st = con.createStatement();
					String sql= "select c.userID from createprofile c"
							+" join createwishlist w"
							+" on c.createprofile_ID=w.createprofile_ID"
							+" join createevent e"
							+" on w.eventID=e.eventID"
							+" where c.userID= '"+userLoginIDText+"' and"
							+" e.eventName='"+selectedEventText+"'";
					ResultSet rs =st.executeQuery(sql);
					String userIDValue="";
					String createProfileIDValue=null;
						while(rs.next()){
						userIDValue=rs.getString("userID");
									}
				
					
					if(userIDValue.equals(userLoginIDText)) {
						eventNameCreateChecker.setForeground(Color.RED);
						eventNameCreateChecker.setText(selectedEventText+ " is already created, please use update Existing Event");		
					}
					
					else {
						cL.show(pane, "createWishListUpdateProfileForm");
					}
					st.close();
					con.close();
					//eventNameChecker.setText(null);
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Not a valid event!");
				}


			}

		}
	}
	private class updateProfileUpdateEventButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JPanel panel = new JPanel();
			userPWDTF.setText(null);
			CardLayout cL = (CardLayout)pane.getLayout();
			
			eventNameCreateChecker.setText(null);
			String userLoginIDText=userProfile.getLoginUID();
			String selectedEventText=String.valueOf(sECB.getSelectedItem());
			userProfile.setLoginUserID(userLoginIDText);
			userProfile.setUpdateEventName(selectedEventText);
			if (event.getActionCommand().equals("nextToUpdateProfileUpdateEvent")) {

				try {
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";
					Connection con = DriverManager.getConnection(url, userName, password);
					 String[] columns = { "UserId value","ItemName", "Brand","Color", "Comment","Price","Priority" };
					 DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
					Statement st = con.createStatement();
							String sql= "select c.userID,w.itemName,w.brand,w.color,w.commentItem,w.price,w.priority from createprofile c"
							+" join createwishlist w"
							+" on c.createprofile_ID=w.createprofile_ID"
							+" join createevent e"
							+" on w.eventID=e.eventID"
							+" where c.userID= '"+userLoginIDText+"' and"
							+" e.eventName='"+selectedEventText+"'";
					ResultSet rs =st.executeQuery(sql);
					String userIDValue="";
					String userItemName="";
					String userItemBrand="";
					String userItemComment="";
					String userItemColor="";
					String userItemPrice="";
					String userItemPriority="";
					String createProfileIDValue=null;
					int i=0;
						while(rs.next()){
  						 userIDValue = rs.getString("userID");
						 userItemName=rs.getString("itemName");
						 userItemBrand=rs.getString("brand");
						 userItemColor=rs.getString("color");
						 userItemComment=rs.getString("commentItem");
						 userItemPrice=rs.getString("price");
						 userItemPriority=rs.getString("priority");
						 String[][] data = { { userIDValue,userItemName,userItemBrand,userItemColor,userItemComment,userItemPrice,userItemPriority } };
						 tableModel.addRow(data[i]);
						i++;
						}		
						if(!(userIDValue.equals(userLoginIDText))) {
							eventNameUpdateChecker.setForeground(Color.RED);
							eventNameUpdateChecker.setText(selectedEventText+ " is NOT created, please use Create New Event");		
						}
						else {
							eventNameUpdateChecker.setText(null);
						jt = new JTable(tableModel);
						jt.setBounds(30,40,250,100);          
						JScrollPane sp=new JScrollPane(jt);    
						panel.add(sp);          
						panel.setSize(300,400);    
						panel.setVisible(true);  
						JFrame frame = new JFrame();
						  frame.add(panel);
					      frame.setSize(600, 400);
					      frame.setVisible(true);
					      
					     JButton buttonSave= new JButton("UPDATE");
					     buttonSave.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								cL.show(pane, "createWishListUpdateUpdateProfileForm");
								frame.setVisible(false);
								}
					 	
							}
						);
						
					     buttonSave.setBounds(50, 50, 100, 100);
					     panel.add(buttonSave);
						st.close();
					con.close();
						}
					//eventNameChecker.setText(null);
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Display Error");
				}


			}

		}
	}
	private class viewFriendsProfile implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JPanel panel = new JPanel();
			CardLayout cL = (CardLayout)pane.getLayout();
			String userviewLoginIDText=userProfile.getViewLoginUID();
			viewLoginUserIDTF.setText(null);
			viewLoginUserPWDTF.setText(null);
			if (event.getActionCommand().equals("nextToViewEvent")) {

				try {
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";
					Connection con = DriverManager.getConnection(url, userName, password);
					Statement st = con.createStatement();
					String sql= "select firstName,lastName,mobileNumber from createprofile where userId='"+userviewLoginIDText+"' ";
					ResultSet rs =st.executeQuery(sql);
					String firstNameValue= "";
					String lastNameValue="";
					String mobileNoValue ="";
					while(rs.next()){
						firstNameValue=rs.getString("firstName");
						lastNameValue=rs.getString("lastName");
						mobileNoValue=rs.getString("mobileNumber");
						}
		
			
					String friendFirstName= friendFirstNameTFV.getText();
					String friendLastName= friendLastNameTFV .getText();
					String friendMobileNo= friendMobileTFV.getText();
					 String[] columns = { "Event Name","ItemName", "Brand","Color", "Comment","Price","Priority" };
					 DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
					
							String sql1= "select e.eventName,w.itemName,w.color,w.brand,w.commentItem,w.price,w.priority from \r\n"
									+ "createprofile c\r\n"
									+ "join  friendlist f\r\n"
									+ "on c.createprofile_ID=f.createprofile_ID\r\n"
									+ "join createwishlist w on\r\n"
									+ "f.createprofile_ID=w.createprofile_ID\r\n"
									+ "join createevent e\r\n"
									+ "on w.eventID=e.eventID\r\n"
									+ "where c.firstName='"+friendFirstName+"'"
									+ "and c.lastName='"+friendLastName+"'"
									+ "and c.mobileNumber='"+friendMobileNo+"'"
									+ "and f.friendFN='"+firstNameValue+"' "
									+ "and f.friendLN='"+lastNameValue+"'"
									+ "and f.friendMN='"+mobileNoValue+"'"; 
					ResultSet rs1 =st.executeQuery(sql1);
					String eventValue="";
					String userItemName="";
					String userItemBrand="";
					String userItemComment="";
					String userItemColor="";
					String userItemPrice="";
					String userItemPriority="";
					String createProfileIDValue=null;
					int i=0;
					if(rs1.isBeforeFirst()) {
				while(rs1.next()){
					
							eventValue= rs1.getString("eventName");
						 userItemName=rs1.getString("itemName");
						 userItemBrand=rs1.getString("brand");
						 userItemColor=rs1.getString("color");
						 userItemComment=rs1.getString("commentItem");
						 userItemPrice=rs1.getString("price");
						 userItemPriority=rs1.getString("priority");
						 String[][] data = { { eventValue,userItemName,userItemBrand,userItemColor,userItemComment,userItemPrice,userItemPriority } };
						 tableModel.addRow(data[0]);
						 System.out.println("event valeu "+ eventValue);
											}		
						eventNameValueChecker.setText(null);
						jt = new JTable(tableModel);
						jt.setBounds(30,40,250,100);          
						JScrollPane sp=new JScrollPane(jt);    
						panel.add(sp);          
						panel.setSize(300,400);    
						panel.setVisible(true);  
						JFrame frame = new JFrame();
						  frame.add(panel);
					      frame.setSize(600, 400);
					      frame.setVisible(true);
					      friendFirstNameTFV.setText(null);
					      friendLastNameTFV.setText(null);
					      friendMobileTFV.setText(null);
					      
					}
					else
					{
						eventNameValueChecker.setForeground(Color.RED);
						eventNameValueChecker.setText(friendFirstName +" has not added you in friendlist");		
					}
					
						st.close();
					con.close();
				
					//eventNameChecker.setText(null);
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Display Error");
				}


			}

		}
	}
	private class updateProfileBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			eventNameCreateChecker.setText(null);
			loginUserIDChecker.setText(null);
			loginUserIDTF.setText(null);
			loginUserPWDTF.setText(null);
			if (event.getActionCommand().equals("backToupdateProfile")) {
				eventNameUpdateChecker.setText(null);
				cL.show(pane, "updateLoginForm");
			}
		}
	}

	//============back to welcome form================//
	private class createBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToWelcomeForm")) {
				firstNameChecker.setText(null);
				lastNameChecker.setText(null);
				genderChecker.setText(null);
				contactChecker.setText(null);
				userIDChecker.setText(null);
				socialMediaTF.setText(null);
				nameFirstTF.setText(null);
				lastNameTF.setText(null);
				genderTF.setText(null);
				mobileNoTF.setText(null);
				userIDTF.setText(null);
				userPWDTF.setText(null);
				userPWDChecker.setText(null);
				
				cL.show(pane, "welcomeForm");
			}
		}
	}

	private class showEventBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			viewLoginUserIDTF.setText(null);
			viewLoginUserPWDTF.setText(null);
			if (event.getActionCommand().equals("backToLoginViewPage")) {
				cL.show(pane, "viewLoginForm");
			}
		}
	}



	//============Back button===================//
	private class createEventBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToCreateProfile")) {
				firstNameChecker.setText(null);
				lastNameChecker.setText(null);
				genderChecker.setText(null);
				contactChecker.setText(null);
				userIDChecker.setText(null);
				userPWDChecker.setText(null);
				socialMediaTF.setText(null);
				nameFirstTF.setText(null);
				lastNameTF.setText(null);
				genderTF.setText(null);
				mobileNoTF.setText(null);
				userIDTF.setText(null);
				userPWDTF.setText(null);
				cL.show(pane, "createProfileDetailForm");
			}
		}
	}
	//=================Back button===================//
	private class createWishListBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToCreateEvent")) {
				cL.show(pane, "createEventForm");
			}
		}
	}
	private class createWishListUpdateBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			eventNameCreateChecker.setText(null);
			createItemUpdateTF.setText(null);
			createBrandUpdateTF.setText(null);
			createColorUpdateTF.setText(null);
			createCommentUpdateTF.setText(null);
			createPriceUpdateTF.setText(null);
			createPriorityUpdateTF.setText(null);
			if (event.getActionCommand().equals("backToCreateEvent")) {
				cL.show(pane, "updateProfileForm");
			}
		}
	}

	private class createWishListUpdateUpdateBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			eventNameCreateChecker.setText(null);
			createItemUpdateTFU.setText(null);
			createBrandUpdateTFU.setText(null);
			createColorUpdateTFU.setText(null);
			createCommentUpdateTFU.setText(null);
			createPriceUpdateTFU.setText(null);
			createPriorityUpdateTFU.setText(null);
			if (event.getActionCommand().equals("backToCreateEvent")) {
				cL.show(pane, "updateProfileForm");
			}
		}
	}
	private void connectDatabase() {
		try {
			String url = "jdbc:mysql://localhost:3306/gifted_project";
			String userName = "root";
			String password = "root";
			//			Connection con = DriverManager.getConnection(url, userName, password);
			//			Statement st = con.createStatement();

		}catch (Exception e) {
		}
	}
	
}

