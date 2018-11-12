/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataTransfer;

import java.sql.Blob;

/**
 *
 * @author Kendal Howse
 */
public class Profile {
    
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String filename;
    private Blob blob;
    
    public Profile(){
        this(0, "", "", "", "", "");
    }
    
    public Profile(int id, String firstName, String lastName, String email, String password, String filename){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.filename = filename;
    }
    
    public Profile(int id, String firstName, String lastName, String email, String password, Blob blob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.blob= blob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return filename;
    }

    public void setProfilePicture(String profilePicture) {
        this.filename = profilePicture;
    }
    
    public Blob getProfilePictureBlob() {
        return this.blob;
    }
    
    public void setProfilePictureBlob(Blob blob) {
        this.blob = blob;
    }
    
}
