# Implement a  running-information-analysis
This is a service designed in **Spring Boot/Data** to provide **REST** APIs for storing/retrieving runner's information in **MySQL** database.

## Development environment
- MySQL DB is running on **docker**, image specified in **docker-compose.yml** file, and started by **docker-compose**.
- **Spring Data Rest** is used for quick DB access and verification.
- **Spring Boot** is used for fast REST API development.
- **HAL Browser** is used for quick repository exploration.
- **lombok** is used to eliminate constructors and getter/setter implementation for cleaner coding style.

## Features
- Each RunningInformation includes runningId, latitude, longitude, runningDistance, totalRunningTime,heartRate, timestamp and userInfo.

### Query

Query can be done by sending GET request to http://localhost:8080/running_info/{searching_id}?page=0&size=10

The size parameter can be ignored and the default value is 2.

Then you will get the response in JSON like below.
```json
{
    "runningId": "7c08973d-bed4-4cbd-9c28-9282a02a6032",
    "latitude": "40.730610",
    "longitude": "-73.935242",
    "runningDistance": "39492",
    "totalRunningTime": "2139.25",
    "heartRate": 0,
    "timestamp": "2018-04-01T18:50:35Z",
    "userInfo": {
      "username": "chandler0",
      "address": "Success Street, New York, NY 10001"
    }



## Requirements

- Java Platform (JDK) 8
- Apache Maven

## 1.Getting started

### Start MySQL on Docker
```bash
docker-compose up -d
```
```
### 2. Login MySQL database
```
mysql -u root -p
```
Create table RUNNING_ANALYSIS in database runningInfoAnalysis_db if not exist
```
mysql> SHOW DATABASES;
mysql> CREATE DATABASE runningInfoAnalysis_db;
mysql> USE runningInfoAnalysis_db;
mysql> SHOW TABLES;
mysql> CREATE TABLE RUNNING_ANALYSIS (userId BIGINT(20) AUTO_INCREMENT, runningId VARCHAR(50), latitude DOUBLE, longitude DOUBLE, runningDistance DOUBLE, totalRunningTime DOUBLE, timestamp TIMESTAMP, healthWarningLevel INT, heartRate VARCHAR(10), username VARCHAR(30), address VARCHAR(50), PRIMARY KEY(userId));
mysql> DESC RUNNING_ANALYSIS;
mysql> EXIT;
```
### Installation
```bash
mvn clean install
```
### Start service
```bash
java -jar target/running-information-analysis-service-1.0.0.BUILD-SNAPSHOT

### Explore by Postman

## API Overview
> Check API References for detailed information

| Method | URL | Description | 
|--------|--------|-------------|
| POST | /running | upload a list of runningInfo | 
| DELETE | running/purge | delete all runningInfo | 
| DELETE | running/delete/{runningId} | delete one runningInfo by runningId |
| GET | /running | get all runningInfo with pagination and sort by healthWarningLevel | 
| GET | /running/?page=0&size=2 | get all runningInfo with two data each page and sort by healthWarningLevel | 
| GET | /running/{userId} | get one runningInfo by userId | 
| GET | /running/runningId/{runningId} | get one runningInfo by runningId | 

## LICENSE

[MIT](./License.txt)
