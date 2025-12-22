# REST APIs with Spring Boot (Deep, Course‑Aligned)

**File:** `05-rest-apis-with-spring-boot.md`
**Aligned to Telusko course:** REST Introduction → HTTP Methods → Postman → `@RestController` → `@RequestBody` → `@PathVariable` → `ResponseEntity`

---

## 1. Why REST APIs Are Needed (The Real Problem)

Traditional web applications returned **HTML pages** meant for browsers. Modern applications need:

* Mobile apps
* Frontend frameworks (React, Angular)
* External systems

These clients need **data**, not views.

📌 REST APIs solve this by exposing data over HTTP in formats like JSON.

---

## 2. What is REST? (Correct Definition)

**REST (Representational State Transfer)** is an architectural style for designing networked applications where resources are identified by URLs and manipulated using standard HTTP methods.

Important clarifications:

* REST ❌ is NOT a protocol
* REST ❌ is NOT a framework
* REST ✅ is a design style

---

## 3. Core REST Principles (Course Level)

1. **Statelessness** – each request is independent
2. **Resource-based URLs** – nouns, not verbs
3. **Uniform interface** – standard HTTP methods
4. **Client–server separation**

---

## 4. REST Resource Design (Very Important)

### Good REST URLs

```
GET    /api/users
GET    /api/users/1
POST   /api/users
PUT    /api/users/1
DELETE /api/users/1
```

### Bad REST URLs

```
/getUsers
/deleteUser
```

📌 URLs represent **resources**, actions are represented by HTTP methods.

---

## 5. HTTP Methods (Deep Explanation)

| Method | Meaning | Typical Use    |
| ------ | ------- | -------------- |
| GET    | Read    | Fetch data     |
| POST   | Create  | Insert data    |
| PUT    | Replace | Full update    |
| PATCH  | Modify  | Partial update |
| DELETE | Remove  | Delete data    |

### Important Properties

* GET is **safe** and **idempotent**
* PUT is **idempotent**
* POST is **not idempotent**

---

## 6. `@RestController` (Very Important)

### What does `@RestController` do?

Marks a class as a REST controller where **every method returns data**, not views.

```java
@RestController
public class UserController {
}
```

Internally:

```
@RestController = @Controller + @ResponseBody
```

---

## 7. `@ResponseBody` (Why REST Works)

### Purpose

Tells Spring to write the return value **directly into the HTTP response body**.

Without it:

* Return value → treated as view name

With it:

* Return value → converted to JSON

---

## 8. `@GetMapping`, `@PostMapping`, etc.

Specialized request mapping annotations:

| Annotation       | HTTP Method |
| ---------------- | ----------- |
| `@GetMapping`    | GET         |
| `@PostMapping`   | POST        |
| `@PutMapping`    | PUT         |
| `@DeleteMapping` | DELETE      |

They improve readability and reduce errors.

---

## 9. `@RequestBody` (Critical Annotation)

### What does `@RequestBody` do?

Converts incoming JSON request body into a Java object.

```java
@PostMapping("/users")
public User save(@RequestBody User user) {
    return service.save(user);
}
```

Internally uses **HttpMessageConverter** (Jackson).

---

## 10. `@PathVariable` (Resource Identification)

Extracts values from the URL path.

```java
@GetMapping("/users/{id}")
public User get(@PathVariable int id) {
}
```

Used to uniquely identify a resource.

---

## 11. `@RequestParam` (Query Parameters)

Used for optional or filtering data.

```java
@GetMapping("/search")
public List<User> search(@RequestParam String name) {
}
```

Example URL:

```
/search?name=Spring
```

---

## 12. HTTP Request vs HTTP Response

### Request Contains

* HTTP method
* URL
* Headers
* Body (optional)

### Response Contains

* Status code
* Headers
* Body

---

## 13. HTTP Status Codes (Interview Favorite)

| Code | Meaning      | When to Use       |
| ---- | ------------ | ----------------- |
| 200  | OK           | Successful GET    |
| 201  | Created      | Resource created  |
| 204  | No Content   | Successful delete |
| 400  | Bad Request  | Validation error  |
| 404  | Not Found    | Resource missing  |
| 500  | Server Error | Unhandled error   |

---

## 14. `ResponseEntity` (Full Control)

### What is `ResponseEntity`?

Represents the entire HTTP response including:

* Status code
* Headers
* Body

```java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUser(@PathVariable int id) {
    User user = service.find(id);
    if (user == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(user);
}
```

📌 Preferred for real‑world APIs.

---

## 15. Testing REST APIs Using Postman (Conceptual)

Postman allows you to:

* Send HTTP requests
* Inspect responses
* Test status codes and payloads

Used heavily during development.

---

## 16. Common Beginner Mistakes

* Forgetting `@RequestBody`
* Using verbs in URLs
* Returning entities directly without control
* Ignoring HTTP status codes

---

## 17. Must‑Know Interview Summary

You must be able to explain:

* What REST is
* Why REST APIs are needed
* HTTP methods and their meaning
* `@RestController` vs `@Controller`
* `@RequestBody`, `@PathVariable`, `@RequestParam`
* Why `ResponseEntity` is used

---

## End of REST APIs

**Next file:** `06-spring-data-jpa.md`
