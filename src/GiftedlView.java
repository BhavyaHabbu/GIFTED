
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.io.*;
import java.sql.*; 
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.regex.Pattern;


public class GiftedlView extends JFrame{


	// as global declaration
	private WishList wishList = new WishList();// access class WishList as global declaration
	private UserProfile userProfile = new UserProfile();
	private WishListCreate wishListCreate = new WishListCreate();
	Container pane = getContentPane();
	private JPanel mainP, createP, createEventP, createWishListP, loginP, updateP, showEventP,viewLoginP,createWishListUpdateProfileP; // panels for CardLayout
	private JLabel titleL, profileC, profileInfo, profileV, profileU,friendProfileInfo; // inside the panel of mainP
	private JButton mainNextC, mainNextV,mainNextU;
	private JLabel firstNameL, mainTitleL,lastNameL, mobileNoL, socialMediaL, birthDateL, eventL, genderL, loginUsernameL,viewLoginUsernameL,userIDPWD,
	loginUserLastNameL, loginPasswordL, friendFirstNameL, friendLastNameL; // inside the panel of createP
	private JLabel firstNameChecker, lastNameChecker, genderChecker, contactChecker;
	private JTextField nameFirstTF, firstNameTF, lastNameTF, locationTF, contactTF, mobileNoTF, genderTF, socialMediaTF,
	loginPasswordTF, loginUserIDTF, loginMobileNoTF, nameFriendFirstTF, lastFriendNameTF, friendFirstNameTF,viewLoginUserIDTF,
	friendLastNameTF;
	private JPasswordField	userPWDTF;
	private JLabel socialMediaLinkChecker, DOBChecker,userIDChecker,loginUserIDChecker,eventNameChecker,viewLoginUserIDChecker,userPWDChecker;
	private JButton createNextB, createBackB, loginNextB, loginBackB,updtateNextB,viewLoginBackB,viewLoginNextB;
	private JComboBox bMCB, bDCB, bYCB,cDECB,sECB,cUECB;
	private JTextField createTF,userIDTF;
	private JLabel createEventL, updateEventL,userIDL,updateL, createWishListL, updateWishListL, showWishListL, showEventL,createEventUpdateL,createPriorityUpdateL,createPriceUpdateL,createCommentUpdateL,createColorUpdateL,createBrandUpdateL,createItemUpdateL,
	friendMobileNoL;
	private JTextField createEventTF, updateEventTF, createWishListTF, updateWishListTF,createPriorityUpdateTF, showWishListTF, friendMobileTF,createPriceUpdateTF,createCommentUpdateTF,createColorUpdateTF,createBrandUpdateTF,createItemUpdateTF;
	// private JLabel firstNameChecker, lastNameChecker, genderChecker,
	// contactChecker
	private JButton customerNextB, customerBackB, viewNextB, viewBackB,createWishListSaveB,updtateCreateNextB,createWishListUpdateSaveB,createWishListUpdateBackB;
	private JComboBox cECB, uECB, showEventCB;
	private JLabel createItemL, createBrandL,showItemL, createColorL, createCommentL, createPriceL, createPriorityL; // inside the
	private JTextField createItemTF, createBrandTF, createColorTF, createCommentTF, createPriceTF, createPriorityTF;
	private JButton createWishListBackB, showEventBackB;
	private JTextArea carDetailsTA;
	
	
	
	
	private String loggedInUserID;
	private JPanel userProfilePanel, searchFriendPanel, searchedUserPanel, loginFormP, viewFriendListPanel, friendsPanel, viewWishListPanel, wishListPanel;
	private JButton searchFriend,viewFriends, viewWishlistBtn, searchFriendDB, addWishlist, viewWishlist, signInB, friendListBackProfile, profileToMainBackBtn;
	private JLabel userWelcomeMsg, wishlistHeaderLabel, searchFrienddFirstName, noUserFoundLabel, 
	searchFrienddlastName, loginUserPasswordL, loginError, addFriendImageLabel, friendListImageLabel, wishListImageLabel;
	private JTextField searchFrienddFirstNameTF, searchFrienddlastNameTF, loginUsernameTF, loginUserPasswordTF;
	
	private String onLoginSuccessAction = null;


	public GiftedlView()  {
		//======= Create main Page==============//
		pane.setLayout(new CardLayout());
		mainP = new JPanel(null);
		mainP.setBackground(Color.darkGray);

		ImageIcon titleImage = new ImageIcon("images/friendship.JPG");
		titleL = new JLabel(titleImage);
		titleL.setBounds(280, 50, 400, 600);
		mainP.add(titleL);
		ImageIcon createImage = new ImageIcon("images/friendship-image.GIF");
		titleL = new JLabel(createImage);
		titleL.setBounds(5, 150, 330, 600);
		mainP.add(titleL);
		ImageIcon createImage2 = new ImageIcon("images/friendship-image.GIF");
		titleL = new JLabel(createImage2);
		titleL.setBounds(650, 150, 330, 600);
		mainP.add(titleL);


		mainTitleL = new JLabel("Welcome to GIFTED");
		mainTitleL.setFont(new Font("Serif", Font.BOLD, 28));
		mainTitleL.setForeground(Color.MAGENTA);
		mainTitleL.setBounds(350, 10, 350, 25);
		mainP.add(mainTitleL);
		//		

		profileC = new JLabel("Create Profile");
		profileC.setFont(new Font("Serif", Font.BOLD, 23));
		profileC.setForeground(Color.CYAN);
		profileC.setBounds(50, 40, 150, 25);
		mainP.add(profileC);
		//==========button for create profile================//
		ImageIcon mainNextImage = new ImageIcon("images/customer.GIF");
		mainNextC = new JButton(mainNextImage);
		mainNextC.setBackground(Color.BLUE);
		mainNextC.addActionListener(new mainNextButton());
		mainNextC.setBounds(70, 70, 100, 50);
		mainNextC.setRolloverEnabled(true);
		mainNextC.setRolloverIcon(mainNextImage);
		mainNextC.setPressedIcon(mainNextImage);
		mainNextC.setActionCommand("nextToMenuCreateProfile");
		mainP.add(mainNextC);

		profileV = new JLabel("View Profile");
		profileV.setFont(new Font("Serif", Font.BOLD, 23));
		profileV.setForeground(Color.CYAN);
		profileV.setBounds(700, 110, 150, 25);
		mainP.add(profileV);
		//============= button for view profile============//
		ImageIcon mainNextImage1 = new ImageIcon("images/next.GIF");
		mainNextV = new JButton(mainNextImage1);
		mainNextV.setBackground(Color.BLUE);
		mainNextV.addActionListener(new mainNextButton());
		mainNextV.setBounds(720, 140, 100, 50);
		mainNextV.setRolloverEnabled(true);
		mainNextV.setRolloverIcon(mainNextImage1);
		mainNextV.setPressedIcon(mainNextImage1);
		mainNextV.setActionCommand("nextToViewProfile");
		mainP.add(mainNextV);
		pane.add(mainP, "welcomeForm");



		profileU = new JLabel("Update Profile");
		profileU.setFont(new Font("Serif", Font.BOLD, 23));
		profileU.setForeground(Color.CYAN);
		profileU.setBounds(50, 200, 150, 25);
		mainP.add(profileU);
		//============= button for view profile============//
		ImageIcon mainNextImage2 = new ImageIcon("images/next.GIF");
		mainNextU= new JButton(mainNextImage2);
		mainNextU.setBackground(Color.BLUE);
		mainNextU.addActionListener(new mainNextButton());
		mainNextU.setBounds(70, 230, 100, 50);
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

		lastNameL = new JLabel("Last Name:");
		lastNameL.setFont(new Font("Verdana", Font.BOLD, 15));
		lastNameL.setForeground(Color.CYAN);
		lastNameL.setBounds(50, 100, 250, 100);
		createP.add(lastNameL);

		genderL = new JLabel("Gender:");
		genderL.setFont(new Font("Verdana", Font.BOLD, 15));
		genderL.setForeground(Color.CYAN);
		genderL.setBounds(50, 150, 250, 100);
		createP.add(genderL);

		mobileNoL = new JLabel("Mobile No:");
		mobileNoL.setFont(new Font("Verdana", Font.BOLD, 15));
		mobileNoL.setForeground(Color.CYAN);
		mobileNoL.setBounds(50, 200, 100, 100);
		createP.add(mobileNoL);

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

		Integer[] birthYearCB = { 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983,
				1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000,
				2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017,
				2018, 2019, 2020, 2021 };
		bYCB = new JComboBox(birthYearCB);
		bYCB.setBounds(340, 290, 60, 25);
		bYCB.setToolTipText("Select your Birth year");
		createP.add(bYCB);


		userIDL = new JLabel("UserID 3:");
		userIDL.setFont(new Font("Verdana", Font.BOLD, 15));
		userIDL.setForeground(Color.CYAN);
		userIDL.setBounds(50, 340, 150, 100);
		createP.add(userIDL);
		
		userIDPWD = new JLabel("Password:");
		userIDPWD.setFont(new Font("Verdana", Font.BOLD, 15));
		userIDPWD.setForeground(Color.CYAN);
		userIDPWD.setBounds(50, 380, 150, 100);
		createP.add(userIDPWD);
		

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
		userPWDChecker.setBounds(460, 340, 100, 100);
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
		friendProfileInfo.setForeground(Color.GREEN);
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
			Connection con = DBUtils.getConnection();
			Statement st = con.createStatement();
			String sql= "select eventName from createevent";
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
		customerNextB.setToolTipText("NEXT");

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

		createWishListP = new JPanel(null);
		createWishListP.setBackground(Color.DARK_GRAY);

		createItemL = new JLabel("Create Item:");
		createItemL.setFont(new Font("Verdana", Font.BOLD, 15));
		createItemL.setForeground(Color.CYAN);
		createItemL.setBounds(50, 1, 250, 100);
		createWishListP.add(createItemL);

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

		createItemTF = new JTextField("");
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
		createWishListBackB.setBounds(330, 400, 100, 50);
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
		createWishListSaveB.setBounds(530, 400, 100, 50);
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

		ImageIcon createWishListBackImage1 = new ImageIcon("images/customer_back.GIF");
		createWishListUpdateBackB = new JButton(createWishListBackImage1);
		createWishListUpdateBackB.setBackground(Color.GREEN);
		createWishListUpdateBackB.setBounds(330, 400, 100, 50);
		createWishListUpdateBackB.setRolloverEnabled(true);
		createWishListUpdateBackB.setRolloverIcon(createWishListBackImage1);
		createWishListUpdateBackB.setPressedIcon(createWishListBackImage1);
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

		loginUserIDTF = new JTextField(""); 
		loginUserIDTF.setHorizontalAlignment(JTextField.CENTER);
		loginUserIDTF.setToolTipText("Enter your userid");
		loginUserIDTF.setForeground(Color.GRAY);
		loginUserIDTF.setBounds(300, 40, 250, 30);
		loginP.add(loginUserIDTF);

		pane.add(loginP, "updateLoginForm");
		
		loginUserIDChecker=new JLabel("");
		loginUserIDChecker.setFont(new Font("Serif", Font.BOLD, 16));
		loginUserIDChecker.setBounds(320, 50, 500, 100);
		loginP.add(loginUserIDChecker);
		
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

		viewLoginUsernameL = new JLabel("UserID 2:");
		viewLoginUsernameL.setFont(new Font("Verdana", Font.BOLD, 15));
		viewLoginUsernameL.setForeground(Color.CYAN);
		viewLoginUsernameL.setBounds(50, 1, 250, 100);
		viewLoginP.add(viewLoginUsernameL);

		viewLoginUserIDTF = new JTextField(""); 
		viewLoginUserIDTF.setHorizontalAlignment(JTextField.CENTER);
		viewLoginUserIDTF.setToolTipText("Enter your userid");
		viewLoginUserIDTF.setForeground(Color.GRAY);
		viewLoginUserIDTF.setBounds(300, 40, 250, 30);
		viewLoginP.add(viewLoginUserIDTF);

		pane.add(viewLoginP, "viewLoginForm");
		
		viewLoginUserIDChecker=new JLabel("");
		viewLoginUserIDChecker.setFont(new Font("Serif", Font.BOLD, 16));
		viewLoginUserIDChecker.setBounds(320, 50, 500, 100);
		viewLoginP.add(viewLoginUserIDChecker);
		
		//===========Login page next button=============//
		ImageIcon viewLoginNextImage = new ImageIcon("images/create.GIF");
		viewLoginNextB = new JButton(viewLoginNextImage);
		viewLoginNextB.setBackground(Color.GREEN);
		viewLoginNextB.setBounds(550, 200, 100, 50);
		viewLoginNextB.setRolloverEnabled(true);
		viewLoginNextB.setRolloverIcon(viewLoginNextImage);
		viewLoginNextB.setPressedIcon(viewLoginNextImage);
		viewLoginNextB.addActionListener(new viewLoginNextButton());
		viewLoginNextB.setActionCommand("viewProfileLogin");
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
			Connection con = DBUtils.getConnection();
			Statement st = con.createStatement();
			String sql= "select eventName from createevent";
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {
				String eventNameUpdateText=rs.getString("eventName");
				sECB.addItem(eventNameUpdateText);
			}
			st.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		updateP.add(sECB);
		eventNameChecker=new JLabel("");
		eventNameChecker.setFont(new Font("Serif", Font.BOLD, 14));
		eventNameChecker.setBounds(500, 140, 500, 100);
		updateP.add(eventNameChecker);

		createEventUpdateL = new JLabel(" Create New Event");
		createEventUpdateL.setFont(new Font("Serif", Font.BOLD, 23));
		createEventUpdateL.setForeground(Color.CYAN);
		createEventUpdateL.setBounds(45, 50, 250, 100);
		updateP.add(createEventUpdateL );

		String[] createEventUpdateCB = {};
		cUECB=new JComboBox(createEventUpdateCB );
		cUECB.setBounds(45, 140, 125, 30);
		try {
			Connection con = DBUtils.getConnection();
			Statement st = con.createStatement();
			String sql= "select eventName from createevent";
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {
				String eventNameUpdateText=rs.getString("eventName");
				cUECB.addItem(eventNameUpdateText);
			}
			st.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
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
		
		addSearchFriendButton(updateP);
		addViewFriendButton(updateP);
		addViewWishListButton(updateP);
		
		ImageIcon updateProfileBackImage = new ImageIcon("images/customer_back.GIF");
		viewBackB = new JButton(updateProfileBackImage);
		viewBackB.setBackground(Color.GREEN);
		viewBackB.setBounds(350, 375, 100, 50);
		viewBackB.setRolloverEnabled(true);
		viewBackB.setRolloverIcon(updateProfileBackImage);
		viewBackB.setPressedIcon(updateProfileBackImage);
		viewBackB.addActionListener(new createBackButton());
		viewBackB.setActionCommand("backToWelcomeForm");
		viewBackB.setToolTipText("BACK");
		updateP.add(viewBackB);
		
		pane.add(updateP, "updateProfileForm");
		
		
		
		
		
		
		
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
		
		
		
		
		
		showEventP = new JPanel(null);
		showEventP.setBackground(Color.DARK_GRAY);

		createEventL = new JLabel("Display Event:");
		createEventL.setFont(new Font("Serif", Font.BOLD, 23));
		createEventL.setForeground(Color.CYAN);
		createEventL.setBounds(150, 1, 250, 100);
		showWishListL = new JLabel("WishList");
		showWishListL.setFont(new Font("Serif", Font.BOLD, 23));
		showWishListL.setForeground(Color.CYAN);
		showWishListL.setBounds(50, 5, 250, 100);
		showEventP.add(showWishListL);


		showItemL = new JLabel("Item Name:");
		showItemL.setFont(new Font("Serif", Font.BOLD, 23));
		showItemL.setForeground(Color.CYAN);
		showItemL.setBounds(50, 50, 250, 100);
		showEventP.add(showItemL);

		showWishListTF = new JTextField("");
		showWishListTF.setHorizontalAlignment(JTextField.CENTER);
		showWishListTF.setToolTipText("Enter item name");
		showWishListTF.setForeground(Color.GRAY);
		showWishListTF.setBounds(185, 90, 250, 30);
		showEventP.add(showWishListTF);
		pane.add(showEventP, "showEventForm");

		ImageIcon showEventBackImage = new ImageIcon("images/customer_back.GIF");
		showEventBackB = new JButton(showEventBackImage);
		showEventBackB.setBackground(Color.GREEN);
		showEventBackB.setBounds(350, 200, 100, 50);
		showEventBackB.setRolloverEnabled(true);
		showEventBackB.setRolloverIcon(showEventBackImage);
		showEventBackB.setPressedIcon(showEventBackImage);
		showEventBackB.addActionListener(new showEventBackButton());
		showEventBackB.setActionCommand("backToShowEvent");
		showEventP.add(showEventBackB);
		pane.add(showEventP, "showEventForm");
		showEventBackB.setToolTipText("BACK");
		
		
		//Shruti Code Starts
		loginForm();
		userProfile();
		searchFriend();
		friendList();
		wishList();
	}

	private void wishList() {
		
		
		viewWishListPanel = new JPanel(null);
		viewWishListPanel.setBackground(Color.DARK_GRAY);
		
		ImageIcon createImage1 = new ImageIcon("images/friendCreate.JPG");
		// Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
		wishListImageLabel = new JLabel(createImage1);
		wishListImageLabel.setBounds(520, 0, 500, 600);
		viewWishListPanel.add(wishListImageLabel);
		
		wishlistHeaderLabel = new JLabel("View Wish List");
		wishlistHeaderLabel.setFont(new Font("Serif", Font.BOLD, 23));
		wishlistHeaderLabel.setForeground(Color.CYAN);
		wishlistHeaderLabel.setBounds(50, 5, 250, 100);
		viewWishListPanel.add(wishlistHeaderLabel);
		
		
		wishListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wishListPanel.setBounds(50, 100, 400, 400);
		wishListPanel.setBackground(Color.DARK_GRAY);
		wishListPanel.setLayout(new GridLayout(10, 1, 10, 10));
		viewWishListPanel.add(wishListPanel);
		
		
		ImageIcon showEventBackImage = new ImageIcon("images/customer_back.GIF");
		friendListBackProfile = new JButton(showEventBackImage);
		friendListBackProfile.setBackground(Color.GREEN);
		friendListBackProfile.setBounds(250, 500, 100, 50);
		friendListBackProfile.addActionListener(new mainNextButton());
		friendListBackProfile.setActionCommand("backAfterLogin");
		friendListBackProfile.setToolTipText("BACK");
		viewWishListPanel.add(friendListBackProfile);
		
		
		pane.add(viewWishListPanel, "viewWishListPanel");
	}

	private void friendList() {
		
		viewFriendListPanel = new JPanel(null);
		viewFriendListPanel.setBackground(Color.DARK_GRAY);
		
		ImageIcon createImage1 = new ImageIcon("images/friendCreate.JPG");
		// Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
		friendListImageLabel = new JLabel(createImage1);
		friendListImageLabel.setBounds(520, 0, 500, 600);
		viewFriendListPanel.add(friendListImageLabel);
		
		userWelcomeMsg = new JLabel("View Friend List");
		userWelcomeMsg.setFont(new Font("Serif", Font.BOLD, 23));
		userWelcomeMsg.setForeground(Color.CYAN);
		userWelcomeMsg.setBounds(50, 5, 250, 100);
		viewFriendListPanel.add(userWelcomeMsg);
		
		
		friendsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		friendsPanel.setBounds(50, 100, 400, 400);
		friendsPanel.setBackground(Color.DARK_GRAY);
		friendsPanel.setLayout(new GridLayout(10, 1, 10, 10));
		viewFriendListPanel.add(friendsPanel);
		
		
		ImageIcon showEventBackImage = new ImageIcon("images/customer_back.GIF");
		friendListBackProfile = new JButton(showEventBackImage);
		friendListBackProfile.setBackground(Color.GREEN);
		friendListBackProfile.setBounds(250, 500, 100, 50);
		friendListBackProfile.addActionListener(new mainNextButton());
		friendListBackProfile.setActionCommand("backAfterLogin");
		friendListBackProfile.setToolTipText("BACK");
		viewFriendListPanel.add(friendListBackProfile);
		
		
		pane.add(viewFriendListPanel, "viewFriendListPanel");
			
		
	}

	private void loginForm() {
		loginFormP = new JPanel(null);
		loginFormP.setBackground(Color.DARK_GRAY);

		loginUsernameL = new JLabel("Username :");
		loginUsernameL.setFont(new Font("Verdana", Font.BOLD, 15));
		loginUsernameL.setForeground(Color.CYAN);
		loginUsernameL.setBounds(50, 1, 250, 100);
		loginFormP.add(loginUsernameL);

		loginUserPasswordL = new JLabel("Password:");
		loginUserPasswordL.setFont(new Font("Verdana", Font.BOLD, 15));
		loginUserPasswordL.setForeground(Color.CYAN);
		loginUserPasswordL.setBounds(50, 50, 250, 100);
		loginFormP.add(loginUserPasswordL);

		loginUsernameTF = new JTextField(""); // set as 10 ha
		loginUsernameTF.setHorizontalAlignment(JTextField.CENTER);
		loginUsernameTF.setForeground(Color.GRAY);
		loginUsernameTF.setBounds(300, 40, 250, 30);
		loginFormP.add(loginUsernameTF);

		loginUserPasswordTF = new JTextField(""); // set as 10 ha
		loginUserPasswordTF.setHorizontalAlignment(JTextField.CENTER);
		loginUserPasswordTF.setForeground(Color.GRAY);
		loginUserPasswordTF.setBounds(300, 90, 250, 30);
		loginFormP.add(loginUserPasswordTF);
		
		
		loginError = new JLabel("");
		loginError.setFont(new Font("Serif", Font.BOLD, 14));
		loginError.setBounds(50, 100, 250, 100);
		loginFormP.add(loginError);
		
		
		
		ImageIcon loginBackImage1 = new ImageIcon("images/next.GIF");
		signInB = new JButton(loginBackImage1);
		signInB.setBackground(Color.CYAN);
		signInB.setBounds(350, 200, 100, 50);
		signInB.setRolloverEnabled(true);
		signInB.setRolloverIcon(loginBackImage1);
		signInB.setPressedIcon(loginBackImage1);
		signInB.addActionListener(new validateLoginButton());
		signInB.setActionCommand("backToLogin");
		loginFormP.add(signInB);
		
		
		
		
		ImageIcon loginBackImage2 = new ImageIcon("images/back.GIF");
		profileToMainBackBtn = new JButton(loginBackImage2);
		profileToMainBackBtn.setBackground(Color.CYAN);
		profileToMainBackBtn.setBounds(250, 200, 100, 50);
		profileToMainBackBtn.setRolloverEnabled(true);
		profileToMainBackBtn.setRolloverIcon(loginBackImage2);
		profileToMainBackBtn.setPressedIcon(loginBackImage2);
		profileToMainBackBtn.addActionListener(new createBackButton());
		profileToMainBackBtn.setActionCommand("backToWelcomeForm");
		loginFormP.add(profileToMainBackBtn);
		pane.add(loginFormP, "userLoginForm");
		
	}

	private void addSearchFriendButton(JPanel updateP) {
		System.out.println("inside addSearchFriendButton");
		ImageIcon image = new ImageIcon("images/add_friend_1.png");
		searchFriend = new JButton(image);
		searchFriend.setBackground(Color.GREEN);
		searchFriend.setBounds(100, 225, 250, 100);
		searchFriend.setRolloverEnabled(true);
		searchFriend.setRolloverIcon(image);
		searchFriend.setPressedIcon(image);
		searchFriend.addActionListener(new SearchFriendsButton());
		searchFriend.setActionCommand("nextToCreateLogin");
		searchFriend.setToolTipText("Search friend");
		updateP.add(searchFriend);
	}
	
	private void addViewFriendButton(JPanel updateP) {
		System.out.println("inside addSearchFriendButton");
		ImageIcon image = new ImageIcon("images/friend_list_1.png");
		viewFriends = new JButton(image);
		viewFriends.setBackground(Color.GREEN);
		viewFriends.setBounds(350, 225, 250, 100);
		viewFriends.setRolloverEnabled(true);
		viewFriends.setRolloverIcon(image);
		viewFriends.setPressedIcon(image);
		viewFriends.addActionListener(new ViewFriendListButton());
		viewFriends.setActionCommand("viewFriendList");
		viewFriends.setToolTipText("View friend");
		updateP.add(viewFriends);
	}
	
	private void addViewWishListButton(JPanel updateP) {
		System.out.println("inside addSearchFriendButton");
		ImageIcon image = new ImageIcon("images/wish_list_1.png");
		viewWishlistBtn = new JButton(image);
		viewWishlistBtn.setBackground(Color.GREEN);
		viewWishlistBtn.setBounds(600, 225, 250, 100);
		viewWishlistBtn.setRolloverEnabled(true);
		viewWishlistBtn.setRolloverIcon(image);
		viewWishlistBtn.setPressedIcon(image);
		viewWishlistBtn.addActionListener(new ViewWishListButton());
		viewWishlistBtn.setActionCommand("viewFriendList");
		viewWishlistBtn.setToolTipText("View Wishlist");
		updateP.add(viewWishlistBtn);
	}
	
	private void searchFriend() {
		searchFriendPanel = new JPanel(null);
		searchFriendPanel.setBackground(Color.DARK_GRAY);
		
		ImageIcon createImage1 = new ImageIcon("images/friendCreate.JPG");
		// Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
		addFriendImageLabel = new JLabel(createImage1);
		addFriendImageLabel.setBounds(520, 0, 500, 600);
		searchFriendPanel.add(addFriendImageLabel);
		
		userWelcomeMsg = new JLabel("Search friends to add");
		userWelcomeMsg.setFont(new Font("Serif", Font.BOLD, 23));
		userWelcomeMsg.setForeground(Color.CYAN);
		userWelcomeMsg.setBounds(50, 5, 250, 100);
		searchFriendPanel.add(userWelcomeMsg);
		
		
		searchFrienddFirstName = new JLabel("First Name:");
		searchFrienddFirstName.setFont(new Font("Verdana", Font.BOLD, 15));
		searchFrienddFirstName.setForeground(Color.CYAN);
		searchFrienddFirstName.setBounds(50, 50, 250, 100);
		searchFriendPanel.add(searchFrienddFirstName);

		searchFrienddlastName = new JLabel("Last Name:");
		searchFrienddlastName.setFont(new Font("Verdana", Font.BOLD, 15));
		searchFrienddlastName.setForeground(Color.CYAN);
		searchFrienddlastName.setBounds(50, 100, 250, 100);
		searchFriendPanel.add(searchFrienddlastName);
		
		
		searchFrienddFirstNameTF = new JTextField("");
		searchFrienddFirstNameTF.setVisible(true);
		searchFrienddFirstNameTF.setToolTipText("Enter firstname");
		searchFrienddFirstNameTF.setHorizontalAlignment(JTextField.CENTER);
		searchFrienddFirstNameTF.setForeground(Color.GRAY);
		searchFrienddFirstNameTF.setBounds(200, 90, 250, 30);
		searchFriendPanel.add(searchFrienddFirstNameTF);

		searchFrienddlastNameTF = new JTextField("");
		searchFrienddlastNameTF.setVisible(true);
		searchFrienddlastNameTF.setToolTipText("Enter lastname");
		searchFrienddlastNameTF.setHorizontalAlignment(JTextField.CENTER);
		searchFrienddlastNameTF.setForeground(Color.GRAY);
		searchFrienddlastNameTF.setBounds(200, 140, 250, 30);
		searchFriendPanel.add(searchFrienddlastNameTF);
		
		ImageIcon updateProfileBackImage = new ImageIcon("images/create.GIF");
		searchFriendDB = new JButton(updateProfileBackImage);
		searchFriendDB.setBackground(Color.GREEN);
		searchFriendDB.setBounds(250, 200, 100, 50);
		searchFriendDB.setRolloverEnabled(true);
		searchFriendDB.setRolloverIcon(updateProfileBackImage);
		searchFriendDB.setPressedIcon(updateProfileBackImage);
		searchFriendDB.addActionListener(new GetUsersFromDBButton());
		searchFriendDB.setActionCommand("getUsersFromDB");
		searchFriendDB.setToolTipText("Search Friends");
		searchFriendPanel.add(searchFriendDB);
		
		
		ImageIcon showEventBackImage = new ImageIcon("images/customer_back.GIF");
		friendListBackProfile = new JButton(showEventBackImage);
		friendListBackProfile.setBackground(Color.GREEN);
		friendListBackProfile.setBounds(150, 200, 100, 50);
		friendListBackProfile.addActionListener(new mainNextButton());
		friendListBackProfile.setActionCommand("backAfterLogin");
		friendListBackProfile.setToolTipText("BACK");
		searchFriendPanel.add(friendListBackProfile);
		
		
		searchedUserPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		searchedUserPanel.setBounds(50, 300, 400, 600);
		searchedUserPanel.setBackground(Color.DARK_GRAY);
		searchedUserPanel.setLayout(new GridLayout(10, 1, 10, 10));
		searchFriendPanel.add(searchedUserPanel);

		
		pane.add(searchFriendPanel, "searchFriendPanel");
		
	}

	private void userProfile() {
		userProfilePanel = new JPanel(null);
		userProfilePanel.setBackground(Color.DARK_GRAY);
		
		userWelcomeMsg = new JLabel("Welcome to GIFTED...");
		userWelcomeMsg.setFont(new Font("Serif", Font.BOLD, 23));
		userWelcomeMsg.setForeground(Color.CYAN);
		userWelcomeMsg.setBounds(50, 5, 250, 100);
		userProfilePanel.add(userWelcomeMsg);

		
		addSearchFriendButton(userProfilePanel);
		addViewFriendButton(userProfilePanel);
		addViewWishListButton(userProfilePanel);
		
		ImageIcon updateProfileBackImage = new ImageIcon("images/customer_back.GIF");
		viewBackB = new JButton(updateProfileBackImage);
		viewBackB.setBackground(Color.GREEN);
		viewBackB.setBounds(350, 375, 100, 50);
		viewBackB.setRolloverEnabled(true);
		viewBackB.setRolloverIcon(updateProfileBackImage);
		viewBackB.setPressedIcon(updateProfileBackImage);
		viewBackB.addActionListener(new createBackButton());
		viewBackB.setActionCommand("backToWelcomeForm");
		viewBackB.setToolTipText("BACK");
		userProfilePanel.add(viewBackB);
		
		pane.add(userProfilePanel, "userProfilePanel");
		
		
	}
	
	
	private class validateLoginButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			CardLayout cL = (CardLayout) pane.getLayout();
			pane.getComponents();

			String username = loginUsernameTF.getText();
			String passwrd = loginUserPasswordTF.getText(); 
			
			Boolean valid = DBUtils.validateLogin(username, passwrd);
			if(valid) {
				System.out.println("Action: "+onLoginSuccessAction+" Welcome "+username);
				cL.show(pane, onLoginSuccessAction);
				userProfile.setLoginUserID(username);
				System.out.println(username+" logged in.. ");
			} else {
				loginError.setForeground(Color.RED);
				loginError.setText("Invalid Username/Password!");
				System.out.println(username+" login failed.. ");
			}
			System.out.println(username+" "+ passwrd);
		}
	}
	
	private class ViewFriendListButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			cL.show(pane, "viewFriendListPanel");
			
			ResultSet rs = DBUtils.getAllFriends(userProfile.getLoginUID());
			try {
				Border blackline = BorderFactory.createLineBorder(Color.black);
				friendsPanel.removeAll();
				while (rs.next()) {
					String userid= rs.getString(1);
					String fName = rs.getString(3);
					String lName = rs.getString(4);
					System.out.println(fName+" "+lName+" "+userid);
				
					JPanel panel1 = new JPanel(new BorderLayout());
					panel1.setBorder(blackline);
					
					JPanel namePanel = new JPanel();
					JLabel userNameLable = new JLabel();
					userNameLable.setText(fName+" "+lName);
					userNameLable.setFont(new Font("Serif", Font.PLAIN, 15));
					userNameLable.setForeground(Color.BLACK);
					namePanel.add(userNameLable);
					
					panel1.add(namePanel, BorderLayout.WEST);
					
					friendsPanel.add( panel1 );
					friendsPanel.revalidate();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private class ViewWishListButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			cL.show(pane, "viewWishListPanel");
			
			ResultSet rs = DBUtils.getUserWishList(userProfile.getLoginUID());
			try {
				Border blackline = BorderFactory.createLineBorder(Color.black);
				wishListPanel.removeAll();
				while (rs.next()) {
					//itemName, brand, color , commentItem, price, priority
					String itemName= rs.getString(1);
					String brand = rs.getString(2);
					String color = rs.getString(3);
					String commentItem = rs.getString(4);
					String price = rs.getString(5);
					String priority = rs.getString(6);
				
					JPanel panel1 = new JPanel(new BorderLayout());
					panel1.setBorder(blackline);
					
					JPanel namePanel = new JPanel();
					JLabel userNameLable = new JLabel();
					userNameLable.setText("<html> Item Name : "+itemName+"<br> Brand : "+brand+"<br>Color : "+color+""
							+ "<br>Price : "+price+"<br>Priority : "+priority+"</html>");
					userNameLable.setFont(new Font("Serif", Font.PLAIN, 15));
					userNameLable.setForeground(Color.BLACK);
					userNameLable.setPreferredSize(new Dimension(250, 100));
					namePanel.add(userNameLable);
					
					panel1.add(namePanel, BorderLayout.WEST);
					
					wishListPanel.add( panel1 );
					wishListPanel.revalidate();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private class SearchFriendsButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			cL.show(pane, "searchFriendPanel");
		}
	}
	
	private class GetUsersFromDBButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			String firstName = searchFrienddFirstNameTF.getText();
			String lastName = searchFrienddlastNameTF.getText();
			System.out.println(firstName+" : "+lastName);
			ResultSet rs = DBUtils.searchUsersByName(userProfile.getLoginUID(), firstName, lastName);
			try {
				Border blackline = BorderFactory.createLineBorder(Color.black);
				int usersCount = 0;
				searchedUserPanel.removeAll();
				while (rs.next()) {
					String userid= rs.getString(1);
					String fName = rs.getString(3);
					String lName = rs.getString(4);
					System.out.println(fName+" "+lName+" "+userid);
				
					JPanel panel1 = new JPanel(new BorderLayout());
					panel1.setBorder(blackline);
					
					JPanel namePanel = new JPanel();
					JLabel userNameLable = new JLabel();
					userNameLable.setText(fName+" "+lName);
					userNameLable.setForeground(Color.BLACK);
					namePanel.add(userNameLable);
					
					
					JPanel buttonPanel = new JPanel();
					JButton addFriendBtn = new JButton("Add friend");
					addFriendBtn.setBackground(Color.GREEN);
					addFriendBtn.addActionListener(new AddFriendButton(userid));
					addFriendBtn.setToolTipText("Add friend");
					buttonPanel.add(addFriendBtn);
					
					panel1.add(namePanel, BorderLayout.WEST);
					panel1.add(buttonPanel, BorderLayout.EAST);
					
					searchedUserPanel.add( panel1 );
					searchedUserPanel.revalidate();
					usersCount++;
				}
				if(usersCount == 0) {
					noUserFoundLabel = new JLabel("No User Found...");
					noUserFoundLabel.setFont(new Font("Verdana", Font.BOLD, 15));
					noUserFoundLabel.setForeground(Color.RED);
					noUserFoundLabel.setBounds(50, 50, 250, 100);
					searchedUserPanel.add(noUserFoundLabel);
					searchedUserPanel.revalidate();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private class AddFriendButton implements ActionListener {

		private String userid = null;
		public AddFriendButton(String userid) {
			this.userid = userid;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String userIDText=userProfile.getLoginUID();
			System.out.println("Friend Added "+this.userid+" : "+userIDText);
			DBUtils.addFriends(userProfile.getLoginUID(), this.userid);	
		}
	}
	
	



	//////////////////////////////////////////////////////////// CTROLLERS//////////////////////////////////////////////
	// -------------------------------------main (go to createProfileForm)-----------//
	private class mainNextButton implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			
			if (event.getActionCommand().equals("nextToMenuCreateProfile")) {
				cL.show(pane, "createProfileDetailForm");
			}
			if (event.getActionCommand().equals("nextToupdateProfile")) {
				onLoginSuccessAction = "updateProfileForm";
				cL.show(pane, "userLoginForm");
			}
			if (event.getActionCommand().equals("nextToViewProfile")) {
				onLoginSuccessAction = "userProfilePanel";
				cL.show(pane, "userLoginForm");
			}
			if (event.getActionCommand().equals("userLoginForm")) {
				cL.show(pane, "userLoginForm");
			}
			if(event.getActionCommand().equals("backToProfile")) {
				cL.show(pane, "updateProfileForm");
			}
			if(event.getActionCommand().equals("backAfterLogin")) {
				cL.show(pane, onLoginSuccessAction);
			}
			
			System.out.println(onLoginSuccessAction);
			
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
		
//				if(userIDChecker.getText().isEmpty()|| !(Pattern.matches("^[a-zA-Z0-9]+$", userIDTF.getText()))) {
//					userIDChecker.setForeground(Color.RED);
//					userIDChecker.setText("Invalid!");
//				}
//				else
//				{
//					userIDChecker.setForeground(Color.GREEN);
//					userIDChecker.setText("valid!");
//				}
				
//				if(userPWDChecker.getText().isEmpty()|| !(Pattern.matches("^[a-zA-Z0-9]+$", userPWDTF.getPassword()))) {
//					userPWDChecker.setForeground(Color.RED);
//					userPWDChecker.setText("Invalid!");
//				}
//				else
//				{
//					userPWDChecker.setForeground(Color.GREEN);
//					userPWDChecker.setText("valid!");
//				}
				if (Pattern.matches("^[a-zA-Z]+$",nameFirstTF.getText()) && Pattern.matches("^[a-zA-Z]+$",lastNameTF.getText()) && (genderTF.getText().equals("M") || genderTF.getText().equals("F")|| genderTF.getText().equals("m")||genderTF.getText().equals("f")) && Pattern.matches("^\\d{10}$", mobileNoTF.getText())) {
					cL.show(pane, "createEventForm");
				
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
						Connection con = DBUtils.getConnection();
						Statement st = con.createStatement();
						String sql = "INSERT INTO createprofile(userID,firstName,lastName,gender,mobileNumber,DOB,handlerLink,userPassword) VALUES ('" +userIDText+ "','" + firstNameText + "','" + lastNameText + "','" + genderText + "','" + mobileNoText
								+ "','" + DOBText + "','" + socialMediaText + "','"+userIDPWDText+"' )";
						st.executeUpdate(sql);
						st.close();
						con.close();
					} catch (Exception e) {
						e.printStackTrace();
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
				cL.show(pane, "createWishListForm");
				try {
					
					String friendFirstNameText = friendFirstNameTF.getText();
					String friendLastNameText = friendLastNameTF.getText();
					String friendMobileNoText = friendMobileTF.getText();
					userProfile.setFriend(friendFirstNameText, friendLastNameText, friendMobileNoText);
					String userIDText=userProfile.getUserID();
					//System.out.println(userIDText);
					friendFirstNameTF.setText(null);
					friendLastNameTF.setText(null);
					friendMobileTF.setText(null);
					Connection con = DBUtils.getConnection();
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
					st.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
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

				createItemTF.setText(null);
				createBrandTF.setText(null);
				createColorTF.setText(null);
				createCommentTF.setText(null);
				createPriceTF.setText(null);
				createPriorityTF.setText(null);
				String userIDText=userProfile.getUserID();
				try {
					Connection con = DBUtils.getConnection();
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
					st.close();
					con.close();
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
					//System.out.println("error2");
				}
			}

		} 
	}
//================ save wishlist update profile button=======================//
	private class wishListUpdateSaveButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			if (event.getActionCommand().equals("saveWishlistUpdateProfile")) {
				cL.show(pane, "createWishListUpdateForm");
				String itemText = createItemUpdateTF.getText();
				String brandText = createBrandUpdateTF.getText();
				String colorText = createColorUpdateTF.getText();
				String commentText = createCommentUpdateTF.getText();
				int priceText=0,priorityText=0;
				if(!(createPriceTF.getText().equals(""))&&!(createPriorityTF.getText().equals(""))) {
					priceText = Integer.parseInt(createPriceUpdateTF.getText());
					priorityText = Integer.parseInt(createPriorityUpdateTF.getText());
					wishListCreate.setPriority(priorityText);
					wishListCreate.setPrice(priceText);
				} 
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
					Connection con = DBUtils.getConnection();
					Statement st = con.createStatement();
					String sql= "select createprofile_ID from createprofile where userId='"+userIDText+"'";
					ResultSet rs =st.executeQuery(sql);
					int createprofile_IDText=0,createEventIDText=0;
					while(rs.next()){
						createprofile_IDText=rs.getInt("createprofile_ID");
					}
				//	
					//System.out.println(eventNameText);
					String sqlProfile= "select eventID from createevent where eventName='"+eventNameText+"'";
					ResultSet profileID =st.executeQuery(sqlProfile);
					while(profileID.next()) {
						createEventIDText=profileID.getInt("eventID");
					}
					//System.out.println("eventID");
					String sqlWishlist = "INSERT INTO createwishlist(createprofile_ID,eventID,itemName,brand,color,commentItem,price,priority) VALUES ('"+createprofile_IDText+"','"+createEventIDText+"', '"+itemText+ "','" + brandText + "','" + colorText + "','" + commentText +"','" + priceText + "','"+ priorityText+" ')";
					st.executeUpdate(sqlWishlist);
					st.close();
					con.close();
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
					//System.out.println("error2");
				}
			}

		} 
	}

	// login button
	private class loginNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			String userIDText = String.valueOf(loginUserIDTF.getText());
			userProfile.setLoginUserID(userIDText);
			loginUserIDTF.setText(null);
			if (event.getActionCommand().equals("nextToCreateLogin")) {
				try {
					Connection con = DBUtils.getConnection();
					Statement st = con.createStatement();
					String sql= "select userID from createprofile where userId='"+userIDText+"'";
					ResultSet rs =st.executeQuery(sql);
					String userIDValue=" ";
					while(rs.next()){
						userIDValue=rs.getString("userID");
						}
					if(!(userIDValue.equals(userIDText))) {
						loginUserIDChecker.setForeground(Color.RED);
						loginUserIDChecker.setText("UserID is Invalid!");		
					}
					else
					{
						cL.show(pane, "updateProfileForm");
					}
					st.close();
					con.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		
		}
	}

	private class loginBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToLogin")) {
				loginUserIDChecker.setText(null);
				cL.show(pane, "welcomeForm");
			}
		}
	}

	//view login
	private class viewLoginNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println(" viewLoginNextButton");
			CardLayout cL = (CardLayout) pane.getLayout();
			String viewUserIDText = String.valueOf(viewLoginUserIDTF.getText());
			userProfile.setViewLoginUserID(viewUserIDText);
			viewLoginUserIDTF.setText(null);
			if (event.getActionCommand().equals("viewProfileLogin")) {
				try {
					Boolean isValid = DBUtils.validateUser(viewUserIDText);
					if(!isValid) {
						viewLoginUserIDChecker.setForeground(Color.RED);
						viewLoginUserIDChecker.setText("UserID is Invalid!");		
					}
					else
					{
						loggedInUserID = viewUserIDText;
						cL.show(pane, "userProfilePanel");//shruthi is updating
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		
		}
	}

	private class viewLoginBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToLogin")) {
				cL.show(pane, "welcomeForm");
			}
		}
	}


	////////////////// view Profile next buttons---------------------
	private class updateProfileCreateEventButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			String userLoginIDText=userProfile.getLoginUID();
			String selectedEventText=String.valueOf(cUECB.getSelectedItem());
			userProfile.setLoginUserID(userLoginIDText);
			userProfile.setEventName(selectedEventText);
			if (event.getActionCommand().equals("nextToUpdateProfileCreateEvent")) {

				try {
					Connection con = DBUtils.getConnection();
					Statement st = con.createStatement();
					String sql= "select userID,createprofile_ID from createprofile where userId='"+userLoginIDText+"'";
					ResultSet rs =st.executeQuery(sql);
					String viewUserIDValue=" ";
					String createProfileIDText=null;
					while(rs.next()){
						viewUserIDValue=rs.getString("userID");
						createProfileIDText=rs.getString("createprofile_ID");
						}
					if(!(viewUserIDValue.equals(userLoginIDText))) {
						viewLoginUserIDChecker.setForeground(Color.RED);
						viewLoginUserIDChecker.setText("UserID is Invalid!");		
					}
					
					else {
						cL.show(pane, "createWishListUpdateProfileForm");
					}
					st.close();
					con.close();
				}catch (Exception e) {
					e.printStackTrace();
				}


			}

		}
	}
	private class updateProfileUpdateEventButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			String userLoginIDText=userProfile.getLoginUID();
			String selectedEventText=String.valueOf(sECB.getSelectedItem());
			userProfile.setLoginUserID(userLoginIDText);
			userProfile.setUpdateEventName(selectedEventText);
			System.out.println("user id value from frontend"+ userLoginIDText);
			if (event.getActionCommand().equals("nextToUpdateProfileUpdateEvent")) {

				try {
					Connection con = DBUtils.getConnection();
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
				
					System.out.println("user id value from database"+ userIDValue);
					if(!(userIDValue.equals(userLoginIDText))) {
						eventNameChecker.setForeground(Color.RED);
						eventNameChecker.setText(selectedEventText+ " is not created, please use create new event");		
					}
					
					else {
						cL.show(pane, "createWishListUpdateProfileForm");
					}
					st.close();
					con.close();
					//eventNameChecker.setText(null);
				}catch (Exception e) {
					 JOptionPane.showMessageDialog(null, "SQLException:\n" + e, "Error: login(wrong data)", JOptionPane.ERROR_MESSAGE);
				}


			}

		}
	}

	private class updateProfileBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToupdateProfile")) {
				eventNameChecker.setText(null);
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
				cL.show(pane, "welcomeForm");
			}
		}
	}

	private class showEventBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToShowEvent")) {
				cL.show(pane, "updateProfileForm");
			}
		}
	}



	//============Back button===================//
	private class createEventBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToCreateProfile")) {
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

			if (event.getActionCommand().equals("backToCreateEvent")) {
				cL.show(pane, "updateProfileForm");
			}
		}
	}

	private void connectDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/gifted_project";
			String userName = "root";
			String password = "root";
			//			Connection con = DriverManager.getConnection(url, userName, password);
			//			Statement st = con.createStatement();

		}catch (Exception e) {
		}
	}
}

