# Java Basics for Spring Boot (Fresher‑Level, Course‑Aligned)

> **File name**: `00-java-basics-for-spring-boot.md`
> **Aligned to course**: *Java fundamentals → OOP → Exceptions → Collections* (only what is used later in Spring & Spring Boot)
>
> **Goal**: Understand **exactly the Java concepts that Spring uses**, with deep explanation but **no unnecessary theory**.

---

## 1. Why Java Knowledge Is Required for Spring

Spring is **not a new language**. It is a framework written *on top of Java*.

Spring heavily relies on:

* Classes & Objects
* Interfaces
* Constructors
* Annotations
* Exception handling
* Collections

If these are unclear, Spring will feel like magic. This file removes that confusion.

---

## 2. Class and Object (Used Everywhere in Spring)

### What is a Class?

> A class is a **blueprint** that defines variables (state) and methods (behavior).

```java
class User {
    String name;
    int age;
}
```

In Spring:

* Every **Bean** is a Java object
* Every Controller, Service, Repository is a **class**

---

### What is an Object?

> An object is an **instance of a class**.

```java
User u = new User();
```

⚠️ In Spring, you usually **do NOT create objects using `new`**.
Spring creates them for you (IoC).

---

## 3. Constructors (VERY IMPORTANT FOR SPRING)

### What is a Constructor?

> A constructor is a special method used to initialize an object.

```java
class User {
    String name;

    User(String name) {
        this.name = name;
    }
}
```

---

### Why Constructors Matter in Spring

Spring uses **constructor injection** to provide dependencies.

```java
@Service
class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }
}
```

This is why constructor knowledge is **mandatory**.

---

## 4. Interface (CORE SPRING CONCEPT)

### What is an Interface?

> An interface defines **what a class should do**, not **how it does it**.

```java
interface PaymentService {
    void pay();
}
```

Implementation:

```java
class CardPayment implements PaymentService {
    public void pay() {
        System.out.println("Paid by card");
    }
}
```

---

### Why Spring Loves Interfaces

Spring uses interfaces to:

* Achieve loose coupling
* Enable easy replacement
* Support AOP & proxies

Example in Spring:

* `JpaRepository`
* `CrudRepository`

---

## 5. Inheritance (Used but Not Overused)

### What is Inheritance?

> One class acquiring properties of another class.

```java
class Animal { }
class Dog extends Animal { }
```

Spring uses inheritance internally, but **composition is preferred** in applications.

---

## 6. Polymorphism (INTERVIEW FAVORITE)

### What is Polymorphism?

> One interface, many implementations.

```java
PaymentService service = new CardPayment();
```

Spring uses polymorphism when:

* Injecting beans
* Switching implementations

---

## 7. Exception Handling (USED HEAVILY IN SPRING)

### What is an Exception?

> An exception represents an abnormal situation during program execution.

```java
try {
    int x = 10 / 0;
} catch (Exception e) {
    e.printStackTrace();
}
```

---

### Checked vs Unchecked Exceptions

| Type      | Example          | Spring Preference |
| --------- | ---------------- | ----------------- |
| Checked   | IOException      | ❌ Avoid           |
| Unchecked | RuntimeException | ✅ Preferred       |

Spring mostly uses **RuntimeException**.

---

## 8. Custom Exceptions (Used in REST APIs)

```java
class UserNotFoundException extends RuntimeException {
    UserNotFoundException(String msg) {
        super(msg);
    }
}
```

Used later with:

* Global exception handling

---

## 9. Collections (Used in Controllers & Repositories)

### List

```java
List<User> users = new ArrayList<>();
```

Used in:

* Returning multiple records

---

### Map

```java
Map<String, String> errors = new HashMap<>();
```

Used in:

* Validation error responses

---

## 10. Annotations (PREVIEW – VERY IMPORTANT)

### What is an Annotation?

> An annotation provides **metadata** about code.

```java
@Override
```

Spring annotations:

* @Component
* @Service
* @Autowired

These are read at runtime using **reflection**.

---

## 11. Key Takeaways (Must Be Clear Before Spring)

You should now clearly understand:

* How Java classes become Spring beans
* Why constructors are critical
* Why interfaces are everywhere
* Why RuntimeException is preferred
* How collections are used in APIs

---

## End of Java Basics (Spring‑Focused)

👉 **Next file**: `01-maven-and-project-setup.md` (aligned to course Maven section)
    