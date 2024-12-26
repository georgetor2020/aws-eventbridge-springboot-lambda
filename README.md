## Java Spring Boot Lambda

This is a simple Java Spring Boot Lambda project that can be deployed as a AWS Lambda.

URL: https://stackademic.com/blog/spring-boot-eventbridge

## Pre-requisites
- Maven

- Java 11

- AWS CLI

- SAM CLI

- Podman/Docker/Colima: Colima can be used as easy replacement for Docker on Mac/Linux.

## Build

### Build Using Maven (to run tests)

```bash
mvn clean install
```

### Test Endpoint
(GET) http://localhost:8080/api/v1/sensor

(PUT) http://localhost:8080/api/v1/sensor/123456

### Build Using SAM

```bash
sam build
```
```bash
sam local start-api
```

```bash
sam validate --lint
```

```bash
sam deploy --guided --profile agtag
```

```bash
sam package  --s3-bucket ag-eventbridgelambda
```

