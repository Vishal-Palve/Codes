# Docker & Microservices Basics (Deep, Internals, Course-Aligned)

**File:** `10-docker-and-microservices-basics.md`
**Depth:** VERY DEEP (problem → concepts → internals → runtime flow → mistakes)

---

## 1. Why Docker Exists (REAL PROBLEM FIRST)

### Life Before Docker

Before Docker, applications were deployed like this:

* Works on my machine ❌
* Different OS versions
* Different Java versions
* Different environment variables
* Manual server setup

Result:

* Deployment failures
* Long setup time
* Environment-specific bugs

📌 **Core problem:** Applications were tightly coupled to machines.

---

## 2. What Docker Actually Solves

Docker solves the problem by **packaging the application with its environment**.

Docker ensures:

* Same runtime everywhere
* Predictable behavior
* Fast deployment

📌 Docker removes environment dependency.

---

## 3. What Is Docker? (Correct Definition)

Docker is a **containerization platform** that packages:

* Application code
* Runtime (JVM)
* Dependencies
* Configuration

into a **container**.

---

## 4. Containers vs Virtual Machines (CRITICAL)

### Virtual Machines

* Full OS per application
* Heavy
* Slow startup

### Containers

* Share host OS kernel
* Lightweight
* Fast startup

📌 Containers are NOT mini VMs.

---

## 5. What Is a Container Internally?

A container is:

* A running process
* With isolated filesystem
* Isolated network
* Isolated environment variables

Isolation is provided by:

* Linux namespaces
* cgroups

---

## 6. Docker Image (WHY IT EXISTS)

A Docker image is:

* Read-only template
* Blueprint for containers

Think:

* Image = Class
* Container = Object

---

## 7. Dockerfile (VERY IMPORTANT)

### Why Dockerfile Exists

Dockerfile defines:

* How to build image
* What steps to follow

---

### Basic Dockerfile for Spring Boot

```dockerfile
FROM openjdk:17
COPY target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Explanation:

* FROM → base image
* COPY → application jar
* ENTRYPOINT → run app

---

## 8. How Spring Boot Runs Inside Docker

Runtime flow:

```
Docker Image → Container → JVM starts → Spring Boot starts
```

Spring Boot does NOT know it is running inside Docker.

---

## 9. Ports & Networking (IMPORTANT)

Containers have their own network.

To access application:

```
-p 8080:8080
```

Meaning:

* Host port 8080 → Container port 8080

---

## 10. Environment Variables in Docker

Used to externalize config:

```bash
-e SPRING_PROFILES_ACTIVE=prod
```

📌 Same image, different environments.

---

## 11. Why Microservices Exist (REAL PROBLEM)

### Monolith Problems

* Large codebase
* Slow deployments
* One failure brings entire app down
* Hard to scale specific features

---

## 12. What Are Microservices?

Microservices architecture splits application into:

* Small
* Independent
* Deployable services

Each service:

* Owns its database
* Communicates over network

---

## 13. Monolith vs Microservices (INTERVIEW FAVORITE)

| Aspect         | Monolith | Microservices |
| -------------- | -------- | ------------- |
| Deployment     | Single   | Independent   |
| Scalability    | Limited  | Fine-grained  |
| Failure impact | High     | Isolated      |

---

## 14. Why Docker Is Critical for Microservices

Without Docker:

* Different services need different environments

With Docker:

* Each service packaged independently
* Easy scaling
* Easy deployment

---

## 15. Service Communication (High Level)

Microservices communicate using:

* REST APIs
* HTTP

Later enhanced with:

* Service discovery
* Load balancing

---

## 16. Common Beginner Mistakes

❌ Thinking Docker is VM replacement
❌ Hardcoding config inside image
❌ Breaking monolith without reason

---

## 17. Interview Must-Know Summary

You MUST explain:

* Why Docker exists
* Container vs VM
* What a Docker image is
* Why microservices are needed
* Why Docker + microservices fit together

---

## End of Docker & Microservices Basics

**Next file:** `11-system-design-basics.md`
