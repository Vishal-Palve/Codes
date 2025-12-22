# Spring Web MVC (Deep, Course-Aligned)

**File:** `04-spring-web-mvc.md`
**Aligned to Telusko course:** Web App Introduction → Servlet basics → MVC → DispatcherServlet → Controller → Model → View

---

## 1. Why Spring Web MVC Exists (The Real Problem)

Before Spring MVC, Java web applications were built using **Servlets and JSP** directly.

### Problems with Pure Servlets

* Too much boilerplate code
* Business logic mixed with request handling
* Hard to maintain large applications
* Difficult testing

Example problem:

```java
protected void doGet(HttpServletRequest req, HttpServletResponse res) {
    // request parsing
    // business logic
    // response writing
}
```

Everything lived in one place.

📌 **Goal of Spring Web MVC**: Separate responsibilities and organize web applications cleanly.

---

## 2. What is Spring Web MVC? (Correct Definition)

Spring Web MVC is a **web framework built on top of Spring Core** that follows the **Model–View–Controller (MVC)** design pattern to handle HTTP requests.

Important points:

* It is **request-driven**
* Built on top of **Servlet API**
* Uses a **Front Controller** architecture

---

## 3. MVC Pattern (Explained Slowly)

### Model

* Holds application data
* Represents business data
* Example: User, Product, Job

### View

* Responsible for presentation
* JSP / Thymeleaf / HTML
* Displays data from Model

### Controller

* Handles HTTP requests
* Calls service layer
* Chooses view or returns data

📌 **Key idea**: Separation of concerns

---

## 4. Spring MVC Request Flow (Big Picture)

```
Client (Browser)
      ↓
DispatcherServlet
      ↓
Controller
      ↓
Service → Repository → DB
      ↓
Response (View / JSON)
```

Every request passes through **DispatcherServlet**.

---

## 5. DispatcherServlet (MOST IMPORTANT)

### What is DispatcherServlet?

DispatcherServlet is the **Front Controller** of Spring MVC.

Meaning:

* It receives **all incoming HTTP requests**
* Decides which controller should handle the request
* Manages the complete request lifecycle

You never call DispatcherServlet directly.

---

## 6. Why is it Called Front Controller?

Because:

* It sits at the front of request handling
* Centralizes request processing
* Prevents duplicate logic across controllers

📌 **Interview line**: DispatcherServlet acts as a front controller that routes requests to appropriate handlers.

---

## 7. Complete Request Flow (Step by Step – INTERVIEW FAVORITE)

1. Client sends HTTP request
2. Request reaches DispatcherServlet
3. DispatcherServlet asks **HandlerMapping** for matching controller
4. HandlerMapping returns controller method
5. DispatcherServlet uses **HandlerAdapter** to invoke method
6. Controller executes logic
7. Controller returns response (Object / View name)
8. Response is converted (JSON / View)
9. Response sent back to client

---

## 8. HandlerMapping (Deep Explanation)

### What is HandlerMapping?

HandlerMapping maps an incoming request to a controller method.

It matches based on:

* URL path
* HTTP method (GET, POST)
* Request parameters

Example:

```java
@GetMapping("/users/{id}")
```

Spring uses `RequestMappingHandlerMapping` internally.

---

## 9. HandlerAdapter (Why It Exists)

### Problem

Controllers can be written in different styles.

### Solution

HandlerAdapter acts as a bridge between DispatcherServlet and controller methods.

Responsibilities:

* Invokes controller method
* Resolves method parameters
* Handles return values

---

## 10. Controller Return Types

A controller method can return:

* String → View name
* ModelAndView
* Java Object (REST)
* ResponseEntity

Spring decides how to handle the response based on return type.

---

## 11. HttpMessageConverter (VERY IMPORTANT)

### What does it do?

Converts:

* Java Object → JSON/XML (Response)
* JSON/XML → Java Object (Request)

Default converter:

* Jackson

Without HttpMessageConverter, REST APIs will not work.

---

## 12. ViewResolver (MVC Only)

### What is ViewResolver?

ViewResolver resolves logical view names to actual view files.

Example:

```java
return "home";  // home.jsp / home.html
```

Used only in traditional MVC apps, **not REST APIs**.

---

## 13. Model and ModelAndView

### Model

Used to pass data from controller to view.

```java
model.addAttribute("name", "Spring");
```

### ModelAndView

Holds:

* Model data
* View name

```java
return new ModelAndView("home", "msg", "Hello");
```

---

## 14. MVC vs REST (Course-Level Comparison)

| MVC               | REST            |
| ----------------- | --------------- |
| Returns views     | Returns data    |
| Uses ViewResolver | No ViewResolver |
| HTML response     | JSON/XML        |

---

## 15. Common Beginner Mistakes

* Confusing Controller with DispatcherServlet
* Writing business logic in controllers
* Expecting ViewResolver in REST APIs

---

## 16. Must-Know Interview Summary

You must be able to explain:

* What Spring MVC is
* MVC pattern roles
* DispatcherServlet request flow
* HandlerMapping and HandlerAdapter
* How JSON conversion happens
* MVC vs REST

---

## End of Spring Web MVC

**Next file:** `05-rest-apis-with-spring-boot.md`
