import java.sql.*; 

public class DBUtils {
	
	static Connection connection;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/se_project?characterEncoding=latin1&useConfigs=maxPerformance", "root", "root");
			return connection;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static Boolean validateLogin(String username, String password) {
		Boolean isValid = false;
		try {
			getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select userId, userPassword from createprofile where userId='"+username+"' and userPassword='"+password+"'");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2));
				if(rs.getString(1).equalsIgnoreCase(username) && rs.getString(2).equalsIgnoreCase(password)) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return isValid;
	}
	
	public static Boolean validateUser(String viewUserIDText) {
		System.out.println("validateUser"+viewUserIDText);
		Boolean isValid = false;
		try {
			getConnection();
			String sql= "select userID from createprofile where userId='"+viewUserIDText+"'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			String viewUserIDValue=" ";
			while (rs.next()) {
				System.out.println(rs.getString(1));
				viewUserIDValue=rs.getString("userID");
			}
			return (viewUserIDValue.equals(viewUserIDText));
		} catch (Exception e) {
			System.out.println(e);
		}
		return isValid;
	}

	public static ResultSet searchUsersByName(String loginUser, String firstName, String lastName) {
		
		//select * from createprofile c where createprofile_ID not in (select TO_CREATE_PROFILE_ID_FK from friends where FROM_CREATE_PROFILE_ID_FK=1)
		System.out.println("searchUsersByName "+firstName+" : "+lastName);
		try {
			Integer loginUserID = getLoginUserIDByUsername(loginUser);
			getConnection();
			String sql= "SELECT createprofile_ID, userid, firstname, lastname FROM createprofile "
					+ "where (lower(firstname) like lower('%"+firstName+"%') or lower(lastname) like lower('%"+lastName+"%'))"
							+ " and createprofile_ID not in (select TO_CREATE_PROFILE_ID_FK from friends where FROM_CREATE_PROFILE_ID_FK="+loginUserID+")";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void addFriends(String loginUID, String userId) {
		Integer loginUserID = getLoginUserIDByUsername(loginUID);
		if(loginUserID != null) {
			String query1 = "insert into friends (FROM_CREATE_PROFILE_ID_FK, TO_CREATE_PROFILE_ID_FK) values ("+loginUserID+", "+userId+")";
			String query2 = "insert into friends (FROM_CREATE_PROFILE_ID_FK, TO_CREATE_PROFILE_ID_FK) values ("+userId+", "+loginUserID+")";
			getConnection();
			Statement stmt;
			try {
				stmt = connection.createStatement();
				stmt.executeUpdate(query1);
				stmt.executeUpdate(query2);
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Userid is null");
		}
	}

	private static Integer getLoginUserIDByUsername(String loginUID) {
		System.out.println("getLoginUserIDByUsername : "+loginUID);
		Integer userid = null;
		try {
			getConnection();
			String sql= "select userID, createprofile_ID from createprofile where userId='"+loginUID+"'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString(1)+" === "+rs.getInt(2));
				if(rs.getString(1).equals(loginUID)) {
					userid = rs.getInt(2);
					break;
				}
			}
			System.out.println("userid: "+userid);
			return userid;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static ResultSet getAllFriends(String loginUID) {
		Integer loginUserID = getLoginUserIDByUsername(loginUID);
		if(loginUserID != null) {
			try {
				String sql = "SELECT createprofile_ID, userid, firstname, lastname FROM createprofile "
						+ "where createprofile_ID in (select TO_CREATE_PROFILE_ID_FK from friends where FROM_CREATE_PROFILE_ID_FK="+loginUserID+")";
				Statement stmt = connection.createStatement();
				return stmt.executeQuery(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static ResultSet getUserWishList(String loginUID) {
		Integer loginUserID = getLoginUserIDByUsername(loginUID);
		if(loginUserID != null) {
			try {
				String sql = "SELECT itemName, brand, color , commentItem, price, priority FROM createwishlist where createprofile_ID="+loginUserID+"";
				Statement stmt = connection.createStatement();
				return stmt.executeQuery(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
