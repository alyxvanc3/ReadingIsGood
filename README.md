# ReadingIsGood

A spring boot project for a fictional company that sells books online.

# Tech Stack

Java 17

Spring-Boot

H2

Maven

Docker

Swagger (swagger.yml)

Postman (ReadingIsGood.postman_collection.json)

<img width="806" alt="Screen Shot 2022-11-21 at 21 08 10" src="https://user-images.githubusercontent.com/29103620/203128764-53217713-8804-4e9d-95cd-46e68e9048f8.png">


<img width="273" alt="Screen Shot 2022-11-21 at 21 03 40" src="https://user-images.githubusercontent.com/29103620/203127947-22dfa979-0d95-4d79-b9b0-03e3d47eb5ee.png">


# Dockerizing the project

docker build --tag=readingisgood-server:latest .

docker run -p 8080:8080 readingisgood-server:latest

# Authentication

curl --location --request POST 'localhost:8080/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "ayse",
    "password": "password"
}'\'''

# Example Requests (token should be replaced)

I have added some customers and books to the db by data.sql file just to speed up the ordering process

# order

curl --location --request POST 'localhost:8080/order' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJheXNlIiwiZXhwIjoxNjY5MDY0NTU4LCJpYXQiOjE2NjkwNDY1NTh9.Mma6LB4lx4iXWCd9eJsXqnAp4tdJhjSSxlcPQU89hytfNrTRD5b-ot-Id-qimaF69uMjdFwfGtSw1FY3sTz9Fg' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": 1,
  "customerId": 1,
  "operationDate": "2022-12-21",
  "orderDetails": [
    {
      "book": 
      {
        "isbn": 1,
        "price": "10",
        "quantity": 40
      },
      "quantity": 1
    }
  ]
}'

curl --location --request GET 'localhost:8080/order/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJheXNlIiwiZXhwIjoxNjY5MDcyMDI2LCJpYXQiOjE2NjkwNTQwMjZ9.Id-WHqH6ArSm3BcBKHsPYLIZCXUCm-KWiIOHFBa3VDbojGwQ2_sq3EuDukidIQuruNtwEeoJsl4VqSC4ptwqmA' \
--data-raw ''

curl --location --request GET 'localhost:8080/order/date?startDate=2022-11-01&endDate=2022-12-01' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJheXNlIiwiZXhwIjoxNjY4OTkxNzM4LCJpYXQiOjE2Njg5NzM3Mzh9.Za4e-u8m3_BtojJ4e65CbFwAzobIp2M39XO8PVIn60-KIpR1K5dP5blBSqqn8J990o917ozcIh8SDad-NFlfLw'

# statistics

curl --location --request GET 'localhost:8080/statistics/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJheXNlIiwiZXhwIjoxNjY4OTkxNzM4LCJpYXQiOjE2Njg5NzM3Mzh9.Za4e-u8m3_BtojJ4e65CbFwAzobIp2M39XO8PVIn60-KIpR1K5dP5blBSqqn8J990o917ozcIh8SDad-NFlfLw'

# book

curl --location --request POST 'localhost:8080/book' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJheXNlIiwiZXhwIjoxNjY4OTkxNzM4LCJpYXQiOjE2Njg5NzM3Mzh9.Za4e-u8m3_BtojJ4e65CbFwAzobIp2M39XO8PVIn60-KIpR1K5dP5blBSqqn8J990o917ozcIh8SDad-NFlfLw' \
--header 'Content-Type: application/json' \
--data-raw '{
  "isbn": 1000,
  "price": "10",
  "quantity": 40
}'

curl --location --request PUT 'localhost:8080/book' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJheXNlIiwiZXhwIjoxNjY4OTkxNzM4LCJpYXQiOjE2Njg5NzM3Mzh9.Za4e-u8m3_BtojJ4e65CbFwAzobIp2M39XO8PVIn60-KIpR1K5dP5blBSqqn8J990o917ozcIh8SDad-NFlfLw' \
--header 'Content-Type: application/json' \
--data-raw '{
  "isbn": 1000,
  "price": "10",
  "quantity": 30
}'

# customer

curl --location --request POST 'localhost:8080/customer' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJheXNlIiwiZXhwIjoxNjY4OTkxNzM4LCJpYXQiOjE2Njg5NzM3Mzh9.Za4e-u8m3_BtojJ4e65CbFwAzobIp2M39XO8PVIn60-KIpR1K5dP5blBSqqn8J990o917ozcIh8SDad-NFlfLw' \
--header 'Content-Type: application/json' \
--data-raw '{
  "number": 5
}'

curl --location --request GET 'localhost:8080/customer/order/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJheXNlIiwiZXhwIjoxNjY5MDY0NTU4LCJpYXQiOjE2NjkwNDY1NTh9.Mma6LB4lx4iXWCd9eJsXqnAp4tdJhjSSxlcPQU89hytfNrTRD5b-ot-Id-qimaF69uMjdFwfGtSw1FY3sTz9Fg'
