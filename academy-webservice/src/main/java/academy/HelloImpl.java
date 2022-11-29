
package academy;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import academy.util.UserNotFoundException;
import model.User;


@WebService(endpointInterface = "academy.Hello")
public class HelloImpl implements Hello {
	
	@Override
	public String hello() {
		return "Hello world";
	}
	
	@Override
	public String test(String param) {
		return param;
	}
	
	@Override
	public User createUser(int id, String name) {
		User u = new User(id, name);
		userList.add(u);
		return u;
	}
	
	@Override
	public User[] getUsers() {
		return userList.toArray(new User[0]);
	}
	
	@Override
	public boolean changeUserName(int id, String newName) throws UserNotFoundException {
		for(User u : userList) {
			if(u.getId() == id) {
				u.setName(newName);
				return true;
			}
		}
		throw new UserNotFoundException();
	}
	
	@Override
	public boolean deleteUser(int id) throws UserNotFoundException {
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getId() == id) {
				userList.remove(i);
				return true;
			}
		}
		throw new UserNotFoundException();
	}
	
}