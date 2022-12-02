# DonutQueue

This is a simple application showcasing the use of priority queue in the context of Donuts. :)

## Interesting features
There are a couple of interesting features that are bundled into this app:
1. Docker-compose - even though the app is small, one command build is possible.
2. OpenApi - clear documentation of the api is provided thanks to OpenApi used in the project.
3. MapStruct - used for mapping between different objects.
4. Hexagonal architecture smells - much more modern approach to software architecture.
5. WebTestClient - uncommon approach to api-testing.

## Build

Bear in mind that this application's source compatibility of java is set to 1.8.

1. Use Docker.

The preffered way of building the project alongside with starting it in the background is running `./gradlew build && docker-compose build && docker-compose up -d`.
In order for this command to work properly you need to have docker and docker-compose installed on your machine.

2. Use Terminal.

Another way of building the app is to run `./gradlew build` to build the app itself followed by running `java -jar queue-service/build/libs/*.jar &` to run SpringBoot application.

3. Use IDE.

You can always clone this project, import it into your IDE of choice and run it manually from there. 

## APIs

Having build the application, please visit `http://localhost:8080/openapi/swagger-ui.html` in order to see all available endpoints and schemas just like below.

![Screenshot from 2022-12-02 15-37-01](https://user-images.githubusercontent.com/50672367/205317235-ea30d500-36fd-4554-957b-4c6ee23885ba.png)




