# Academy Project

1. [Project structure and building](#Structure)
2. [WebService](#WebService)
3. [SoapUI Tests](#SoapUI)
4. [Client](#Client)

---
## Structure
    - academy-parent (maven parent module)
        - academy-webservice (maven submodule)
        - academy-client (maven submodule)

Submodule declarations in [pom.xml](pom.xml) (parent):
```xml
  <modules>
  	<module>academy-webservice</module>
  	<module>academy-client</module>
  </modules>
```
## Build system

The web service builds a *.war* file that deploys to Tomcat (or any servlet server). The classes needed for the client are generated through the *jax-ws* maven plugin.

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-war-plugin</artifactId>
	<version>3.3.1</version>
	<configuration>
		<failOnMissingWebXml>true</failOnMissingWebXml>
	</configuration>
</plugin>
```

```xml
<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>jaxws-maven-plugin</artifactId>
	<version>2.6</version>
	<executions>
		<execution>
			<goals>
				<goal>wsimport</goal>
			</goals>
		</execution>
	</executions>
	<configuration>
	<wsdlUrls>
		<wsdlUrl>http://localhost:8080/hello/hello?wsdl</wsdlUrl>
	</wsdlUrls>
	<packageName>academy.client</packageName>
	<sourceDestDir>
        ${project.build.directory}/generated-sources/
    </sourceDestDir>
	</configuration>
</plugin>
```

---
## WebService

Every operation is declared in [Hello.java](academy-webservice/src/main/java/academy/Hello.java)

### Tomcat Server Entry
!["Web services"](img/webservice.png)

### WSDL
!["WSDL"](img/wsdl.png)

---- 

### SoapUI

Create user

!["createuser"](img/soapui_createuser.png)

Get users

!["getusrs"](img/soapui_getusers.png)

Change user name

!["changeusername"](img/soapui_changeusername.png)

Delete user

!["deleteuser](img/soapui_deleteuser.png)

Exception handling

!["exceptionhandling](img/soapui_exception.png)

## Client

The client holds all the needed classes in /target/generated-sources as specified in the jax-ws plugin configuration.