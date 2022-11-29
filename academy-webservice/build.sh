mvn compile war:war

/Library/Tomcat/bin/shutdown.sh

rm -rf /Library/Tomcat/webapps/hello
rm /Library/Tomcat/webapps/hello.war

cp target/hello.war /Library/Tomcat/webapps/

/Library/Tomcat/bin/startup.sh
