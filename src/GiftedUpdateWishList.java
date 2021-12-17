
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.regex.Pattern;

//import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import GiftedlView.createWishListUpdateBackButton;
import GiftedlView.wishListUpdateSaveButton;

public class GiftedUpdateWishList extends JFrame {
	Container paneNew = getContentPane();
	
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
	private JLabel socialMediaLinkChecker, DOBChecker,userIDChecker,loginUserIDChecker,eventNameChecker,viewLoginUserIDChecker,userPWDChecker,eventNameCreateChecker;
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
	
	public void GiftedlViewENew() {
		pane.setLayout(new CardLayout());
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

		createItemUpdateTF = new JTextField(null);
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
	}	
		private class wishListUpdateSaveButton implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				CardLayout cL = (CardLayout) paneNew.getLayout();
				if (event.getActionCommand().equals("saveWishlistUpdateProfile")) {
					cL.show(paneNew, "createWishListUpdateForm");
					String itemText = createItemUpdateTF.getText();
					String brandText = createBrandUpdateTF.getText();
					String colorText = createColorUpdateTF.getText();
					String commentText = createCommentUpdateTF.getText();
					System.out.println("itemText "+itemText);
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
					//	
						//System.out.println(eventNameText);
						String sqlProfile= "select eventID from createevent where eventName='"+eventNameText+"'";
						ResultSet profileID =st.executeQuery(sqlProfile);
						while(profileID.next()) {
							createEventIDText=profileID.getInt("eventID");
						}
						//System.out.println("eventID");
						String sqlWishlist = "INSERT INTO createwishlist(createprofile_ID,eventID,itemName,brand,color,commentItem,price,priority) VALUES ('"+createprofile_IDText+"','"+createEventIDText+"', '"+itemText+ "','" + brandText + "','" + colorText + "','" + commentText +"','" + priceText + "','"+ priorityText+" ')";
						JOptionPane.showMessageDialog(null, "Inserted successfully!");  	
						st.executeUpdate(sqlWishlist);
						st.close();
						con.close();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "SQLException:\n" + e, "Error: CreateWishListSave(wrong data)", JOptionPane.ERROR_MESSAGE);
					}
				}

			} 
		}

		private class createWishListUpdateBackButton implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				CardLayout cL = (CardLayout) pane.getLayout();
				eventNameCreateChecker.setText(null);
				if (event.getActionCommand().equals("backToCreateEvent")) {
					cL.show(pane, "updateProfileForm");
				}
			}
		}
		}

