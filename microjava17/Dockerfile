FROM openjdk:17-slim
COPY target/microjava17-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT [ "java", \
"-Dcom.sun.management.jmxremote=true", \
"-Dcom.sun.management.jmxremote.port=9010", \
"-Dcom.sun.management.jmxremote.local.only=false", \
"-Dcom.sun.management.jmxremote.authenticate=false", \
"-Dcom.sun.management.jmxremote.ssl=false", \
"-Dcom.sun.management.jmxremote.rmi.port=9010", \
"-Djava.rmi.server.hostname=localhost", \
"-jar", \
"/app.jar" ]
EXPOSE 9010
