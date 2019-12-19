package dao;

import java.util.List;
import model.User;

public interface UserDAO {
	
	public void addUser(User u);
	
	public boolean checkUser(String username);
        
   
	
	public boolean login(String username, String password);
	
	public void updateUser(User u);
	
	public User getUser(String username);
        
        public List<User> getList();
        
        public void deleteUser(int id_user);

}
