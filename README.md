# guusto_customer_program
A customer recognition and reward program solution with multiple microservices

# Start Up
To start the program 
- run the shell script maven_build.sh
- run the docker-compose.yml file

this should have everything up.

#API
To access the available API, below as a json POST request

**Endpoint** -> http://localhost:8078/guusto-service/buy-gift

`{
"clientId": 1,
"quantity": 1,
"amount": 90.0
}`

**Sample Response**
