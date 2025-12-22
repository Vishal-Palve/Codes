# Spring Framework – Deep Dive (Part 1)

> **Goal of this file**: Build a *rock‑solid mental model* of Spring from the ground up.
> Read slowly. Do NOT memorize. Understand.

---

## 1. Why Spring Framework Exists (The Real Problem)

Before Spring, Java backend applications were built mainly using **Servlets, JSP, and EJB**.

### Real Problems Developers Faced

* Every class used `new` to create objects
* Classes were tightly coupled
* Changing one class forced changes in many other classes
* Unit testing was painful or impossible
* Business logic mixed with infrastructure code
* Large applications became unmaintainable

### Core Pain Point

> "My code works today, but tomorrow it will be impossible to change or test."

Spring was created to **solve this exact problem**.

---

## 2. What is Spring Framework? (Proper Definition)

**Spring Framework is a Java framework that manages object creation, object dependencies, and object lifecycle so that developers can focus only on business logic.**

Spring does NOT replace Java.
Spring organizes how Java objects work together.

---

## 3. What Spring Actually Does (Big Picture)

Spring performs four critical responsibilities:

1. Creates objects (beans)
2. Connects objects together (dependency injection)
3. Manages object lifecycle
4. Provides ready‑made infrastructure (MVC, Security, Data, Transactions)

Everything else in Spring is built on top of these ideas.

---

## 4. Inversion of Control (IoC) – Deep Explanation

### 4.1 Normal Java Without IoC

```java
class Car {
    Engine engine = new Engine();
}
```

#### What is wrong here?

* `Car` decides which `Engine` to use
* Strong coupling between `Car` and `Engine`
* Cannot change engine type easily
* Cannot mock engine for testing

📌 **Control is inside the class itself**

---

### 4.2 Java With Spring (IoC Applied)

```java
@Component
class Engine { }

@Component
class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
}
```

#### What changed?

* Spring creates `Engine`
* Spring creates `Car`
* Spring injects `Engine` into `Car`

📌 **Control is moved outside the class and given to Spring**

---

### 4.3 Final Definition of IoC

> **Inversion of Control means the framework controls object creation and dependency wiring instead of the developer.**

### Interview‑Ready Line

> *IoC is a design principle where the control of object creation is inverted from application code to the framework.*

---

## 5. Dependency Injection (DI) – Not the Same as IoC

Many developers confuse IoC and DI. They are related but NOT the same.

* **IoC** → Principle
* **DI** → Technique to implement IoC

---

## 6. What is Dependency Injection? (Very Clear)

> **Dependency Injection means providing an object with its required dependencies instead of letting the object create them.**

---

### 6.1 Without Dependency Injection (Bad Design)

```java
class UserService {
    UserRepository repo = new UserRepository();
}
```

Problems:

* Tight coupling
* Hard to test
* Cannot replace implementation

---

### 6.2 With Dependency Injection (Good Design)

```java
@Service
class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }
}
```

Benefits:

* Loose coupling
* Easy testing
* Easy maintenance
* Clean architecture

---

## 7. Types of Dependency Injection (Explained Properly)

### 7.1 Constructor Injection (BEST PRACTICE)

```java
public UserService(UserRepository repo) {
    this.repo = repo;
}
```

Why constructor injection is preferred:

* Makes dependencies mandatory
* Allows immutability
* Makes class easier to test
* Fails fast if dependency missing

📌 **Industry standard approach**

---

### 7.2 Setter Injection

```java
@Autowired
public void setRepo(UserRepository repo) {
    this.repo = repo;
}
```

Used when:

* Dependency is optional
* Dependency may change later

---

### 7.3 Field Injection (Avoid in Real Projects)

```java
@Autowired
private UserRepository repo;
```

Why this is discouraged:

* Hidden dependencies
* Hard to test
* Breaks encapsulation

---

## 8. What is a Spring Bean? (Critical Concept)

> **A Spring Bean is any object that is created, managed, and destroyed by the Spring container.**

If Spring creates the object → it is a bean.

---

### 8.1 How Spring Identifies Beans

Using annotations:

| Annotation      | Meaning              |
| --------------- | -------------------- |
| @Component      | Generic bean         |
| @Service        | Business logic layer |
| @Repository     | Data access layer    |
| @Controller     | MVC controller       |
| @RestController | REST controller      |

All of these are **Spring Beans**.

---

## 9. Spring Container – In Depth

### 9.1 What is Spring Container?

> **Spring Container is the core engine that manages beans and their dependencies.**

---

### 9.2 Responsibilities of Container

* Scans classes
* Creates beans
* Injects dependencies
* Manages lifecycle

---

### 9.3 Types of Containers

#### BeanFactory

* Lightweight
* Lazy loading
* Rarely used

#### ApplicationContext (Used in Spring Boot)

* Eager loading
* Event handling
* Advanced features

📌 **Spring Boot always uses ApplicationContext**

---

## 10. Spring Bean Lifecycle (Interview Favorite)

1. Class loading
2. Bean instantiation
3. Dependency injection
4. Initialization (`@PostConstruct`)
5. Bean ready for use
6. Destruction (`@PreDestroy`)

---

## 11. What You MUST Understand Before Moving On

You should now clearly understand:

* Why Spring was created
* What IoC really means
* Difference between IoC and DI
* Why constructor injection is best
* What a Spring Bean is
* What the Spring Container does

---

## End of Part 1

👉 **Next file**: *Spring Boot Deep Dive – Auto‑Configuration, Starters, Embedded Server*
