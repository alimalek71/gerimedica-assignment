# Assignment

A JVM based backend application using REST that manages medical information entity.

## How to build?

### Dependencies

1. `Java 17`

### How to build the project

This command will make an executable `jar` file which you can run it on your system.

```shell
$ mvn clean package
```

After build successfully done run these commands.

```shell
$ cd targets
$ java -jar assignment-0.0.1-SNAPSHOT.jar
```

or you can simply run the test to check the project.
```shell
$ cd target
$ mvn test
```

## Documentation

After running the application you can see the api documentation in link below

[Open in Browser - http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Monitoring

This app expose `actuator` and `prometheus` metrics and can be use for different usages.
right now these endpoints doesn't have any authentication which should be harmful and exposing sensitive data and
access.

1. [Actuator](http://localhost:8080/actuator)
2. [Prometheus](http://localhost:8080/actuator/prometheus)