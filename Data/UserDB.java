package Data;

import Util.ConnectionPool;
import Util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.User;
import Constants.UserConstants;
import Util.PasswordUtil;

public class UserDB {

	
     public static User getUser(String email) {
	         ConnectionPool pool = ConnectionPool.getInstance();
                Connection connection = pool.getConnection();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try {
	            ps = connection.prepareStatement(UserConstants.GET_USER);
	            ps.setString(1, email);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	            	User user = new User();
	            	user.setName(rs.getString("name"));
	            	user.setEmail(rs.getString("username"));
	            	user.setUserType(rs.getString("type"));
	            	user.setNumPostedStudies(rs.getInt("studies"));
	            	user.setNumParticipation(rs.getInt("participation"));
	            	user.setNumCoins(rs.getInt("coins"));
	               return user;
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	            return null;
	        } finally {
	            DbUtil.closeResultSet(rs);
	            DbUtil.closePreparedStatement(ps);
	            pool.freeConnection(connection);
	        }
	        return null;
	    }
     
     
	  public static List<User> getUsers() {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	       ArrayList<User> users = new ArrayList<User>();
	        try {
	            ps = connection.prepareStatement(UserConstants.GET_USERS);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	            	User user = new User();
	               	user.setName(rs.getString("name"));
	            	user.setEmail(rs.getString("username"));
	            	user.setUserType(rs.getString("type"));
	            	user.setNumPostedStudies(rs.getInt("studies"));
	            	user.setNumParticipation(rs.getInt("participation"));
	            	user.setNumCoins(rs.getInt("coins"));
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	            return null;
	        } finally {
	            DbUtil.closeResultSet(rs);
	            DbUtil.closePreparedStatement(ps);
	            pool.freeConnection(connection);
	        }
	        return users;
	    }
     
	 public static boolean validateUser(String email, String pwd) {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
                try {
	            ps = connection.prepareStatement(UserConstants.VALIDATE_USER);
	            ps.setString(1, email);
	            ps.setString(2, PasswordUtil.hashPassword(pwd));
	            rs= ps.executeQuery();
	            while (rs.next())
	            {
	             return true;
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	            return false;
	        } finally {
	            DbUtil.closePreparedStatement(ps);
	            pool.freeConnection(connection);
	        }
			return false;
	    }


    public static int addUser(User user) {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        PreparedStatement ps = null;

	        try {
	            ps = connection.prepareStatement(UserConstants.ADD_USER);
	            ps.setString(1, user.getEmail());
	            ps.setString(2, user.getPassword());
	            ps.setString(3, user.getUserType());
	            ps.setInt(4, user.getNumPostedStudies());
	            ps.setInt(5, user.getNumParticipation());
	            ps.setInt(6, user.getNumCoins());
	            ps.setString(7, user.getName());
	            return ps.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e);
	            return 0;
	        } finally {
	            DbUtil.closePreparedStatement(ps);
	            pool.freeConnection(connection);
	        }
	    }
	 
	 public static void updateParticipation(String email, int parNum) {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        PreparedStatement ps = null;
	        try {
	            ps = connection.prepareStatement(UserConstants.UPDATE_PARTICIPATION);
	            ps.setInt(1, parNum);
	            ps.setString(2, email);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e);
	          
	        } finally {
	            DbUtil.closePreparedStatement(ps);
	            pool.freeConnection(connection);
	        }
	    }

	 public static void updateCoins(String email, int coins) {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        PreparedStatement ps = null;
	        try {
	            ps = connection.prepareStatement(UserConstants.UPDATE_COINS);
	            ps.setInt(1, coins);
	            ps.setString(2, email);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e);
	          
	        } finally {
	            DbUtil.closePreparedStatement(ps);
	            pool.freeConnection(connection);
	        }
	    }
}
