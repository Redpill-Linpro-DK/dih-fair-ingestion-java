## ingestion-java

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

### Azure functions http

This project uses the azure-functions-http quarkus extension. <https://quarkus.io/guides/azure-functions-http>

### Usage of common objects

In order for quarkus to serialize/deserialize these objects the following dependency is added:

`pom.xml
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-rest-jackson</artifactId>
    </dependency>
`

### Running the application in dev mode

#### Add .env file

The application requires the following application properties during package.

For development purposes you can add a `.env` file in the directory of this project.

The `.env` file is `gitignored`.

`.env`

```
resourceGroupName="test"
resourceLocation="test"
```

You can run your application in dev mode that enables live coding using:

```shell script (linux-macos)
./mvnw clean package quarkus:dev
```

```shell script (Windows)
./mvnw.cmd clean package quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

### Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

### Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

### Deploying it to azure

We use the maven plugin for deploying the app to the `Microsoft Azure`.

The deployment is managed by the application properties found in `resources/application.properties`

```shell script
./mvnw quarkus:deploy -DfunctionAppName=${the-app-name} -DresourceGroupName=${the-resource-group-name} -DresourceLocation=${the-resource-location}
```

### Related Guides

- Azure Functions HTTP ([guide](https://quarkus.io/guides/azure-functions-http)): Write Microsoft Azure functions
