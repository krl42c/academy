
package academy;
import java.util.ArrayList;
import java.util.List;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import academy.util.UserNotFoundException;
import model.User;

@WebService(name="hello")
@SOAPBinding(style = Style.RPC)
public interface Hello {
	public String msg = "Hello";
	public ArrayList<User> userList = new ArrayList<User>();

	@WebMethod
	public String hello();

	@WebMethod
	public String test(String param);

	@WebMethod
	public User createUser(@WebParam(name = "id") int id, @WebParam(name = "name") String name);

	@WebMethod
	public User[] getUsers();

	@WebMethod
	public boolean changeUserName(@WebParam(name = "id") int id, @WebParam(name = "newName") String newName) throws UserNotFoundException;
	
	@WebMethod
	public boolean deleteUser(@WebParam(name = "id") int id) throws UserNotFoundException;

}