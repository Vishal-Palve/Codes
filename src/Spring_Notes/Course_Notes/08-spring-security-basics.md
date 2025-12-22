# Spring Security Basics (Deep, Internals, Course-Aligned)

**File:** `08-spring-security-basics.md`
**Rewrite level:** VERY DEEP (problem → architecture → filter flow → annotations → mistakes)

---

## 1. Why Security Exists (REAL Problem, Not Theory)

Before Spring Security, applications handled security like this:

* Login logic inside controllers
* Role checks scattered across code
* Passwords stored in plain text

This caused:

* Security bugs
* Code duplication
* Easy attacks

📌 **Security is a cross-cutting concern** and must be handled outside business logic.

---

## 2. What Spring Security REALLY Is

Spring Security is a **filter-based security framework** that protects applications at the **HTTP request level**.

Important:

* It does NOT work inside controllers
* It does NOT rely on annotations alone

It works **before** your controller is reached.

---

## 3. Authentication vs Authorization (DEEP CLARITY)

### Authentication (WHO ARE YOU?)

* Confirms user identity
* Example: username + password

📌 Happens first

---

### Authorization (WHAT CAN YOU DO?)

* Confirms access rights
* Example: ADMIN vs USER

📌 Happens only AFTER authentication

---

## 4. Where Spring Security Fits (CRITICAL FLOW)

Actual runtime flow:

```
Client
 ↓
Spring Security Filter Chain
 ↓
DispatcherServlet
 ↓
Controller
```

👉 If a request fails security checks, **DispatcherServlet is never reached**.

---

## 5. Spring Security Filter Chain (CORE CONCEPT)

### What Is a Filter Chain?

A chain of servlet filters that:

* Intercept every request
* Decide authentication & authorization

Examples of filters:

* UsernamePasswordAuthenticationFilter
* BasicAuthenticationFilter
* ExceptionTranslationFilter

📌 Order of filters MATTERS.

---

## 6. Default Spring Security Behavior (IMPORTANT)

When Spring Security dependency is added:

* All endpoints become secured
* A default login form is generated
* A default user is created

Startup log shows password:

```
Using generated security password: xxxx
```

This behavior exists to prevent accidental unsecured apps.

---

## 7. How Login Works Internally (STEP BY STEP)

1. Client sends credentials
2. Authentication filter intercepts request
3. AuthenticationManager is invoked
4. UserDetailsService loads user
5. PasswordEncoder verifies password
6. SecurityContext is populated
7. Request proceeds to controller

📌 If any step fails → request blocked.

---

## 8. UserDetailsService (WHY IT EXISTS)

Spring Security does NOT know how your users are stored.

UserDetailsService:

* Loads user from DB / memory
* Converts it into Spring Security format

This keeps security independent of storage.

---

## 9. PasswordEncoder (ABSOLUTELY REQUIRED)

### Why Plain Text Passwords Are BANNED

* Database leaks
* Insider attacks

Spring Security enforces:

* Encoded passwords only

Default:

* BCryptPasswordEncoder

📌 Without encoder → login fails.

---

## 10. Sessions vs Stateless Security

### Session-Based (MVC Apps)

* User logged in once
* Session ID stored in browser

### Stateless (REST APIs)

* No session stored
* Every request authenticated

JWT is used here.

---

## 11. CSRF (WHY IT EXISTS)

### What Is CSRF?

An attack where:

* A logged-in user is tricked
* Browser sends authenticated request unknowingly

Spring Security:

* Enables CSRF by default for web apps

📌 Often disabled for REST APIs.

---

## 12. Securing Endpoints (Conceptual)

Security rules decide:

* Which URLs are public
* Which need authentication

This is configured in SecurityFilterChain.

---

## 13. Common Beginner & Interview Mistakes

❌ Thinking controllers handle security
❌ Forgetting password encoder
❌ Confusing authentication with authorization
❌ Ignoring filter order

---

## 14. Interview Must-Know Summary

You MUST clearly explain:

* Why Spring Security uses filters
* Where security fits in request lifecycle
* Authentication vs authorization
* Role of UserDetailsService
* Why PasswordEncoder is mandatory

---

## End of Spring Security Basics (Deep)

**Next file:** `09-jwt-authentication.md`
