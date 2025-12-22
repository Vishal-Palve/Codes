# Controllers & Request Mapping – Deep Dive (Part 4)

> **File name**: `04-controllers-and-request-mapping-deep-dive.md`
> **Goal**: Understand **how controllers really work**, how Spring binds requests to methods, and how data flows into your code.

---

## 1. What is a Controller in Spring?

### Proper Definition

> A **Controller** is a Spring-managed bean responsible for **handling incoming HTTP requests**, **processing them**, and **returning an appropriate response**.

Important points:

* Controller is NOT a servlet
* Controller does NOT directly read raw sockets
* Controller works *through DispatcherServlet*

---

## 2. Role of Controller in Request Flow (Context)

Where controller fits:

Client → DispatcherServlet → **Controller** → Service → Repository → Response

The controller:

* Receives already-parsed request data
* Delegates business logic to service layer
* Never contains business logic itself (best practice)

---

## 3. @Controller Annotation (In Depth)

### What does @Controller mean?

> Marks a class as a **Spring MVC controller** that returns **views**.

```java
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home"; // view name
    }
}
```

Key behavior:

* Return value is treated as **view name**
* Requires **ViewResolver**

---

## 4. @RestController Annotation (In Depth)

### What does @RestController mean?

> Marks a class as a controller where **every method returns data**, not views.

```java
@RestController
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```

Internally:

```java
@RestController = @Controller + @ResponseBody
```

Meaning:

* Response body is written directly
* Uses HttpMessageConverter

---

## 5. @ResponseBody (Very Important)

### What does @ResponseBody do?

> Tells Spring to write the return value **directly into the HTTP response body**.

Without it:

* Return value → View name

With it:

* Return value → HTTP body (JSON/text)

---

## 6. Request Mapping Basics

### What is Request Mapping?

> Mapping an **HTTP request** to a **specific controller method**.

Mapping is based on:

* URL path
* HTTP method
* Headers
* Parameters

---

## 7. @RequestMapping (Generic Mapping)

```java
@RequestMapping(value = "/users", method = RequestMethod.GET)
```

Features:

* Supports all HTTP methods
* Verbose
* Flexible

Used mostly at **class level** now.

---

## 8. Specialized Mapping Annotations (Preferred)

| Annotation     | HTTP Method |
| -------------- | ----------- |
| @GetMapping    | GET         |
| @PostMapping   | POST        |
| @PutMapping    | PUT         |
| @DeleteMapping | DELETE      |
| @PatchMapping  | PATCH       |

Why preferred:

* Cleaner
* More readable
* Less error-prone

---

## 9. Class-Level vs Method-Level Mapping

```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) { }
}
```

Final URL:

```
/api/users/{id}
```

---

## 10. @PathVariable (Deep Explanation)

### What is @PathVariable?

> Extracts values from **URI path segments**.

```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id) { }
```

Why use it?

* Represents resource identity
* REST best practice

---

## 11. @RequestParam (Deep Explanation)

### What is @RequestParam?

> Extracts values from **query parameters**.

```java
@GetMapping("/search")
public List<User> search(@RequestParam String name) { }
```

URL:

```
/search?name=spring
```

Optional params:

```java
@RequestParam(required = false, defaultValue = "0") int page
```

---

## 12. @RequestBody (Very Important)

### What does @RequestBody do?

> Converts HTTP request body into a Java object.

```java
@PostMapping("/users")
public User save(@RequestBody User user) { }
```

Internally:

* Uses HttpMessageConverter
* Uses Jackson for JSON

---

## 13. @RequestHeader

### Purpose

> Reads HTTP headers into method parameters.

```java
@GetMapping
public String agent(@RequestHeader("User-Agent") String agent) { }
```

---

## 14. @CookieValue

> Extracts cookie values from request.

```java
@CookieValue("SESSION") String sessionId
```

---

## 15. @ModelAttribute (MVC Forms)

### What does @ModelAttribute do?

> Binds form data or request parameters to a Java object.

Mostly used in:

* JSP
* Thymeleaf

---

## 16. Method Argument Resolution (Internals)

Spring automatically provides:

* @PathVariable
* @RequestParam
* @RequestBody
* HttpServletRequest
* HttpServletResponse

This is handled by **HandlerMethodArgumentResolver**.

---

## 17. Common Mistakes (Interview + Real World)

❌ Putting business logic in controller
❌ Forgetting @RequestBody
❌ Using @Controller instead of @RestController
❌ Wrong URL mapping

---

## 18. Best Practices

* Controllers should be thin
* Delegate logic to service layer
* Use DTOs
* Use proper HTTP methods

---

## End of Part 4