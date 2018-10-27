package dataAccess;
import dataTransfer.Profile;
public interface ProfileDao {
	public void insertProfile(Profile profile);
	public Profile getProfileByUsername(String username);
}