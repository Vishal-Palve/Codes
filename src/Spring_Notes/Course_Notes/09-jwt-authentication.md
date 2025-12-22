# JWT Authentication (Deep, Internals, Course‑Aligned)

**File:** `09-jwt-authentication.md`
**Depth:** VERY DEEP (problem → stateless model → token structure → filter flow → runtime steps → mistakes)

---

## 1. Why JWT Exists (REAL PROBLEM FIRST)

### Problem with Session‑Based Authentication

Traditional (session) security works like this:

```
Login → Server creates session → Session ID stored in browser
```

This causes issues:

* Server must store session data (memory/state)
* Difficult to scale horizontally
* Not suitable for REST APIs
* Mobile & multiple clients become hard to manage

📌 **REST APIs must be stateless.**

This is why JWT exists.

---

## 2. What Is JWT? (Correct Definition)

**JWT (JSON Web Token)** is a compact, self‑contained token used to securely transmit user information between client and server.

Key properties:

* Stateless
* Self‑contained
* Signed (tamper‑proof)

📌 JWT does **not** encrypt data by default. It **signs** data.

---

## 3. Stateless Authentication (CORE CONCEPT)

With JWT:

```
Client logs in → Server issues token → Client sends token with every request
```

Important differences:

* No server‑side session storage
* Every request is authenticated independently

📌 Server does not remember the user — the token does.

---

## 4. JWT Structure (VERY IMPORTANT)

A JWT has **three parts**, separated by dots:

```
HEADER.PAYLOAD.SIGNATURE
```

---

### 4.1 Header

Contains:

* Token type (JWT)
* Signing algorithm (HS256, RS256)

Example:

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

---

### 4.2 Payload

Contains **claims** (user data).

Examples:

* username
* roles
* expiration time

```json
{
  "sub": "user1",
  "role": "USER",
  "exp": 1712345678
}
```

📌 Payload is Base64 encoded, NOT encrypted.

---

### 4.3 Signature

Purpose:

* Ensures token integrity
* Prevents tampering

Created using:

```
Base64(Header) + Base64(Payload) + SecretKey
```

If payload is modified → signature validation fails.

---

## 5. Why JWT Is Trusted Without Database Calls

Because:

* Token is signed by server
* Server validates signature on every request

📌 If signature is valid, token is trusted.

---

## 6. JWT Login Flow (STEP‑BY‑STEP)

```
1. Client sends username & password
2. Authentication filter intercepts request
3. Credentials are verified
4. JWT is generated
5. JWT is returned to client
```

Client stores token (header / local storage).

---

## 7. JWT Request Flow (VERY IMPORTANT)

```
Client → Request + Authorization Header
        ↓
JWT Filter
        ↓
Token validation
        ↓
SecurityContext populated
        ↓
Controller executed
```

Authorization header format:

```
Authorization: Bearer <JWT_TOKEN>
```

---

## 8. JWT Filter (WHY IT EXISTS)

Spring Security does NOT understand JWT by default.

A **custom JWT filter** is required to:

* Extract token from header
* Validate token
* Set authentication in SecurityContext

📌 This filter runs **before** controllers.

---

## 9. Token Expiration (CRITICAL)

Why expiration is required:

* Prevent stolen token misuse
* Limit damage window

Expired token:

* Rejected
* User must login again

---

## 10. JWT vs Session (INTERVIEW FAVORITE)

| Aspect        | Session  | JWT       |
| ------------- | -------- | --------- |
| State         | Stateful | Stateless |
| Storage       | Server   | Client    |
| Scalability   | Hard     | Easy      |
| REST friendly | ❌        | ✅         |

---

## 11. Where JWT Fits in Spring Security

JWT logic lives in:

* Security Filter Chain
* BEFORE DispatcherServlet

JWT never touches controllers directly.

---

## 12. Common Beginner Mistakes

❌ Storing sensitive data in payload
❌ Forgetting token expiration
❌ Thinking JWT is encrypted
❌ Putting JWT logic in controller

---

## 13. Interview Must‑Know Summary

You MUST be able to explain:

* Why sessions don’t work for REST
* What stateless authentication means
* JWT structure (header, payload, signature)
* How token is validated
* Where JWT fits in filter chain

---

## End of JWT Authentication (Deep)

**Next file:** `10-docker-and-microservices-basics.md`
