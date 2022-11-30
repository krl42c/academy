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
	public static void main(String args[]) throws MalformedURLException, UserNotFoundException {
		
		ClientService es = new ClientService(new URL("http://localhost:8080/hello/hello?wsdl"),
				new QName("http://academy/", "HelloImplService"));
		Hello clientPort = es.getHelloPort();
		
		
		clientPort.createUser(2, "Juan");
		clientPort.createUser(3, "Karol");
		
		User[] userList = clientPort.getUsers();
		
		for(User u : userList) {
			System.out.println("ID: " + u.getId() + " | Name: " + u.getName());
		}
		
		System.out.println(clientPort.changeUserName(2, "Pedro"));
		System.out.println(clientPort.deleteUser(2));
	
	}
}
