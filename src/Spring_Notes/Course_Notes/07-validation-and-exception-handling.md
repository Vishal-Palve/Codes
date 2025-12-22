# Validation & Exception Handling (Deep, Step-by-Step, Course-Aligned)

**File:** `07-validation-and-exception-handling.md`
**Rewrite level:** VERY DEEP (why → how → internals → runtime flow → mistakes)

---

## 1. Why Validation Exists (Real Problem First)

Before validation frameworks, applications had this flow:

```
Client → Controller → Service → Repository → DB ❌
```

Problems:

* Invalid data reached database
* Errors happened too late
* Database constraints failed
* Users received unclear 500 errors

📌 **Core idea:** Invalid data should be rejected **as early as possible**.

That place is the **Controller layer**.

---

## 2. What Is Validation? (Correct Definition)

Validation is the process of checking whether incoming data satisfies required constraints **before business logic executes**.

Validation answers:

* Is required data present?
* Is data format correct?
* Is data within allowed range?

---

## 3. Bean Validation (JSR-380) – What It Really Is

Bean Validation is a **Java specification**, not Spring-specific.

Spring Boot integrates it automatically using:

* Hibernate Validator (implementation)

📌 Spring does NOT validate by itself — it delegates to Bean Validation.

---

## 4. Where Validation Fits in Spring Request Flow (IMPORTANT)

Actual runtime flow:

```
1. HTTP request arrives
2. DispatcherServlet receives request
3. HttpMessageConverter converts JSON → Java object
4. Bean Validation engine runs (@Valid)
5. If errors → exception thrown
6. Controller method is SKIPPED
```

👉 Validation happens **before** your controller logic runs.

---

## 5. @Valid (VERY DEEP EXPLANATION)

### Why @Valid Exists

Without @Valid:

* Spring binds JSON blindly
* Invalid objects reach service layer

With @Valid:

* Validation is enforced automatically

### What @Valid Actually Does

* Triggers Bean Validation engine
* Checks constraints on object fields

### What @Valid Does NOT Do

❌ It does NOT validate database data
❌ It does NOT save data

---

## 6. Validation Annotations (Each Explained Properly)

### @NotNull

* Field must not be `null`
* Allows empty strings

Used for:

* Numbers
* Objects

---

### @NotEmpty

* Field must not be null AND not empty
* Applies to String / Collection

---

### @NotBlank (MOST USED)

* String must not be null
* Must contain at least one non-space character

Why preferred:

* Prevents whitespace-only input

---

### @Size

* Restricts length or size

```java
@Size(min = 2, max = 50)
private String username;
```

---

### @Min / @Max

* Numeric range validation

---

### @Email

* Checks email format
* Does NOT verify existence

---

### @Pattern

* Regex-based validation

---

## 7. Validation Failure – What Happens Internally

If validation fails:

* Spring throws `MethodArgumentNotValidException`
* Controller method is NOT executed

This is why exception handling is required.

---

## 8. BindingResult (Why It Exists)

### Problem Without BindingResult

* Validation error → exception → no custom response

### What BindingResult Does

* Captures validation errors
* Allows manual handling

```java
public ResponseEntity<?> save(@Valid @RequestBody User user,
                               BindingResult result)
```

📌 Used when you want controller-specific error handling.

---

## 9. Why Exception Handling Is Needed

Without exception handling:

* App crashes
* Client receives 500 error
* No meaningful message

Goal:

* Centralized
* Consistent
* Clean API responses

---

## 10. @ExceptionHandler (Local Handling)

Handles exceptions **inside one controller**.

Limitations:

* Duplicate code
* Not scalable

---

## 11. @ControllerAdvice (GLOBAL HANDLING – VERY IMPORTANT)

### Why It Exists

To handle exceptions across all controllers in ONE place.

### How It Works Internally

* Spring scans @ControllerAdvice
* Registers exception handlers
* Matches thrown exception types

---

## 12. Handling Validation Errors Globally

```java
@ExceptionHandler(MethodArgumentNotValidException.class)
```

Spring extracts:

* Field name
* Error message

Returns structured response.

---

## 13. Custom Exceptions (Service Layer Cleanliness)

Why custom exceptions:

* Meaningful errors
* Clean service logic

```java
throw new ResourceNotFoundException("User not found");
```

---

## 14. @ResponseStatus (Shortcut Mapping)

Maps exception → HTTP status automatically.

Used when:

* No dynamic response needed

---

## 15. Designing Proper Error Responses

Bad:

```
500 Internal Server Error
```

Good:

```json
{
  "status": 400,
  "message": "Validation failed",
  "timestamp": "2025-10-29"
}
```

---

## 16. Common Beginner & Interview Mistakes

❌ Validation in service layer
❌ Ignoring BindingResult
❌ Returning stack traces

---

## 17. Must-Know Interview Summary

You MUST be able to explain:

* Why validation belongs in controller layer
* What @Valid actually triggers
* Why ControllerAdvice exists
* How Spring handles validation failures

---

## End of Validation & Exception Handling

**Next rewrite:** `08-spring-security-basic
