# hackMotionTaskBackend

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

Logging is done with a timestamp in the /logs directory.