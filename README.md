# Java Performance Exercises

## Build

```
./mvnw clean install
```
or
```
./mvnw package
```

## Measure Energy Consumption

Recommended
```
java -javaagent:joularjx-3.0.1.jar  -classpath ./target/classes  main.Application
```

or add a manifest and run

```
java -javaagent:joularjx-3.0.1.jar -jar <jar location>
```
