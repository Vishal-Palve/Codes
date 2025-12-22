# Spring Boot – Deep Dive (Part 2)

> **Goal of this file**: Understand *what Spring Boot really does*, *how it works internally*, and *why it is different from Spring Framework*.
>
> By the end of this part, you should be able to **explain Spring Boot confidently in interviews** and **use it correctly in real projects**.

---

## 1. Why Spring Boot Was Created (Very Important)

Spring Framework is powerful, but using **pure Spring** had problems:

### Problems with Traditional Spring

* Too much configuration (XML / Java config)
* Manual bean definitions
* Manual server setup (Tomcat, WAR deployment)
* Dependency version conflicts
* Slow project setup

Even a simple web app required:

* DispatcherServlet configuration
* ViewResolver configuration
* DataSource configuration
* Component scanning setup

📌 **Pain Point**:

> *Spring was powerful, but slow and complex to start with.*

---

## 2. What is Spring Boot? (Correct Definition)

> **Spring Boot is an opinionated framework built on top of Spring that provides auto-configuration, starter dependencies, and embedded servers to create production-ready applications quickly.**

Spring Boot does NOT replace Spring.
Spring Boot **uses Spring internally**.

---

## 3. What Does “Opinionated” Mean?

"Opinionated" means:

* Spring Boot makes **smart default decisions** for you
* You can override them if needed

Example:

* Default server → Tomcat
* Default port → 8080
* Default JSON library → Jackson

📌 **Interview Line**:

> *Spring Boot is opinionated because it provides sensible defaults while still allowing customization.*

---

## 4. Spring Boot vs Spring Framework (CLEAR DIFFERENCE)

| Spring Framework             | Spring Boot           |
| ---------------------------- | --------------------- |
| Requires configuration       | Minimal configuration |
| No embedded server           | Embedded server       |
| Manual dependency management | Starter dependencies  |
| Slower setup                 | Rapid development     |

---

## 5. @SpringBootApplication (MOST IMPORTANT ANNOTATION)

```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

### What does @SpringBootApplication do?

It is a **combination of three annotations**:

```java
@SpringBootApplication =
@Configuration
@EnableAutoConfiguration
@ComponentScan
```

Let’s understand each one deeply.

---

## 6. @Configuration (In Depth)

### What is @Configuration?

> Marks a class as a **source of bean definitions**.

```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```

Spring treats this class as a **configuration class**.

📌 It replaces old XML configuration.

---

## 7. @ComponentScan (In Depth)

### What does @ComponentScan do?

> Tells Spring **where to search for beans**.

By default:

* Scans the package of the main class
* Scans all sub-packages

```java
@ComponentScan("com.example")
```

### Why package structure matters

If your controller is outside the scanned package → Spring will NOT detect it.

📌 **Interview Tip**:

> Many “404 errors” happen due to wrong package structure.

---

## 8. @EnableAutoConfiguration (CORE OF SPRING BOOT)

This is the **heart of Spring Boot**.

### What is Auto-Configuration?

> Auto-configuration automatically configures Spring beans based on:

* Classpath dependencies
* Existing beans
* Application properties

---

### Example: How Auto-Configuration Works

If Spring Boot sees:

* `spring-boot-starter-web` in classpath

Then it automatically:

* Configures DispatcherServlet
* Configures Tomcat
* Configures JSON converters
* Enables Spring MVC

📌 **You did NOT write any config for this**.

---

### How Auto-Configuration Is Implemented (Internals)

* Uses `@Conditional` annotations
* Configuration classes exist in:

    * `spring-boot-autoconfigure`

Example condition:

```java
@ConditionalOnClass(DispatcherServlet.class)
```

Means:

> "Configure this only if DispatcherServlet exists in classpath"

---

## 9. Spring Boot Starters (VERY IMPORTANT)

### What is a Starter?

> A starter is a **predefined set of dependencies** that work well together.

Example:

```xml
spring-boot-starter-web
```

Includes:

* Spring MVC
* Tomcat
* Jackson
* Validation

---

### Why Starters Are Important

Without starters:

* You manage versions manually
* Dependency conflicts

With starters:

* Compatible versions
* Faster setup

📌 **Interview Line**:

> Starters reduce dependency management complexity.

---

## 10. Embedded Server (Deep Explanation)

### What is an Embedded Server?

> A server that runs **inside your application**, not separately.

Spring Boot application runs as:

```text
java -jar app.jar
```

---

### How It Works

* Tomcat is included as a dependency
* Starts automatically when app runs
* No WAR deployment needed

---

### Benefits

* Standalone application
* Easy deployment
* Cloud-friendly

---

## 11. application.properties / application.yml

### Purpose

Used for **external configuration**.

```properties
server.port=8081
spring.application.name=demo-app
```

Spring Boot follows this priority:

1. Command-line args
2. Environment variables
3. application.properties

---

## 12. Spring Boot Application Startup Flow (Interview Favorite)

1. main() method starts
2. SpringApplication.run()
3. ApplicationContext created
4. Auto-configuration runs
5. Beans created
6. Embedded server starts
7. Application ready

---

## 13. What You MUST Know Before Moving On

You should now clearly understand:

* Why Spring Boot exists
* What "opinionated" means
* How auto-configuration works
* Purpose of starters
* Embedded server concept
* Role of @SpringBootApplication

---

## End of Part 2

👉 **Next file**: *Spring Web MVC Deep Dive – DispatcherServlet, Request Flow, MVC Internals*
