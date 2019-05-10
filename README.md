# Spring Boot (Web,H2,Swagger)

    1. Download and unzip the application
    2. Build the application using 
        $ ./mvn clean install
    3. walletapi-0.0.1-SNAPSHOT.jar gets generated under the directory 'target'
    4. Start the Application by running java -jar target/walletapi-0.0.1-SNAPSHOT.jar
    5. Application will be running on port 8080 

# How Application works

H2 connection details : http://localhost:8080/h2/login.jsp

JDBC URL: jdbc:h2:file:~/wallet_db 
User Name: sa

Player records

| PLAYER_ID     | PLAYER_NAME   | BALANCE_AMOUNT| UPDATED_DATE             | UPDATE_BY |
| ------------- | ------------- | ------------- | -------------            |-----------|
| 100           | test user 1	| 10000.00      | 2019-05-06 23:08:31.583  |Admin      |
| 200           | test user 2	| 10000.00      | 2019-04-16 10:39:48.223  |Admin      |
| 300           | test user 3	| 10000.00      | 2019-04-16 10:39:48.223  |Admin      |


Example :

    Transaction URI (/v1/transactions)

Debit Transaction

http://localhost:8080/players/transactions 

Request Type: Post

Sample Request JSON Body

{
 "accountNumber" : "100",
 "amount" : "2000",
 "transactionType" : "Debit",
 "comment" : "Debit Transaction ",
 "transactionId" : "0dvsfwddfssxcdddsdscsgvss3dss2"    
 }


Credit Transaction: 

Request Type: Post

Sample Request JSON Body

{
   "accountNumber" : "100",
    "amount" : "1000",
     "transactionType" : "Credit",
     "comment" : "Credit Transaction ",
     "transactionId" : "1asd0saddvsfwsadsadsadasdsad"     
 } 
 
 Transaction History
 
    Transaction Statement URI (/players/transactions/{id}) - [{id} : AccountNumber]
    Request Type: Get

http://localhost:8080/players/transactions/100


Account Balance

    Balance Request (/players/accounts/{id}) - [{id} : PlayerId]
    Request Type: Get

http://localhost:8080/players/accounts/100



# Swagger UI : API Docs 

http://localhost:8080/swagger-ui.html
