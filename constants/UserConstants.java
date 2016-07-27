package Constants;

import java.util.logging.Logger;
/**
 *
 * @author RAVITEJA
 */
public final class UserConstants {
	public static final Logger LOG = Logger.getLogger("Constants");

	private UserConstants() {
		new UserConstants();
	}
	public static final String ADD_USER = "INSERT INTO User "
	                + "(username, password, type, studies, participation, coins, name) "
	                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_USER = "SELECT * from User WHERE username = ?";
	public static final String GET_USERS = "SELECT * from User";
	public static final String VALIDATE_USER = "select * FROM User WHERE username = ? and password = ?";
	public static final String UPDATE_PARTICIPATION = "UPDATE User SET "
	                + "Participation = ? "
	                + "WHERE username = ? ";
	public static final String UPDATE_COINS = "UPDATE User SET "
	                + "coins = ? "
	                + "WHERE username = ? ";
        public static final String INVALID_USER = "Invalid User";
        public static final String EMAIL_EXISTS = "EMAIL ALREADY EXISTS...!!";
        public static final String PASSWORDS_DONOT_MATCH = "PASSWORDS DO NOT MATCH....!!";
	
}
