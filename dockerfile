FROM openjdk:21-ea-24-oracle

WORKDIR /app
COPY target/qr4-1.0-SNAPSHOT.jar app.jar
COPY Wallet_HQSWI7Z2JQL4DSEF /app/oracle_wallet

CMD [ "java", "-jar", "app.jar" ]