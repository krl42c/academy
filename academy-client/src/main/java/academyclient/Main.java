package academyclient;

import academy.Hello;
import academy.util.UserNotFoundException;
import model.User;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) throws MalformedURLException {
		
		ClientService es = new ClientService(new URL("http://localhost:8080/hello/hello?wsdl"),
				new QName("http://academy/", "HelloImplService"));
		Hello h = es.getHelloPort();
		
		// Test all endpoints
		
		User user = h.createUser(2, "Juan");
		User[] userList = h.getUsers();
		
		try {
			h.changeUserName(2, "Pedro");
			h.deleteUser(2);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
