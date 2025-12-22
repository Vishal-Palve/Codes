# Spring Boot Basics (Deep, Course-Aligned)

**File:** `03-spring-boot-basics.md`
**Aligned to Telusko course:** Spring vs Spring Boot → First Spring Boot App → `@SpringBootApplication` → Auto-configuration → Embedded Server → `application.properties` → Layers

---

## 1. Why Spring Boot Was Created (The Real Problem)

Before Spring Boot, building a Spring application required heavy configuration:

* Manual configuration of **DispatcherServlet**, **ViewResolver**, **Component Scanning**
* External Tomcat setup and WAR deployment
* Manual dependency version management
* Large XML / Java configuration even for small apps

📌 **Core pain point**: Spring was powerful, but slow and complex to start.

Spring Boot was created to **reduce boilerplate**, **speed up development**, and **standardize setup**.

---

## 2. What Is Spring Boot? (Correct Definition)

Spring Boot is an **opinionated framework built on top of Spring Framework** that simplifies application development by providing:

* Auto-configuration
* Starter dependencies
* Embedded servers

Important clarifications:

* Spring Boot ❌ does NOT replace Spring
* Spring Boot ✅ internally uses Spring Core, MVC, etc.
* Spring Boot focuses on **convention over configuration**

---

## 3. Meaning of “Opinionated” in Spring Boot

**Opinionated** means Spring Boot provides **sensible defaults** so you don’t configure everything manually.

### Examples of Defaults

| Feature      | Default Provided by Spring Boot |
| ------------ | ------------------------------- |
| Server       | Tomcat                          |
| Port         | 8080                            |
| JSON Library | Jackson                         |
| Logging      | Logback                         |

You can override these defaults, but you don’t need to configure them initially.

📌 **Interview-ready line**: Spring Boot is opinionated because it provides default configurations while still allowing customization.

---

## 4. Spring Framework vs Spring Boot

| Spring Framework              | Spring Boot        |
| ----------------------------- | ------------------ |
| Requires manual configuration | Auto-configuration |
| No embedded server            | Embedded server    |
| XML-heavy earlier             | Annotation-based   |
| Slower startup                | Rapid development  |

---

## 5. First Spring Boot Application Structure

A standard Spring Boot project structure:

```
src/main/java
  └── DemoApplication.java
src/main/resources
  └── application.properties
pom.xml
```

Spring Boot **expects** this structure. Deviating from it causes issues with scanning and configuration.

---

## 6. Main Class and `@SpringBootApplication`

```java
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

This is the **entry point** of a Spring Boot application.

---

## 7. `@SpringBootApplication` – Internal Breakdown (Very Important)

`@SpringBootApplication` is a **meta-annotation** that combines three annotations:

```
@SpringBootApplication =
@Configuration
@EnableAutoConfiguration
@ComponentScan
```

Each plays a critical role.

---

## 8. `@Configuration` (Deep Explanation)

### Purpose

* Marks a class as a **configuration source**
* Used to define beans using `@Bean`
* Replaces XML-based configuration

```java
@Configuration
public class AppConfig {
}
```

Spring treats this class as a **container of bean definitions**.

---

## 9. `@ComponentScan` (Very Important)

### Purpose

* Tells Spring **where to search for components (beans)**

Default behavior:

* Scans the package of the main class
* Scans all sub-packages

📌 **Common fresher mistake**: Placing controllers outside the scanned package → beans not detected → 404 errors.

---

## 10. `@EnableAutoConfiguration` (Heart of Spring Boot)

### What Is Auto-Configuration?

Auto-configuration allows Spring Boot to **automatically configure beans** based on:

* Dependencies present in the classpath
* Existing beans
* Application properties

### Example

If `spring-boot-starter-web` is present:

Spring Boot automatically configures:

* Tomcat
* DispatcherServlet
* Spring MVC
* JSON converters

📌 No manual configuration needed.

---

## 11. How Auto-Configuration Works (Internals – Simplified)

Spring Boot uses **conditional annotations** internally.

Example:

```java
@ConditionalOnClass(DispatcherServlet.class)
```

Meaning:

> Configure this bean only if the class exists in the classpath.

This prevents unnecessary bean creation.

---

## 12. `SpringApplication.run()` – What Happens Internally

```java
SpringApplication.run(DemoApplication.class, args);
```

### Startup Flow

1. JVM starts
2. SpringApplication instance is created
3. ApplicationContext is initialized
4. Auto-configuration executes
5. Beans are instantiated
6. Embedded server starts
7. Application is ready

📌 **Interview favorite question**: Explain Spring Boot startup flow.

---

## 13. Embedded Server (Deep Explanation)

### What Is an Embedded Server?

A server that runs **inside the application**, not separately.

Spring Boot default server:

* Tomcat

Run command:

```bash
java -jar app.jar
```

### Benefits

* No external server setup
* Easy deployment
* Cloud-friendly

---

## 14. `application.properties` (Critical File)

### Purpose

External configuration of application behavior.

Example:

```properties
server.port=8081
spring.application.name=demo-app
```

### Priority Order (High to Low)

1. Command-line arguments
2. Environment variables
3. `application.properties`

---

## 15. Layered Architecture in Spring Boot

Spring Boot applications follow a layered structure:

```
Controller → Service → Repository → Database
```

### Controller

* Handles HTTP requests
* No business logic

### Service

* Contains business logic
* Coordinates operations

### Repository

* Handles database access
* Uses JPA / JDBC

📌 Separation of concerns is mandatory in real projects.

---

## 16. Common Beginner Mistakes

* Confusing Spring with Spring Boot
* Misplacing packages
* Writing business logic in controllers
* Ignoring `application.properties`

---

## 17. Must-Know Interview Summary

You must confidently explain:

* Why Spring Boot was created
* Meaning of opinionated framework
* What `@SpringBootApplication` does internally
* How auto-configuration works
* Embedded server concept
* Application startup flow

---

## End of Spring Boot Basics

**Next file:** `04-spring-web-mvc.md`
