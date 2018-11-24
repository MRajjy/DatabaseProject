package dataAccess;
import dataTransfer.Profile;
public interface ProfileDao {
    public void insertProfile(Profile profile);
    public Profile getProfileByEmail(String username);
    public Profile getProfileById(int id);
}