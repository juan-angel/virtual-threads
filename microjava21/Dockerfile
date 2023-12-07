FROM openjdk:21-slim
COPY target/microjava21-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT [ "java", \
"-Dcom.sun.management.jmxremote=true", \
"-Dcom.sun.management.jmxremote.port=9011", \
"-Dcom.sun.management.jmxremote.local.only=false", \
"-Dcom.sun.management.jmxremote.authenticate=false", \
"-Dcom.sun.management.jmxremote.ssl=false", \
"-Dcom.sun.management.jmxremote.rmi.port=9011", \
"-Djava.rmi.server.hostname=localhost", \
"-jar", \
"/app.jar" ]
EXPOSE 9011
