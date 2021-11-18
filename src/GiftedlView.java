
import java.awt.*;
import javax.swing.*;
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
	Container pane = getContentPane();
	private JPanel mainP, createP, createEventP, createWishListP, loginP, updateP, showEventP; // panels for CardLayout
	private JLabel titleL, profileC, profileInfo, profileV, profileU,friendProfileInfo; // inside the panel of mainP
	private JButton mainNextC, mainNextV,mainNextU;
	private JLabel firstNameL, mainTitleL,lastNameL, mobileNoL, socialMediaL, birthDateL, eventL, genderL, loginUsernameL,
			loginUserLastNameL, loginPasswordL, friendFirstNameL, friendLastNameL; // inside the panel of createP
	private JLabel firstNameChecker, lastNameChecker, genderChecker, contactChecker;
	private JTextField nameFirstTF, firstNameTF, lastNameTF, locationTF, contactTF, mobileNoTF, genderTF, socialMediaTF,
			loginPasswordTF, loginUserIDTF, loginMobileNoTF, nameFriendFirstTF, lastFriendNameTF, friendFirstNameTF,
			friendLastNameTF;
	private JLabel socialMediaLinkChecker, DOBChecker,userIDChecker,loginUserIDChecker,eventNameChecker;
	private JButton createNextB, createBackB, loginNextB, loginBackB,updtateNextB;
	private JComboBox bMCB, bDCB, bYCB,cDECB,sECB;
	private JTextField createTF,userIDTF;
	private JLabel createEventL, updateEventL,userIDL,updateL, createWishListL, updateWishListL, showWishListL, showEventL,
			friendMobileNoL;
	private JTextField createEventTF, updateEventTF, createWishListTF, updateWishListTF, showWishListTF, friendMobileTF;
	// private JLabel firstNameChecker, lastNameChecker, genderChecker,
	// contactChecker;
	private JButton customerNextB, customerBackB, viewNextB, viewBackB,createWishListSaveB;
	private JComboBox cECB, uECB, showEventCB;
	private JLabel createItemL, createBrandL,showItemL, createColorL, createCommentL, createPriceL, createPriorityL; // inside the
	private JTextField createItemTF, createBrandTF, createColorTF, createCommentTF, createPriceTF, createPriorityTF;
	private JButton createWishListBackB, showEventBackB;
	private JTextArea carDetailsTA;


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
		mainNextC.setBackground(Color.CYAN);
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
		mainNextV.setBackground(Color.CYAN);
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
		mainNextU.setBackground(Color.CYAN);
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
		
		
		userIDL = new JLabel("UserID:");
		userIDL.setFont(new Font("Verdana", Font.BOLD, 15));
		userIDL.setForeground(Color.CYAN);
		userIDL.setBounds(50, 340, 150, 100);
		createP.add(userIDL);
		
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
//=============create event page==================//
		ImageIcon dateNextImage = new ImageIcon("images/create.GIF");
		createNextB = new JButton(dateNextImage);
		createNextB.setBackground(Color.CYAN);
		createNextB.addActionListener(new createNextButton());
		createNextB.setBounds(550, 500, 100, 50);
		createNextB.setActionCommand("nextToCreateProfile");
		createP.add(createNextB);
		// =========to go back welcome section====//
		ImageIcon dateBackImage = new ImageIcon("images/back.GIF");
		createBackB = new JButton(dateBackImage);
		createBackB.setBackground(Color.CYAN);
		createBackB.setBounds(380, 500, 100, 50);
		createBackB.addActionListener(new createBackButton());
		createBackB.setActionCommand("backToWelcomeForm");
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
		customerNextB.setBackground(Color.CYAN);
		customerNextB.setBounds(550, 300, 100, 50);
		customerNextB.setRolloverEnabled(true);
		customerNextB.setRolloverIcon(createEventNextImage);
		customerNextB.setPressedIcon(createEventNextImage);
		customerNextB.addActionListener(new createEventNextButton());
		customerNextB.setActionCommand("nextToCreateEvent");
		createEventP.add(customerNextB);

		//=========back to Create event page===========================//
		ImageIcon createEventBackImage = new ImageIcon("images/customer_back.GIF");
		customerBackB = new JButton(createEventBackImage);
		customerBackB.setBackground(Color.CYAN);
		customerBackB.setBounds(350, 300, 100, 50);
		customerBackB.setRolloverEnabled(true);
		customerBackB.setRolloverIcon(createEventBackImage);
		customerBackB.setPressedIcon(createEventBackImage);
		customerBackB.addActionListener(new createEventBackButton());
		customerBackB.setActionCommand("backToCreateProfile");
		createEventP.add(customerBackB);
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
		createWishListBackB.setBackground(Color.CYAN);
		createWishListBackB.setBounds(330, 400, 100, 50);
		createWishListBackB.setRolloverEnabled(true);
		createWishListBackB.setRolloverIcon(createWishListBackImage);
		createWishListBackB.setPressedIcon(createWishListBackImage);
		createWishListBackB.addActionListener(new createWishListBackButton());
		createWishListBackB.setActionCommand("backToCreateEvent");
		createWishListP.add(createWishListBackB);
		pane.add(createWishListP, "createWishListForm");
	
		ImageIcon wishListSavekImage = new ImageIcon("images/create.GIF");
		createWishListSaveB = new JButton(wishListSavekImage);
		createWishListSaveB.setBackground(Color.CYAN);
		createWishListSaveB.setBounds(530, 400, 100, 50);
		createWishListSaveB.setRolloverEnabled(true);
		createWishListSaveB.setRolloverIcon(wishListSavekImage);
		createWishListSaveB.setPressedIcon(wishListSavekImage);
		createWishListSaveB.addActionListener(new wishListSaveButton());
		createWishListSaveB.setActionCommand("saveWishlist");
		createWishListP.add(createWishListSaveB);
		//pane.add(createWishListP, "createWishListForm");
		
		
		// view profile details==========//
		loginP = new JPanel(null);
		loginP.setBackground(Color.DARK_GRAY);

		loginUsernameL = new JLabel("UserID:");
		loginUsernameL.setFont(new Font("Verdana", Font.BOLD, 15));
		loginUsernameL.setForeground(Color.CYAN);
		loginUsernameL.setBounds(50, 1, 250, 100);
		loginP.add(loginUsernameL);

		loginUserIDTF = new JTextField(""); // set as 10 ha
		loginUserIDTF.setHorizontalAlignment(JTextField.CENTER);
		loginUserIDTF.setToolTipText("Enter your userid");
		loginUserIDTF.setForeground(Color.GRAY);
		loginUserIDTF.setBounds(300, 40, 250, 30);
		loginP.add(loginUserIDTF);
		
		loginUserIDChecker = new JLabel("");
		loginUserIDChecker.setFont(new Font("Serif", Font.BOLD, 10));
		loginUserIDChecker.setBounds(500, 40, 100, 100);
		createP.add(loginUserIDChecker);
		pane.add(loginP, "loginForm");
//===========Login page next button=============//
		ImageIcon loginNextImage = new ImageIcon("images/create.GIF");
		loginNextB = new JButton(loginNextImage);
		loginNextB.setBackground(Color.CYAN);
		loginNextB.setBounds(550, 200, 100, 50);
		loginNextB.setRolloverEnabled(true);
		loginNextB.setRolloverIcon(loginNextImage);
		loginNextB.setPressedIcon(loginNextImage);
		loginNextB.addActionListener(new loginNextButton());
		loginNextB.setActionCommand("nextToCreateLogin");
		loginP.add(loginNextB);

//============bcak to login page==================//
		ImageIcon loginBackImage = new ImageIcon("images/customer_back.GIF");
		loginBackB = new JButton(loginBackImage);
		loginBackB.setBackground(Color.CYAN);
		loginBackB.setBounds(350, 200, 100, 50);
		loginBackB.setRolloverEnabled(true);
		loginBackB.setRolloverIcon(loginBackImage);
		loginBackB.setPressedIcon(loginBackImage);
		loginBackB.addActionListener(new loginBackButton());
		loginBackB.setActionCommand("backToLogin");
		loginP.add(loginBackB);
		
		pane.add(loginP, "loginForm");
	//======================================//
		updateP = new JPanel(null);
		updateP.setBackground(Color.DARK_GRAY);
		ImageIcon imageUpdateProfile = new ImageIcon("images/updateProfile1.JPG");
		// Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
		updateL = new JLabel(imageUpdateProfile);
		updateL.setBounds(280, 0, 800, 575);
		updateP.add(updateL);
		
		updateEventL = new JLabel(" Update your profile");
		updateEventL.setFont(new Font("Serif", Font.BOLD, 26));
		updateEventL.setForeground(Color.CYAN);
		updateEventL.setBounds(10, 1, 250, 100);
		updateP.add(updateEventL);
		
		showEventL = new JLabel(" Update Event");
		showEventL.setFont(new Font("Serif", Font.BOLD, 23));
		showEventL.setForeground(Color.CYAN);
		showEventL.setBounds(45, 50, 250, 100);
		updateP.add(showEventL);
		
		String[] showEventCB = {};
		sECB=new JComboBox(showEventCB);
		sECB.setBounds(50, 130, 125, 30);
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
				sECB.addItem(eventNameText);
				}
			st.close();
			con.close();
			}catch (Exception e) {
			}
        updateP.add(sECB);
		eventNameChecker=new JLabel("");
		eventNameChecker.setFont(new Font("Serif", Font.BOLD, 14));
		eventNameChecker.setBounds(150, 130, 500, 100);
		updateP.add(eventNameChecker);
		pane.add(updateP, "updateProfileForm");

		//========== vieProfile buttons==================//

		ImageIcon updateProfileNextImage = new ImageIcon("images/create.GIF");
		updtateNextB = new JButton(updateProfileNextImage);
		updtateNextB.setBackground(Color.CYAN);
		updtateNextB.setBounds(150, 300, 100, 50);
		updtateNextB.setRolloverEnabled(true);
		updtateNextB.setRolloverIcon(updateProfileNextImage);
		updtateNextB.setPressedIcon(updateProfileNextImage);
		updtateNextB.addActionListener(new updateProfileNextButton());
		updtateNextB.setActionCommand("nextToupdateProfile");
		updateP.add(updtateNextB);

	//============back to view profile button=================//
		ImageIcon updateProfileBackImage = new ImageIcon("images/customer_back.GIF");
		viewBackB = new JButton(updateProfileBackImage);
		viewBackB.setBackground(Color.CYAN);
		viewBackB.setBounds(25, 300, 100, 50);
		viewBackB.setRolloverEnabled(true);
		viewBackB.setRolloverIcon(updateProfileBackImage);
		viewBackB.setPressedIcon(updateProfileBackImage);
		viewBackB.addActionListener(new updateProfileBackButton());
		viewBackB.setActionCommand("backToupdateProfile");
		updateP.add(viewBackB);
		pane.add(updateP, "updateProfileForm");
		//=============show event and wishlist page===============
		showEventP = new JPanel(null);
		showEventP.setBackground(Color.DARK_GRAY);

		createEventL = new JLabel("Display Event:");
		createEventL.setFont(new Font("Serif", Font.BOLD, 23));
		createEventL.setForeground(Color.CYAN);
		createEventL.setBounds(150, 1, 250, 100);
	//	showEventP.add(createEventL);

//		String[] showEventCB = { "BirthDay", "Wedding", "Anniversery", "GraduationDay", "BabyShower" };
//		cDECB = new JComboBox(showEventCB);
//		cDECB.setBounds(150, 75, 160, 25);
//		showEventP.add(cDECB);

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
		showEventBackB.setBackground(Color.CYAN);
		showEventBackB.setBounds(350, 200, 100, 50);
		showEventBackB.setRolloverEnabled(true);
		showEventBackB.setRolloverIcon(showEventBackImage);
		showEventBackB.setPressedIcon(showEventBackImage);
		showEventBackB.addActionListener(new showEventBackButton());
		showEventBackB.setActionCommand("backToShowEvent");
		showEventP.add(showEventBackB);
		pane.add(showEventP, "showEventForm");

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
				cL.show(pane, "loginForm");
			}
			if (event.getActionCommand().equals("nextToViewProfile")) {
				cL.show(pane, "loginForm");
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
				if (socialMediaTF.getText().isEmpty() || !(Pattern.matches("^http.?:\\/\\/.*|HTTP.?:\\/\\/.*",socialMediaTF.getText()))) { // for socialMediaLink
					socialMediaLinkChecker.setForeground(Color.RED);
                    socialMediaLinkChecker.setText("Invalid!");
				}
				else {
					socialMediaLinkChecker.setForeground(Color.GREEN);
					socialMediaLinkChecker.setText("valid!");
				}
				if(userIDChecker.getText().isEmpty()|| !(Pattern.matches("^[a-zA-Z0-9]+$", userIDTF.getText()))) {
					userIDChecker.setForeground(Color.RED);
					userIDChecker.setText("Invalid!");
				}
				else
				{
					userIDChecker.setForeground(Color.GREEN);
					userIDChecker.setText("valid!");
				}
				if (Pattern.matches("^[a-zA-Z]+$",nameFirstTF.getText()) && Pattern.matches("^[a-zA-Z]+$",lastNameTF.getText()) && (genderTF.getText().equals("M") || genderTF.getText().equals("F")|| genderTF.getText().equals("m")||genderTF.getText().equals("f")) && Pattern.matches("^\\d{10}$", mobileNoTF.getText()) && Pattern.matches("^http.?:\\/\\/.*|HTTP.?:\\/\\/.*",socialMediaTF.getText())&&(Pattern.matches("^[a-zA-Z0-9]+$", userIDTF.getText()))) {
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
					userProfile.setUserProfile(firstNameText, lastNameText, genderText, mobileNoText, DOBText,
							socialMediaText, userIDText);
					socialMediaTF.setText(null);
					nameFirstTF.setText(null);
					lastNameTF.setText(null);
					genderTF.setText(null);
					mobileNoTF.setText(null);
					userIDTF.setText(null);
					try {
						String url = "jdbc:mysql://localhost:3306/gifted_project";
						String userName = "root";
						String password = "root";
						Connection con = DriverManager.getConnection(url, userName, password);
						Statement st = con.createStatement();
						String sql = "INSERT INTO createprofile(userID,firstName,lastName,gender,mobileNumber,DOB,handlerLink) VALUES ('" +userIDText+ "','" + firstNameText + "','" + lastNameText + "','" + genderText + "','" + mobileNoText
								+ "','" + DOBText + "','" + socialMediaText + "')";
						st.executeUpdate(sql);
						st.close();
						con.close();
					} catch (Exception e) {

					}
				}

			} 
		}
	}
	
	private class createEventNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			if (event.getActionCommand().equals("nextToCreateEvent")) {
				cL.show(pane, "createWishListForm");
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
					st.close();
					con.close();
				} catch (Exception e) {

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
 				 st.close();
				 con.close();
				} catch (Exception e) {
					System.out.println(e);
				//	e.printStackTrace();
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
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";
				
					Connection con = DriverManager.getConnection(url, userName, password);
					Statement st = con.createStatement();
					String sql= "select userID from createprofile where userId='"+userIDText+"'";
					ResultSet rs =st.executeQuery(sql);
					String userIDValue=null;
					 while(rs.next()){
						userIDValue=rs.getString("userID");
				         }
					// System.out.println("userID "+ userIDValue);
					 if(!(userIDValue.equals(null))) {
				cL.show(pane, "updateProfileForm");
					 }
					 st.close();
					 con.close();
			}catch (Exception e) {
				
			}
			}
			else
			{
				loginUserIDChecker.setForeground(Color.RED);
				loginUserIDChecker.setText("UserID is Invalid!");
			}
		}
	}

	private class loginBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToLogin")) {
				cL.show(pane, "welcomeForm");
			}
		}
	}
	


	////////////////// view Profile next buttons---------------------
	private class updateProfileNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			 String userLoginIDText=userProfile.getLoginUID();
			 String selectedEventText=String.valueOf(sECB.getSelectedItem());
			 System.out.print(selectedEventText);
			 System.out.println("user id "+userLoginIDText);
			if (event.getActionCommand().equals("nextToupdateProfile")) {
				
				try {
					String url = "jdbc:mysql://localhost:3306/gifted_project";
					String userName = "root";
					String password = "root";
					String eventNameText=null;
					Connection con = DriverManager.getConnection(url, userName, password);
					Statement st = con.createStatement();
					String sql= "select distinct e.eventName from createprofile a inner join createwishlist b on a.createprofile_ID=b.createprofile_ID join createevent e on b.eventID=e.eventID where a.userID='"+userLoginIDText
							+"'";
							
					ResultSet rs =st.executeQuery(sql);
					while(rs.next()){
						 eventNameText=rs.getString("eventName");
						 System.out.println("event name is " +eventNameText);
				         }
                     System.out.println("eventName "+eventNameText);
					 if(!(eventNameText.equals(selectedEventText))) {
						    eventNameChecker.setForeground(Color.RED);
						    eventNameChecker.setText(selectedEventText +" is not created");
					 }
					 else {
						 cL.show(pane, "showEventForm");
					 }
					 st.close();
					 con.close();
			}catch (Exception e) {
				
			}
			
				
			}
				
			}
		}
	

	private class updateProfileBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToupdateProfile")) {
				cL.show(pane, "loginForm");
			}
		}
	}

//============back to welcome form================//
	private class createBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToWelcomeForm")) {
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
//	private void printstack(Exception e) {
//		// TODO Auto-generated method stub
//		
//
//	}
	
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

