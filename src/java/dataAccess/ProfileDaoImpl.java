package dataAccess;

import dataTransfer.Profile;
import java.io.File;
import java.io.FileInputStream;
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
            pstmt = connection.prepareStatement(
                        "INSERT INTO sample_user(id, fname, lname, email, password, picture) " +
                        "VALUES(id.nextval, ?, ?, ?, ?, ?)");
            pstmt.setString(1, profile.getFirstName());
            pstmt.setString(2, profile.getLastName());
            pstmt.setString(3, profile.getEmail());
            pstmt.setString(4, profile.getPassword());
            pstmt.setBlob(5, profile.getInputStream());
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            System.out.print(e.getMessage());
        } 
//        catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
        finally{
            try{ 
                this.dataSource.closeConnection();
                if(pstmt != null){ pstmt.close(); }
            }
            catch(SQLException e){System.out.println(e.getMessage());}
        }
    }

    @Override
    public Profile getProfileByEmail(String email) {
        dataSource.openConnection();
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Profile profile = null;
        try{
            pstmt = connection.prepareStatement(
                            "SELECT * FROM sample_user WHERE email LIKE(?)");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            rs.next();
            profile = new Profile();
            profile.setId(rs.getInt("id"));
            profile.setFirstName(rs.getString("fname"));
            profile.setLastName(rs.getString("lname"));
            profile.setEmail("email");
            profile.setPassword("password");
            profile.setProfilePictureBlob(rs.getBlob("picture"));
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
    
    @Override
    public Profile getProfileById(int id) {
        dataSource.openConnection();
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Profile profile = null;
        try{
            pstmt = connection.prepareStatement(
                            "SELECT * FROM sample_user WHERE id LIKE(?)");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            rs.next();
            profile = new Profile();
            profile.setId(rs.getInt("id"));
            profile.setFirstName(rs.getString("fname"));
            profile.setLastName(rs.getString("lname"));
            profile.setEmail("email");
            profile.setPassword("password");
            profile.setProfilePictureBlob(rs.getBlob("picture"));
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