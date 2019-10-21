package com.github.meeteor13.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;


@SpringBootTest
@Slf4j
public abstract class AbstractIntegrationTest {

    private static final GenericContainer DB = mongoDbContainer();

    static {
        DB.start();
        System.setProperty("spring.data.mongodb.uri", mongoDbUri());
    }

    private static GenericContainer mongoDbContainer() {
        return new GenericContainer("bitnami/mongodb:4.1.13-debian-9-r12")
            .withExposedPorts(27017)
            .withEnv("MONGODB_USERNAME", "meeteor13")
            .withEnv("MONGODB_PASSWORD", "meeteor13")
            .withEnv("MONGODB_DATABASE", "meeteor13")
            .withLogConsumer(new Slf4jLogConsumer(log))
            .waitingFor(Wait.forLogMessage(".*waiting for connections on port.*", 1));
    }

    private static String mongoDbUri() {
        return String.format(
            "mongodb://meeteor13:meeteor13@%s:%s/meeteor13",
            AbstractIntegrationTest.DB.getContainerIpAddress(), AbstractIntegrationTest.DB.getMappedPort(27017)
        );
    }
}
