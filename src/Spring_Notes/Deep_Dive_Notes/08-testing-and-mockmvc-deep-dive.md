# Testing & MockMvc – Deep Dive (Part 8)

> **File name**: `08-testing-and-mockmvc-deep-dive.md`
> **Detail level**: High (why → types → annotations → internals → examples → interviews)
>
> **Goal**: Learn how Spring Boot applications are tested **professionally**, not just how to make tests pass.

---

## 1. Why Testing Matters in Spring Boot

### The Real Reasons (Not Theory)

* Prevents regressions when code changes
* Gives confidence to refactor
* Catches bugs before production
* Required in real teams and interviews

> **If code is not tested, it is not production‑ready.**

---

## 2. Types of Tests (Big Picture)

### 2.1 Unit Tests

> Test **one class in isolation**.

* Fast
* No Spring context
* Uses mocks

Example:

* Service class logic

---

### 2.2 Integration Tests

> Test **multiple components together**.

* Slower
* Spring context is loaded
* Tests real wiring

Example:

* Controller + Service + Repository

---

### 2.3 End‑to‑End Tests

> Test the full application as a user would.

* Slowest
* Rare in backend interviews

---

## 3. Testing Support in Spring Boot

Spring Boot provides:

* JUnit 5
* Mockito
* Spring TestContext Framework

Included via:

```xml
spring-boot-starter-test
```

---

## 4. @SpringBootTest (In Depth)

### What does @SpringBootTest do?

> Loads the **entire Spring application context**.

```java
@SpringBootTest
class UserServiceTest { }
```

When to use:

* Integration tests
* Testing multiple layers together

Downside:

* Slow

---

## 5. @WebMvcTest (Controller‑Focused Testing)

### What does @WebMvcTest do?

> Loads **only MVC components**, not full context.

```java
@WebMvcTest(UserController.class)
class UserControllerTest { }
```

Loads:

* Controllers
* Filters
* Interceptors

Does NOT load:

* Services
* Repositories

---

## 6. Mocking Dependencies with @MockBean

### Why Mocking is Needed

Controllers depend on services.

In @WebMvcTest:

* Services are NOT loaded

```java
@MockBean
private UserService userService;
```

Spring injects this mock into controller.

---

## 7. MockMvc – Core Concept

### What is MockMvc?

> MockMvc simulates HTTP requests **without starting a server**.

* Fast
* Accurate
* Interview favorite

---

## 8. MockMvc Example (Step by Step)

```java
@Autowired
private MockMvc mockMvc;

@Test
void shouldReturnUser() throws Exception {
    mockMvc.perform(get("/api/users/1"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id").value(1));
}
```

What happens internally:

* Request goes through DispatcherServlet
* Controller method executed
* Response validated

---

## 9. Testing POST Requests

```java
mockMvc.perform(post("/api/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\":\"John\"}"))
       .andExpect(status().isCreated());
```

---

## 10. @AutoConfigureMockMvc

Used with:

```java
@SpringBootTest
@AutoConfigureMockMvc
```

Allows MockMvc with full context.

---

## 11. Testing Validation Errors

```java
mockMvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{}"))
       .andExpect(status().isBadRequest());
```

---

## 12. Common Testing Mistakes

❌ Loading full context for simple tests
❌ Not mocking dependencies
❌ Asserting only status code

---

## 13. Interview Questions (VERY COMMON)

* Difference between @SpringBootTest and @WebMvcTest?
* What is MockMvc?
* Why not start server during tests?
* How do you test validation?

---

## 14. Best Practices

* Use @WebMvcTest for controllers
* Use @SpringBootTest for integration tests
* Keep tests fast
* Test both success and failure cases

---

## End of Part 8

👉 **Next file**: `09-real-world-project-flow-and-architecture.md`
