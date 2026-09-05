FROM tomcat:9-jdk8

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/ONLINE_ADMISSION.war /usr/local/tomcat/webapps/ONLINE_ADMISSION.war

EXPOSE 8080

CMD ["catalina.sh", "run"]