# guusto_customer_program
A customer recognition and reward program solution with multiple microservices

# Start Up
To start the program 
- run the shell script maven_build.sh
- run the docker-compose.yml file

This will set up the MySQL Docker image for the database, along with docker images for all services

# API
To access the available API, below as a json POST request

**Endpoint** -> POST http://localhost:8078/guusto-service/buy-gift

`{
"clientId": 1,
"quantity": 1,
"amount": 90.0
}`

**Sample Success Response**

`{
"balance": 10.0,
"quantity": 1,
"totalCost": 90.0,
"datePurchased": "2022-03-21"
}`

**Sample failure response**

`{
"status": "NOT_FOUND",
"message": "Current balance: 10.00 is insufficient for purchase 90.00"
}`

**Endpoint** -> GET http://localhost:8078/guusto-service/transaction-list/{{clientId}}

**Sample Response**

`[
{
"balance": 60.0,
"quantity": 1,
"totalCost": 20.00,
"datePurchased": "2022-03-21"
},
{
"balance": 60.0,
"quantity": 1,
"totalCost": 20.00,
"datePurchased": "2022-03-21"
}
]`