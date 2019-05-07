FROM openjdk:8
VOLUME /tmp
COPY target/walletapi-0.0.1-SNAPSHOT.jar wallet.jar
ENTRYPOINT ["java","-jar","wallet.jar"]