# Validation & Exception Handling – Deep Dive (Part 6)

> **File name**: `06-validation-and-exception-handling-deep-dive.md`
> **Detail level**: High (concepts → internals → best practices → interview)
>
> **Goal**: Learn how to protect your API from bad data and how to return clean, consistent error responses like a production system.

---

## 1. Why Validation and Exception Handling Matter

### The Real Problem

In real applications:

* Clients send invalid data
* Required fields are missing
* Data types don’t match
* Resources don’t exist

If you don’t handle this properly:

* APIs crash (500 errors)
* Clients get confusing responses
* Debugging becomes painful

> **Good APIs fail gracefully.**

---

## 2. What is Validation? (Clear Definition)

> **Validation is the process of checking whether incoming data satisfies required constraints before business logic is executed.**

Validation should happen:

* As early as possible
* At the boundary of the system (Controller layer)

---

## 3. Bean Validation (JSR‑380)

### What is Bean Validation?

> A standard Java specification for validating object fields using annotations.

Spring Boot integrates Bean Validation automatically.

### Required Dependency

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

---

## 4. Validation Annotations – Explained One by One

### 4.1 @NotNull

> Field must not be null.

```java
@NotNull
private Integer age;
```

Allows empty strings.

---

### 4.2 @NotEmpty

> Field must not be null AND must not be empty.

Used for:

* Strings
* Collections

---

### 4.3 @NotBlank (MOST USED)

> String must not be null, empty, or whitespace only.

```java
@NotBlank
private String name;
```

---

### 4.4 @Size

> Controls size of string or collection.

```java
@Size(min = 2, max = 50)
private String username;
```

---

### 4.5 @Min and @Max

> Numeric range validation.

```java
@Min(18)
@Max(120)
private int age;
```

---

### 4.6 @Email

> Validates email format.

```java
@Email
private String email;
```

---

### 4.7 @Pattern

> Validates using regular expressions.

```java
@Pattern(regexp = "^[0-9]{10}$")
private String phone;
```

---

## 5. Using @Valid in Controllers (CRITICAL)

### What does @Valid do?

> Triggers validation on the annotated object.

```java
@PostMapping("/users")
public ResponseEntity<User> create(@Valid @RequestBody User user) {
    return ResponseEntity.ok(service.save(user));
}
```

If validation fails:

* Method is NOT executed
* Exception is thrown

---

## 6. Validation Error Flow (Internals)

1. HTTP request arrives
2. Spring binds JSON → object
3. Validation annotations are checked
4. If invalid → `MethodArgumentNotValidException`
5. Controller method is skipped

📌 **This is why global exception handling is needed**

---

## 7. BindingResult (Manual Handling)

### What is BindingResult?

> Holds validation results after binding.

```java
public ResponseEntity<?> save(@Valid @RequestBody User user,
                              BindingResult result) {
    if (result.hasErrors()) {
        // handle errors
    }
}
```

Used when:

* You want custom validation response per controller

---

## 8. Exception Handling – Big Picture

### What is an Exception?

> An exception represents an abnormal situation during program execution.

In web apps:

* Resource not found
* Invalid input
* Database errors

---

## 9. Why NOT Handle Exceptions in Controllers

Bad practice:

* Duplicate code
* Messy controllers
* Inconsistent responses

Solution:

> **Global Exception Handling**

---

## 10. @ExceptionHandler (Local Handling)

```java
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> handleNotFound(Exception ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                         .body(ex.getMessage());
}
```

Limitations:

* Applies only to one controller

---

## 11. @ControllerAdvice (GLOBAL HANDLING)

### What is @ControllerAdvice?

> A centralized place to handle exceptions across all controllers.

```java
@ControllerAdvice
public class GlobalExceptionHandler { }
```

---

## 12. Handling Validation Errors Globally

```java
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>> handleValidationErrors(
        MethodArgumentNotValidException ex) {

    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors()
      .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

    return ResponseEntity.badRequest().body(errors);
}
```

---

## 13. Custom Exceptions

### Why Custom Exceptions?

* Meaningful error handling
* Clean service layer

```java
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
```

---

## 14. @ResponseStatus on Exceptions

```java
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException { }
```

Automatically maps exception to HTTP status.

---

## 15. Designing Error Responses (REAL WORLD)

### Bad API Response

```
500 Internal Server Error
```

### Good API Response

```json
{
  "status": 400,
  "message": "Validation failed",
  "timestamp": "2025-10-29T10:00:00"
}
```

---

## 16. Interview-Favorite Questions

* Why validation should be in controller layer?
* Difference between @Valid and BindingResult?
* Why use @ControllerAdvice?
* How does Spring handle validation internally?

---

## 17. Best Practices Summary

* Validate at API boundary
* Use @Valid
* Use global exception handler
* Return meaningful status codes
* Never expose stack traces

---

## End of Part 6

👉 **Next file**: `07-filters-and-interceptors-deep-dive.md`
