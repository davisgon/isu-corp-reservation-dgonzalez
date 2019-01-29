# isu-corp-reservation-dgonzalez
API Reservation

# Spring Boot, MySQL, JPA, Hibernate Rest API

Build Restful  API for a reservation application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/davisgon/isu-corp-reservation-dgonzalez.git
```

**2. Execute**
    isu-corp-reservation-dgonzalezjava/target/  -jar reservation-1.0.0.jar

    if no exist
    ```bash
    mvn package
    java -jar target/reservation-1.0.0.jar
    ```

**3. Port**
      8280

**4. Documentation

  http://localhost:8280/swagger-ui.html#/reservation-controller


The app will start running at <http://localhost:8280>.

## Explore Rest APIs

http://localhost:8280/swagger-ui.html#

You can test them using postman or any other rest client.

## Learn more

You can find the tutorial for this application**
https://docs.google.com/document/d/1khHlvXUtNZnofK2OzE34TM7-BWB7askxESD7ZhBcJwQ/edit?usp=sharing

**NOTE**
If you change the reservation3 database, you must manually execute the store procedure, here the ddl, the idea is to store a copy in the contact_backup table to back up the information of our clients

CREATE DEFINER = `root` @`% `PROCEDURE` reservation3`.`prbackupcontact` (IN pidContact INT, IN pName VARCHAR (255), IN pPhoneNumber VARCHAR (50), IN pBirthDate DATE, IN pImage VARCHAR (255), IN pidTypeContact INT)
BEGIN
insert into reservation.contactbackup VALUES (pidContact, pName, pPhoneNumber, pBirthDate, pimage, pidTypeContact);
END;

