## Feign Client vs Web Client
This project compares the performance between Feign client and Web client. 
Feign is a declarative client for rest apis. Web client is Spring's new reactive 
client for steaming data in a non blocking way.

Feign is a blocking client where as Web client can be blocking or non blocking.


### Prerequisite
- Docker
- Java 21
- Maven

### Set up

```
mvn clean install -DskipTests=true
```
```
docker compose up -d
```
```
cd load-tester
```

```
mvn spring-boot:run
```


### Test Result
#### 50 Iterations
```
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.393316727   64%     FeignClient
0.225777326   36%     WebClient
```

#### 500 Iterations
```
2.279358727   53%     FeignClient
2.059716339   47%     WebClient
```

You may change the iteration number here and then run the last springboot run command.
[LoadTesterApplication.java](load-tester%2Fsrc%2Fmain%2Fjava%2Fcom%2Fexample%2Floadtester%2FLoadTesterApplication.java)




