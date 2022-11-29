package academyclient;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

import academy.Hello;

@WebServiceClient(targetNamespace = "http://localhost:8080/", wsdlLocation = "http://localhost:8080/hello/hello?wsdl", name = "HelloImplService")
public class ClientService extends Service {
	
	protected ClientService(URL wsdlDocumentLocation, QName serviceName) {
		super(wsdlDocumentLocation, serviceName);
	}

	@WebEndpoint(name = "hello")
	public Hello getHelloPort() {
		return super.getPort(new QName("http://academy/", "HelloImplPort"), Hello.class);
	}	
}
