package academy;
import javax.jws.*;
import javax.xml.ws.Endpoint;

public class Main {
	public static void main(String args[]) {
		Endpoint.publish("http://localhost:1515/hello", new HelloImpl());
	}
}
