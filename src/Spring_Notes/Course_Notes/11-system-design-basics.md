# System Design Basics (Deep, Fresher-Friendly, Course-Aligned)

**File:** `11-system-design-basics.md`
**Depth:** VERY DEEP (foundations → concepts → flows → trade-offs → interview traps)

---

## 1. What System Design Actually Means (Clear the Confusion)

System design is **not** about drawing random boxes.

System design means:

* Deciding **how components work together**
* Handling **scale, failures, and growth**
* Making **trade-offs** based on requirements

📌 For freshers, system design is about **thinking clearly**, not inventing Facebook.

---

## 2. Why System Design Matters (Real Problems)

Without design thinking:

* Apps work for 10 users but fail for 10,000
* Small bugs crash entire systems
* Scaling becomes expensive

📌 Good design avoids rewriting everything later.

---

## 3. Functional vs Non-Functional Requirements

### Functional Requirements

* What the system does
* Example: User can create an account

### Non-Functional Requirements (VERY IMPORTANT)

* How the system behaves
* Scalability
* Availability
* Performance
* Security

📌 Most system design decisions come from non-functional needs.

---

## 4. Scalability (MOST IMPORTANT CONCEPT)

Scalability = ability to handle growth.

### Vertical Scaling

* Add more CPU/RAM
* Simple but limited

### Horizontal Scaling

* Add more machines
* Complex but powerful

📌 Modern systems prefer horizontal scaling.

---

## 5. Stateless vs Stateful Services

### Stateful

* Server remembers user data
* Example: HTTP sessions

### Stateless (Preferred)

* Each request independent
* Data stored externally

📌 REST APIs must be stateless.

---

## 6. Load Balancing (WHY IT EXISTS)

### Problem

* One server cannot handle all traffic

### Solution

* Load balancer distributes requests

```
Client → Load Balancer → Service Instances
```

Benefits:

* High availability
* Better performance

---

## 7. Database Basics in System Design

### Single Database Problem

* Bottleneck
* Single point of failure

### Common Solutions

* Read replicas
* Sharding (advanced)

📌 Freshers should understand the idea, not implementation.

---

## 8. Caching (PERFORMANCE BOOSTER)

### Why Cache?

* Reduce database load
* Faster responses

### Common Cache Locations

* In-memory (Redis)
* Browser cache

📌 Cache trades freshness for speed.

---

## 9. Consistency vs Availability (CAP – Simplified)

You cannot guarantee:

* Consistency
* Availability
* Partition tolerance

all at once.

📌 Real systems choose trade-offs.

---

## 10. Designing APIs (High-Level Thinking)

Good API design:

* Clear URLs
* Proper HTTP methods
* Correct status codes

Your Spring Boot REST knowledge applies here.

---

## 11. Failure Handling (IMPORTANT)

Systems fail.

Good design:

* Fails gracefully
* Uses retries
* Uses timeouts

📌 Failure is expected, not exceptional.

---

## 12. How Your Spring Boot Knowledge Fits

You already know:

* Stateless REST APIs
* JWT authentication
* Database interaction

System design is **connecting these blocks** logically.

---

## 13. Common Fresher & Interview Mistakes

❌ Jumping to microservices immediately
❌ Ignoring non-functional requirements
❌ Overengineering simple systems

---

## 14. Fresher-Level Interview Summary

You MUST explain:

* What system design means
* Scalability types
* Stateless vs stateful
* Why load balancers exist
* Role of caching

---

## End of System Design Basics

**Next file:** `12-final-project-guidance.md`
