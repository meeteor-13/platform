# Platform

> Platform services powered by Spring Boot

[![java version][java-image]][java-url]
[![build status][travis-image]][travis-url]
[![release][release-image]][release-url]
[![license][license-image]][license-url]

[java-image]: https://img.shields.io/badge/java-%3E%3D11-brightgreen.svg?style=flat-square
[java-url]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[release-image]: https://img.shields.io/github/release/meeteor-13/platform.svg?style=flat-square
[release-url]: https://github.com/meeteor-13/platform/releases
[travis-image]: https://img.shields.io/travis/meeteor-13/platform/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/meeteor-13/platform
[license-image]: https://img.shields.io/github/license/mashape/apistatus.svg?style=flat-square
[license-url]: https://github.com/meeteor-13/platform/blob/master/LICENSE

## Technologies

* [Java](https://openjdk.java.net/)
* [Maven](https://maven.apache.org/)
* [Spring](https://spring.io/)

## Usage

### Local

Build application artifacts:
```
./mvnw clean install
```

Build application artifacts (without tests):
```
./mvnw clean install -Dmaven.test.skip=true
```

Run tests:
```
./mvnw test
```

Run run services:
```
./mvnw -pl [:service1-server,:service2-server] spring-boot:run
```

### Docker

Require already built application artifacts

Bootstrap full project using docker-compose:
```
docker-compose up
```

Bootstrap project excluding some services using docker-compose:
```
docker-compose up  --scale [SERVICE=0...]
```

Stop and remove containers, networks, images:
```
docker-compose down
```
