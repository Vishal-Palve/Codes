# Spring Web MVC – Deep Dive (Part 3)

> **File name**: `03-spring-web-mvc-deep-dive.md`
> **Goal**: Understand Spring Web MVC *internals*, not just annotations.
>
> If you master this file, you can **draw request flow on a whiteboard** in interviews.

---

## 1. What is Spring Web MVC? (Clear & Deep)

Spring Web MVC is a **web framework** built on top of the Spring Core that helps you build:

* Web applications (HTML views)
* RESTful web services (JSON/XML)

It follows the **Model–View–Controller (MVC)** design pattern.

> Spring Web MVC is *request-driven*, meaning everything starts with an HTTP request.

---

## 2. Why MVC Pattern is Used

### Problem Without MVC

* Business logic mixed with UI code
* Difficult to maintain
* Hard to test

### MVC Solution

| Layer      | Responsibility          |
| ---------- | ----------------------- |
| Model      | Data + business rules   |
| View       | UI / response format    |
| Controller | Handles requests & flow |

📌 **Key idea**: Separation of concerns

---

## 3. DispatcherServlet (MOST IMPORTANT CONCEPT)

### 3.1 What is DispatcherServlet?

> **DispatcherServlet is the front controller of Spring Web MVC.**

This means:

* Every HTTP request goes through it
* It controls the entire request lifecycle

You never call it directly.
Spring Boot configures it automatically.

---

## 4. Complete Request Flow (STEP BY STEP)

This is an **INTERVIEW GOLD QUESTION**.

### Step-by-Step Flow

1. Client sends HTTP request
2. Request reaches **DispatcherServlet**
3. DispatcherServlet asks **HandlerMapping** for matching controller
4. HandlerMapping returns controller method
5. DispatcherServlet uses **HandlerAdapter** to invoke method
6. Controller processes request
7. Controller returns response (Object / ModelAndView)
8. **HttpMessageConverter** converts response to JSON/XML
9. Response sent back to client

📌 For REST APIs, ViewResolver is skipped.

---

## 5. HandlerMapping (In Depth)

### What is HandlerMapping?

> Maps an incoming request URL to the correct controller method.

Example:

```java
@GetMapping("/users/{id}")
```

Internally:

* Matches URL
* Matches HTTP method

Common implementation:

* `RequestMappingHandlerMapping`

---

## 6. HandlerAdapter (In Depth)

### Why HandlerAdapter is Needed

Controllers can be written in different styles.

> HandlerAdapter acts as a bridge between DispatcherServlet and controllers.

It:

* Invokes the controller method
* Handles method arguments

---

## 7. Controller Return Types (Important)

Controllers can return:

1. `String` → View name
2. `ModelAndView`
3. Java Object (REST)
4. `ResponseEntity`

Example:

```java
@GetMapping("/user")
public User getUser() {
    return new User();
}
```

---

## 8. HttpMessageConverter (VERY IMPORTANT)

### What does it do?

> Converts Java objects ↔ HTTP body (JSON/XML).

Example:

* Java → JSON (Response)
* JSON → Java (Request)

Default converter:

* Jackson

📌 Without HttpMessageConverter, REST APIs won’t work.

---

## 9. @Controller vs @RestController (Deep)

### @Controller

* Used for MVC views
* Returns view name

### @RestController

* Used for REST APIs
* Returns data

Equivalent to:

```java
@Controller
@ResponseBody
```

---

## 10. ViewResolver (MVC Only)

### What is ViewResolver?

> Resolves logical view names to actual views.

Example:

```java
return "home"; // home.html
```

Used with:

* JSP
* Thymeleaf

Not used in REST APIs.

---

## 11. Model and ModelAndView

### Model

Used to pass data to views.

```java
model.addAttribute("name", "Spring");
```

### ModelAndView

Contains:

* Model data
* View name

---

## 12. MVC vs REST (INTERVIEW FAVORITE)

| MVC               | REST            |
| ----------------- | --------------- |
| Returns views     | Returns data    |
| Uses ViewResolver | No ViewResolver |
| HTML              | JSON/XML        |

---

## 13. Common Interview Traps

❌ Confusing DispatcherServlet with Controller
❌ Thinking Spring Boot = Spring MVC
❌ Forgetting HttpMessageConverter

---

## 14. What You Must Be Able to Explain

* DispatcherServlet flow
* Role of HandlerMapping
* Role of HandlerAdapter
* How JSON conversion happens
* Difference between MVC & REST

---

## End of Part 3

👉 **Next file**: `04-controllers-and-request-mapping-deep-dive.md`
