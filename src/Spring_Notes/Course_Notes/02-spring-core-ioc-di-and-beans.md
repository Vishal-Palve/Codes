# Spring Core – IoC, DI & Beans (Deep, Course‑Aligned)

> **File name**: `02-spring-core-ioc-di-and-beans.md`
> **Aligned to course**: *Introduction to Spring → IoC & DI → Beans → XML & Annotation config → Autowiring*
> **Detail level**: **Very deep** (each concept + each annotation explained clearly)

---

## 1. Why Spring Core Exists (The REAL Problem)

Before Spring, Java enterprise applications had serious issues:

* Objects were created using `new`
* Classes were tightly coupled
* Changing one class required changing many others
* Testing was difficult

Example (problematic code):

```java
UserService service = new UserService(new UserRepository());
```

Problems here:

* `UserService` controls object creation
* Hard to replace `UserRepository`
* No flexibility

Spring Core solves this using **IoC and DI**.

---

## 2. Inversion of Control (IoC) – Deep Explanation

### What is IoC?

> **Inversion of Control means the control of object creation and dependency management is transferred from the programmer to the Spring container.**

In simple words:

* ❌ You do NOT create objects
* ✅ Spring creates and manages objects

This is the **core philosophy of Spring**.

---

### What Exactly Is “Inverted”?

| Before Spring           | With Spring                 |
| ----------------------- | --------------------------- |
| You create objects      | Spring creates objects      |
| You manage dependencies | Spring injects dependencies |

---

## 3. Spring Container (VERY IMPORTANT)

### What is the Spring Container?

> The Spring Container is the **runtime environment** that creates, configures, and manages Spring beans.

Think of it as:

* A factory
* A manager
* A lifecycle controller

---

### Types of Containers

1. **BeanFactory** (basic)
2. **ApplicationContext** (advanced – used by Spring Boot)

Spring Boot uses:

```java
ApplicationContext
```

---

## 4. What is a Bean? (CRITICAL)

### Proper Definition

> A **Bean** is a Java object that is created, configured, and managed by the Spring container.

Not every object is a bean.
Only objects created by Spring are beans.

---

### Bean vs Normal Object

| Normal Object       | Spring Bean       |
| ------------------- | ----------------- |
| Created using `new` | Created by Spring |
| No lifecycle        | Managed lifecycle |
| No DI               | Supports DI       |

---

## 5. Dependency Injection (DI) – Deep Explanation

### What is Dependency?

> A dependency is an object that another object needs to function.

Example:

```java
class UserService {
    UserRepository repo;
}
```

Here, `UserRepository` is a dependency of `UserService`.

---

### What is Dependency Injection?

> Dependency Injection means **providing required dependencies to a class instead of the class creating them itself**.

Spring supports:

* Constructor Injection
* Setter Injection
* Field Injection

---

## 6. Constructor Injection (MOST IMPORTANT)

```java
@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }
}
```

Why this is preferred:

* Makes dependencies mandatory
* Easier to test
* Recommended by Spring

📌 **Interview Line**: Constructor injection is preferred because it ensures immutability and better testability.

---

## 7. Setter Injection (LESS USED)

```java
@Autowired
public void setRepo(UserRepository repo) {
    this.repo = repo;
}
```

Used when:

* Dependency is optional

---

## 8. Field Injection (NOT RECOMMENDED)

```java
@Autowired
private UserRepository repo;
```

Problems:

* Hard to test
* Hidden dependencies

---

## 9. @Component (ROOT STEREOTYPE)

### What does @Component do?

> Marks a class as a **Spring-managed bean**.

```java
@Component
public class EmailService { }
```

Spring scans and registers this class as a bean.

---

## 10. @Service (In Depth)

### What is @Service?

> A specialized form of @Component used for **business logic classes**.

```java
@Service
public class UserService { }
```

Why use it:

* Improves readability
* Semantic meaning

---

## 11. @Repository (VERY IMPORTANT)

### What is @Repository?

> Specialized annotation for **data access layer**.

```java
@Repository
public class UserRepository { }
```

Extra benefit:

* Translates database exceptions into Spring exceptions

---

## 12. @Autowired (DEEP EXPLANATION)

### What does @Autowired do?

> Tells Spring to **inject a matching bean automatically**.

Spring searches:

* By type
* Then by name

---

### Where Can @Autowired Be Used?

* Constructor
* Setter
* Field

Constructor injection does NOT require `@Autowired` (from Spring 4.3+).

---

## 13. @Primary

### Why @Primary is Needed

When multiple beans of same type exist:

```java
@Service
@Primary
class MySQLRepo implements Repo { }
```

Spring chooses this bean by default.

---

## 14. @Qualifier (VERY IMPORTANT)

### What is @Qualifier?

> Used to specify **exact bean to inject**.

```java
@Autowired
@Qualifier("mongoRepo")
private Repo repo;
```

Used when:

* Multiple implementations exist

---

## 15. Bean Scopes (Deep)

### What is Bean Scope?

> Defines **how many instances** of a bean Spring creates.

---

### Common Scopes

| Scope     | Meaning                |
| --------- | ---------------------- |
| singleton | One instance (default) |
| prototype | New instance each time |

---

## 16. @Configuration & @Bean

### @Configuration

> Indicates a class contains bean definitions.

```java
@Configuration
public class AppConfig { }
```

---

### @Bean

> Explicitly defines a bean.

```java
@Bean
public UserService userService() {
    return new UserService();
}
```

Used when:

* Third‑party classes

---

## 17. Component Scanning (IMPORTANT)

Spring scans packages starting from:

* Main application class package

Wrong package structure = beans not detected.

---

## 18. Bean Lifecycle (INTERVIEW FAVORITE)

1. Bean instantiated
2. Dependencies injected
3. Initialization callbacks
4. Bean ready for use
5. Bean destroyed

---

## 19. Common Beginner Mistakes

❌ Using field injection everywhere
❌ Forgetting @Component / @Service
❌ Wrong package structure
❌ Multiple beans without @Qualifier

---

## 20. Must‑Know Interview Summary

You must clearly explain:

* IoC vs DI
* What a bean is
* Spring container role
* Why constructor injection is preferred
* Difference between @Component, @Service, @Repository
* @Autowired, @Primary, @Qualifier

---

## End of Spring Core

👉 **Next file**: `03-spring-boot-basics.md`
