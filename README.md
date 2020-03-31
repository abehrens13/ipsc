# ipsc

## docker build
 - docker build -t feb18/backend:latest .
 - docker run --name backend -p 8080:8080 feb18/backend

## docker-compose build
 - docker-compose up --build
 - docker-compose up -d 
 - docker-compose down 


## maven build
mvn clean install
mvn docker:build
mvn docker:start
mvn docker:stop


## TODO
  - unit tests for travis-ci
  - initial database setup with meaningful test data
  - email setup with email templates
  - mechanism for login and safety