# Request, Response & REST APIs – Deep Dive (Part 5)

> **File name**: `05-request-response-and-rest-api-deep-dive.md`
> **Goal**: Build a *real* understanding of HTTP, REST APIs, and how Spring Boot handles requests and responses internally.

---

## 1. What is HTTP? (Foundation You Must Know)

### Proper Definition

> **HTTP (HyperText Transfer Protocol)** is a stateless, request–response protocol used for communication between client and server.

Key characteristics:

* Stateless (each request is independent)
* Client–server model
* Text-based protocol

---

## 2. HTTP Request – Deep Explanation

### What is an HTTP Request?

> An HTTP request is a message sent by the client to ask the server to perform an action.

### Parts of an HTTP Request

1. **Request Line**
2. **Headers**
3. **Body (optional)**

---

### 2.1 Request Line

Example:

```
POST /api/users HTTP/1.1
```

Contains:

* HTTP method (POST)
* URI (/api/users)
* Protocol version

---

### 2.2 HTTP Methods (VERY IMPORTANT)

| Method | Meaning   | Use Case         |
| ------ | --------- | ---------------- |
| GET    | Read data | Fetch users      |
| POST   | Create    | Create user      |
| PUT    | Replace   | Update full user |
| PATCH  | Modify    | Partial update   |
| DELETE | Remove    | Delete user      |

📌 **Interview Tip**: GET must be idempotent and safe.

---

### 2.3 Request Headers

Headers provide **metadata** about the request.

Common headers:

* `Content-Type`
* `Accept`
* `Authorization`

Example:

```
Content-Type: application/json
```

---

### 2.4 Request Body

Contains actual data sent to server.

Used mainly with:

* POST
* PUT
* PATCH

JSON Example:

```json
{
  "name": "Spring",
  "email": "spring@example.com"
}
```

---

## 3. How Spring Reads HTTP Requests

Spring uses:

* **DispatcherServlet**
* **HandlerMethodArgumentResolver**
* **HttpMessageConverter**

Flow:
HTTP Request → Java method parameters

---

## 4. HTTP Response – Deep Explanation

### What is an HTTP Response?

> An HTTP response is a message sent by the server back to the client after processing the request.

### Parts of HTTP Response

1. Status code
2. Headers
3. Body

---

## 5. HTTP Status Codes (INTERVIEW FAVORITE)

### Categories

| Range | Meaning      |
| ----- | ------------ |
| 2xx   | Success      |
| 3xx   | Redirection  |
| 4xx   | Client error |
| 5xx   | Server error |

---

### Common Status Codes You MUST Know

| Code | Meaning               | When to Use       |
| ---- | --------------------- | ----------------- |
| 200  | OK                    | Successful GET    |
| 201  | Created               | Resource created  |
| 204  | No Content            | Successful delete |
| 400  | Bad Request           | Validation error  |
| 401  | Unauthorized          | No auth           |
| 403  | Forbidden             | No permission     |
| 404  | Not Found             | Resource missing  |
| 500  | Internal Server Error | Server crash      |

---

## 6. REST – Proper Definition (NOT BUZZWORDS)

> **REST (Representational State Transfer)** is an architectural style for designing networked applications.

REST is NOT:

* A protocol
* A framework

---

## 7. Core REST Principles

1. Statelessness
2. Client–server separation
3. Resource-based URLs
4. Uniform interface

---

## 8. REST Resource Design

### Good REST URLs

```
GET    /api/users
GET    /api/users/10
POST   /api/users
PUT    /api/users/10
DELETE /api/users/10
```

Bad practice:

```
/getUsers
/deleteUser
```

---

## 9. REST in Spring Boot

Spring REST APIs are built using:

* @RestController
* @RequestMapping
* @RequestBody
* @ResponseBody

---

## 10. ResponseEntity (VERY IMPORTANT)

### What is ResponseEntity?

> ResponseEntity represents the **entire HTTP response**.

Includes:

* Status code
* Headers
* Body

---

### Example

```java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUser(@PathVariable Long id) {
    User user = service.findById(id);

    if (user == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(user);
}
```

📌 **Interview Line**:

> ResponseEntity gives full control over HTTP response.

---

## 11. @ResponseStatus

Used to define default HTTP status.

```java
@ResponseStatus(HttpStatus.CREATED)
@PostMapping
public User create(@RequestBody User user) {
    return service.save(user);
}
```

---

## 12. Content Negotiation

### What is Content Negotiation?

> Process of selecting response format based on client request.

Based on:

* `Accept` header

Example:

```
Accept: application/json
```

---

## 13. Error Handling in REST APIs

REST APIs should return:

* Meaningful status codes
* Structured error responses

Handled using:

* @ControllerAdvice
* @ExceptionHandler

---

## 14. REST Best Practices (REAL WORLD)

* Use nouns in URLs
* Use HTTP methods properly
* Return correct status codes
* Do not expose entities directly
* Version APIs (`/api/v1`)

---

## 15. What You Must Be Able to Explain

* Difference between request and response
* Meaning of HTTP status codes
* REST principles
* Why ResponseEntity is used
* How Spring converts JSON

---

## End of Part 5

👉 **Next file**: `06-validation-and-exception-handling-deep-dive.md`
