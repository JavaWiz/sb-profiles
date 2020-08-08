# Spring Profiles
Spring Profiles helps segregating your application configurations, and make them available only in certain environments. ﻿

An application run on many different environments. For example, Dev, QA, Test, Stage, Production etc. Therefore, an application may need different configurations on different environments.. In other words, configurations like databases, messaging systems, server ports, security will be different from environment to environment.

We can then activate different profiles in different environments to bootstrap just the beans we need.

## Use @Profile on a Bean
Let's start simple and look at how we can make a bean belong to a particular profile. Using the @Profile annotation – we are mapping the bean to that particular profile; the annotation simply takes the names of one (or multiple) profiles.

Consider a basic scenario – we have a bean that should only be active during development, but not deployed in production. We annotate that bean with a “dev” profile, and it will only be present in the container during development – in production, the dev simply won't be active.

The initialization parameter spring.profiles.active can be set up as a property in Spring Boot to define currently active profiles. 
This is a standard property that Spring Boot will pick up automatically:
```
spring.profiles.active=dev
```

To set profiles programmatically, we can also use the SpringApplication class:
```
SpringApplication.setAdditionalProfiles("dev");
```

To set profiles using Maven in Spring Boot, we can specify profile names under spring-boot-maven-plugin in pom.xml:
```
<plugins>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
            <profiles>
                <profile>dev</profile>
            </profiles>
        </configuration>
    </plugin>
</plugins>
```
But the most important profiles-related feature that Spring Boot brings is profile-specific properties files. These have to be named in the format applications-{profile}.properties.

Spring Boot will automatically load the properties in an application.properties file for all profiles, and the ones in profile-specific .properties files only for the specified profile.

For example, we can configure different data sources for dev and production profiles by using two files named application-dev.properties and application-production.properties:

In the application-production.properties file, we can set up a MySql data source:
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/db
spring.datasource.username=root
spring.datasource.password=root
```

Then, we can configure the same properties for the dev profile in the application-dev.properties file, to use an in-memory H2 database:
```
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1
spring.datasource.username=sa
spring.datasource.password=sa
```

In this way, we can easily provide different configurations for different environments.