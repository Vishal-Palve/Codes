# 🌱 COMPLETE SPRING BOOT WEB & SPRING WEB MVC NOTES (IN‑DEPTH)

> **Guarantee**: If you understand and revise *only this notebook*, you are **exam‑ready, interview‑ready, and real‑world project‑ready** for **Spring Boot Web & Spring MVC**.
>
> **Audience**: Absolute Beginner ➜ Intermediate ➜ Backend Developer ➜ Interview Candidate
> **Language**: Java (Spring Boot)

---

# 1. SPRING FRAMEWORK – FOUNDATION

## 1.1 What is Spring Framework?

Spring Framework is a **comprehensive Java framework** used to build **enterprise‑level, scalable, maintainable applications**.

### Why Spring Exists

Before Spring:

* Tight coupling between classes
* Hard to test code
* Too much boilerplate
* Manual object creation

Spring solves this by:

* Managing objects automatically
* Promoting loose coupling
* Providing modular architecture

---

## 1.2 Core Principles of Spring

### 1.2.1 Inversion of Control (IoC)

**Definition**: Control of object creation and lifecycle is transferred from the programmer to the Spring framework.

#### Without IoC

```java
UserService service = new UserService();
```

* Hard‑coded dependency
* Tight coupling

#### With IoC

```java
@Service
public class UserService { }
```

Spring creates and manages the object.

📌 **Interview Line**: *IoC means the framework controls object creation, not the developer.*

---

### 1.2.2 Dependency Injection (DI)

**Definition**: Spring injects required dependencies into a class automatically.

#### Types of DI

1️⃣ Constructor Injection (**Best Practice**)

```java
@Service
public class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

2️⃣ Setter Injection
3️⃣ Field Injection (❌ Not recommended)

📌 **Why constructor injection?**

* Immutable dependencies
* Easy testing
* Fail fast

---

### 1.2.3 Spring Beans

**Bean** = Any object managed by Spring IoC container

Bean lifecycle:

1. Bean creation
2. Dependency injection
3. Initialization
4. Usage
5. Destruction

---

### 1.2.4 Spring Container

Two types:

* **BeanFactory** (basic)
* **ApplicationContext** (advanced, used in Spring Boot)

Responsibilities:

* Create beans
* Inject dependencies
* Manage lifecycle

---

# 2. SPRING BOOT – SIMPLIFICATION LAYER

## 2.1 What is Spring Boot?

Spring Boot is an **opinionated framework** built on top of Spring that **eliminates boilerplate configuration**.

📌 **Interview Line**: *Spring Boot makes Spring production‑ready with minimal configuration.*

---

## 2.2 Problems in Spring → Solutions in Spring Boot

| Problem              | Spring Boot Solution |
| -------------------- | -------------------- |
| XML config           | Java annotations     |
| Manual setup         | Auto‑configuration   |
| WAR deployment       | Embedded server      |
| Dependency conflicts | Starters             |

---

## 2.3 Spring Boot Starters

Starters are **dependency bundles**.

### spring‑boot‑starter‑web

Includes:

* Spring MVC
* Jackson (JSON)
* Embedded Tomcat
* Validation

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

---

## 2.4 Embedded Server

Spring Boot runs applications as **standalone JARs**.

Default:

* Apache Tomcat (8080)

Alternatives:

* Jetty
* Undertow

---

# 3. SPRING WEB MVC – ARCHITECTURE

## 3.1 What is Spring Web MVC?

Spring Web MVC is a **request‑driven web framework** based on the **Model‑View‑Controller (MVC)** pattern.

Used for:

* Web applications
* REST APIs

---

## 3.2 MVC Components Explained

### Model

* Contains data
* Business logic

### View

* Presentation layer
* HTML, JSP, Thymeleaf

### Controller

* Handles HTTP requests
* Coordinates model & view

---

## 3.3 DispatcherServlet (MOST IMPORTANT)

**Definition**: DispatcherServlet is the **front controller** of Spring MVC.

📌 Every HTTP request passes through DispatcherServlet.

### Request Flow (Step‑by‑Step)

1. Client sends HTTP request
2. DispatcherServlet receives it
3. HandlerMapping finds controller
4. HandlerAdapter invokes method
5. Controller returns response
6. ViewResolver resolves view (if MVC)
7. Response sent to client

📌 **Interview Favorite Question**

> Explain request flow in Spring MVC

---

## 3.4 Core MVC Components

### HandlerMapping

Maps URL → Controller method

### HandlerAdapter

Executes controller method

### ViewResolver

Resolves logical view names

### HttpMessageConverter

Converts:

* Java → JSON
* JSON → Java

---

# 4. CONTROLLERS IN DEPTH

## 4.1 @Controller

Used for **MVC applications**.

```java
@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
```

Returns **view name**.

---

## 4.2 @RestController

Used for **REST APIs**.

Equivalent to:

```java
@Controller
@ResponseBody
```

```java
@RestController
public class ApiController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```

Returns **JSON / XML**, not views.

---

# 5. REQUEST MAPPING ANNOTATIONS (VERY IMPORTANT)

## 5.1 @RequestMapping

Generic mapping for all HTTP methods.

```java
@RequestMapping(value = "/users", method = RequestMethod.GET)
```

---

## 5.2 Specialized Mapping Annotations

| Annotation     | HTTP Method |
| -------------- | ----------- |
| @GetMapping    | GET         |
| @PostMapping   | POST        |
| @PutMapping    | PUT         |
| @DeleteMapping | DELETE      |
| @PatchMapping  | PATCH       |

---

## 5.3 @PathVariable

Used to extract values from URL.

```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id) { }
```

---

## 5.4 @RequestParam

Used for query parameters.

```java
@GetMapping("/search")
public List<User> search(@RequestParam String name) { }
```

Optional:

```java
@RequestParam(required = false, defaultValue = "0") int page
```

---

# 6. REQUEST BODY & HEADERS

## 6.1 @RequestBody

Binds HTTP request body to Java object.

```java
@PostMapping
public User save(@RequestBody User user) { }
```

Uses **Jackson** internally.

---

## 6.2 @RequestHeader

Extracts HTTP headers.

```java
@RequestHeader("User-Agent") String agent
```

---

## 6.3 @ModelAttribute

Binds form data to object.

Used in traditional MVC forms.

---

# 7. RESPONSE HANDLING

## 7.1 Returning Objects

Spring automatically converts objects to JSON.

```java
@GetMapping
public User getUser() { }
```

---

## 7.2 ResponseEntity (INTERVIEW FAVORITE)

Gives full control over HTTP response.

```java
return ResponseEntity
       .status(HttpStatus.CREATED)
       .body(user);
```

---

# 8. VALIDATION (JSR‑380)

## 8.1 Why Validation?

Ensures **data correctness** before processing.

---

## 8.2 Validation Annotations

| Annotation | Meaning         |
| ---------- | --------------- |
| @NotNull   | Cannot be null  |
| @NotBlank  | No empty string |
| @Size      | Length control  |
| @Email     | Email format    |
| @Min/@Max  | Number limits   |

---

## 8.3 Using @Valid

```java
@PostMapping
public ResponseEntity<?> save(@Valid @RequestBody User user) { }
```

---

# 9. EXCEPTION HANDLING

## 9.1 Why Global Exception Handling?

* Clean controllers
* Centralized logic
* Consistent error response

---

## 9.2 @ExceptionHandler

Handles exceptions locally.

---

## 9.3 @ControllerAdvice

Global exception handler.

```java
@ControllerAdvice
public class GlobalExceptionHandler { }
```

---

# 10. FILTERS vs INTERCEPTORS

| Feature  | Filter         | Interceptor       |
| -------- | -------------- | ----------------- |
| Executes | Before servlet | Before controller |
| Package  | javax.servlet  | Spring            |
| Use      | Security       | Logging, Auth     |

---

# 11. INTERVIEW‑CRITICAL ANNOTATIONS

| Annotation     | Purpose              |
| -------------- | -------------------- |
| @Component     | Generic bean         |
| @Service       | Business logic       |
| @Repository    | DB layer             |
| @Autowired     | Dependency injection |
| @Configuration | Config class         |

---

# 12. REAL‑WORLD BEST PRACTICES

* Use DTOs
* Constructor injection
* Layered architecture
* Global exception handling
* Proper HTTP status codes

---

# 13. FINAL INTERVIEW CONFIDENCE

If you master this notebook:

* ✅ You can explain Spring internally
* ✅ You can crack interviews
* ✅ You can build real projects

---

📌 **This notebook is COMPLETE. No external notes required.**
