# Travelplanner is app built with Spring Boot and Angular
 
**Prerequisites:** [Java 10](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html), [Maven](https://maven.apache.org/), [Node.js](https://nodejs.org/), [Angular](https://angular.io/guide/quickstart), [MySQL](https://dev.mysql.com/downloads/mysql/).

## Getting Started

**1. Clone the application**

```bash
git clone https://github.com/malkfilipp/travelplanner.git
cd travelplanner
```

**2. Change MySQL username and password**

+ Open `server/src/main/resources/application.properties`.
+ Change `spring.datasource.username` and `spring.datasource.password` as per your MySQL installation.

Or set your MySQL root password to "root" according `application.properties`.

**3. Сreate a database**

```bash
create database TravelDatabase;
```

**4. Run the server using Maven**

To run the server, cd into the `server` folder and run:
 
```bash
mvn spring-boot:run
```

**5. Run the client using npm**

To run the client, cd into the `client` folder and run:
 
```bash
npm install && npm start
```

**6. Open the start page**

Go to `localhost:4200`.
