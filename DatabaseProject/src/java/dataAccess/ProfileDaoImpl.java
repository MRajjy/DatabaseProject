package dataAccess;

import dataTransfer.Profile;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Christopher Labelle
 */
public class ProfileDaoImpl implements ProfileDao {
	
    DataSource dataSource;

    public ProfileDaoImpl() {
        dataSource = new DataSource();
    }

    @Override
    public void insertProfile(Profile profile) {
        this.dataSource.openConnection();
        Connection connection = this.dataSource.getConnection();
        PreparedStatement pstmt = null;
        try{
            if(connection == null || connection.isClosed()) {
                System.out.println("Cannot insert profile, no connection or connection closed");
            }
//            FileInputStream fis = new FileInputStream(new File(profile.getFileName()));
            pstmt = connection.prepareStatement(
                        "INSERT INTO profiles(database columns) " +
                        "VALUES(?, ?)");
//            pstmt.setString(1, profile.getFileName());
//            pstmt.setBinaryStream(2, fis);
//            pstmt.executeUpdate();
        }
        catch(SQLException e){
            System.out.print(e.getMessage());
        } 
        //catch (FileNotFoundException e) {
            //System.out.println(e.getMessage());
        //}
        finally{
            try{ 
                this.dataSource.closeConnection();
                if(pstmt != null){ pstmt.close(); }
            }
            catch(SQLException e){System.out.println(e.getMessage());}
        }
    }

    @Override
    public Profile getProfileByUsername(String username) {
        dataSource.openConnection();
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Profile profile = null;
        try{
            pstmt = connection.prepareStatement(
                            "SELECT * FROM profiles WHERE username LIKE(?)");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            rs.next();
            profile = new Profile();
//            profile.setId(rs.getInt("id"));
//            profile.setFirstName(rs.getString("firstname"));
//            profile.setLastName(rs.getString("lastname"));
//            profile.setPicture(rs.getBlob("picture");
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            try{ if(rs != null){ rs.close(); }}
            catch(SQLException e){System.out.println(e.getMessage());}
            try{ if(pstmt != null){ pstmt.close(); }}
            catch(SQLException e){System.out.println(e.getMessage());}
            try{ if(connection != null){ connection.close(); }}
            catch(SQLException e){System.out.println(e.getMessage());}
        }
        return profile;
    }
}