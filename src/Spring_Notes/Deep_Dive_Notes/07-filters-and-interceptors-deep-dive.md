# Filters & Interceptors – Deep Dive (Part 7)

> **File name**: `07-filters-and-interceptors-deep-dive.md`
> **Detail level**: High (lifecycle → internals → real use cases → interviews)
>
> **Goal**: Clearly understand **where Filters and Interceptors fit**, **how they differ**, and **when to use each in real projects**.

---

## 1. Why Filters and Interceptors Exist

### The Real Problem

In web applications, some logic is **not business logic** but still must run for many requests:

* Authentication & authorization
* Logging
* Request tracing
* CORS handling
* Metrics

You **should NOT** put this logic in controllers.

> Filters and Interceptors solve *cross‑cutting concerns* in request processing.

---

## 2. Where Filters and Interceptors Sit (Request Lifecycle)

### Complete Request Flow (Simplified)

Client
↓
**Filter**
↓
DispatcherServlet
↓
**Interceptor**
↓
Controller
↓
Service → Repository
↓
Response (reverse order)

📌 **Key Insight**: Filters run **before Spring MVC**, Interceptors run **inside Spring MVC**.

---

## 3. Filters – Deep Explanation

### 3.1 What is a Filter?

> A **Filter** is a Java Servlet component that intercepts requests **before they reach the DispatcherServlet**.

* Part of **Servlet specification**
* Framework‑agnostic
* Works even without Spring MVC

Package:

```java
javax.servlet
```

---

### 3.2 When Filters Are Executed

* Before DispatcherServlet
* After response is generated (on the way back)

They wrap the **entire request lifecycle**.

---

### 3.3 Filter Use Cases (REAL WORLD)

Filters are best for:

* Authentication (JWT, session)
* CORS
* Request/response logging
* Compression

---

### 3.4 Creating a Filter

```java
@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
                         throws IOException, ServletException {

        System.out.println("Request received");
        chain.doFilter(request, response);
        System.out.println("Response sent");
    }
}
```

---

### 3.5 Filter Lifecycle

1. Filter instantiated
2. `init()` called
3. `doFilter()` called for each request
4. `destroy()` called

---

## 4. Interceptors – Deep Explanation

### 4.1 What is an Interceptor?

> An **Interceptor** is a Spring MVC component that intercepts requests **before and after controller execution**.

* Spring‑specific
* Aware of controller and handler

Package:

```java
org.springframework.web.servlet
```

---

### 4.2 Interceptor Methods

```java
public class MyInterceptor implements HandlerInterceptor {

    boolean preHandle(...)
    void postHandle(...)
    void afterCompletion(...)
}
```

---

### 4.3 preHandle()

* Runs **before controller method**
* Can stop request processing

```java
return false; // stops request
```

Used for:

* Authorization
* Validation

---

### 4.4 postHandle()

* Runs **after controller**, before response
* Can modify model

---

### 4.5 afterCompletion()

* Runs after response is sent
* Used for cleanup

---

## 5. Registering an Interceptor

```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/api/**");
    }
}
```

---

## 6. Filters vs Interceptors (VERY IMPORTANT TABLE)

| Aspect            | Filter                   | Interceptor          |
| ----------------- | ------------------------ | -------------------- |
| Part of           | Servlet spec             | Spring MVC           |
| Runs              | Before DispatcherServlet | Before controller    |
| Framework         | Framework‑agnostic       | Spring‑specific      |
| Access to handler | ❌ No                     | ✅ Yes                |
| Typical use       | Security, CORS           | Logging, auth checks |

---

## 7. Common Interview Questions

### Q1: Can Interceptor replace Filter?

❌ No. They operate at different levels.

### Q2: Which runs first?

✅ Filter → Interceptor → Controller

### Q3: Where to implement JWT authentication?

* Filter (preferred)

---

## 8. Best Practices

* Use Filters for security & protocol‑level concerns
* Use Interceptors for Spring MVC concerns
* Keep both lightweight

---

## 9. Common Mistakes

❌ Business logic in filters/interceptors
❌ Heavy processing
❌ Confusing order of execution

---

## End of Part 7

👉 **Next file**: `08-testing-and-mockmvc-deep-dive.md`
