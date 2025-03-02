# hackMotionTaskBackend

![hackmotionBackend](https://github.com/user-attachments/assets/d6f08fbe-d8c2-4f0c-9056-7938f7384e09)

## Tech Stack

Backend Framework
* Spring Boot 3.4.3

Core Dependencies
* Spring Web (REST API)
* Spring Data MongoDB (NoSQL database)
* Lombok (Boilerplate code reduction)

Testing & Tooling
* Spring Boot Starter Test (Testing framework)
* Maven Compiler Plugin (Java compilation)
* Spring Boot Maven Plugin (Packaging & execution)

Runtime & Environment
* Java 17
* Maven (Build System)

Start the MongoDB container:
```
sudo docker compose up -d
```

Run the application:
```
mvn clean install && mvn spring-boot:run
```

Test scripts:
```
./get-all-analytics.sh | jq
./delete-event.sh 67c48869c23e605ade57f17f
./delete-user.sh 42a0431b-79a5-4536-8511-aa085e1cc455
./clear-db.sh
```

Logging:
Runtime logs are saved with a timestamp in the filename and stored in the /logs directory.
