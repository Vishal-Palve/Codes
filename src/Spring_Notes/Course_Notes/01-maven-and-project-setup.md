# Maven & Spring Boot Project Setup (Course‑Aligned, Deep Notes)

> **File name**: `01-maven-and-project-setup.md`
> **Aligned to course**: *Maven Introduction → pom.xml → Dependencies → How Maven Works → Spring Boot project creation*
> **Goal**: Understand **why Maven exists**, **how it works internally**, and **how Spring Boot uses Maven**, exactly as taught in the course—but explained slowly and clearly.

---

## 1. Why Maven Is Needed (The Real Problem)

Before Maven, Java projects had serious issues:

* Manually downloading JAR files
* Managing different versions of libraries
* Classpath conflicts
* No standard project structure

> **Problem**: Dependency management and builds were messy and error‑prone.

Maven was created to **standardize** and **automate** this process.

---

## 2. What is Maven? (Correct Definition)

> **Apache Maven is a build and dependency management tool for Java projects that follows a standard project structure and lifecycle.**

Maven does **three main jobs**:

1. Manages dependencies (libraries)
2. Builds the project (compile, test, package)
3. Provides a standard project structure

---

## 3. Maven Project Structure (VERY IMPORTANT)

A standard Maven project looks like this:

```
project-name/
├── src/
│   ├── main/
│   │   ├── java/        # Application source code
│   │   └── resources/   # application.properties, static files
│   └── test/
│       └── java/        # Test code
├── pom.xml
└── target/              # Generated after build
```

📌 Spring Boot **expects this structure**.

---

## 4. pom.xml (MOST IMPORTANT FILE)

### What is pom.xml?

> **POM (Project Object Model)** is the heart of a Maven project.

It describes:

* Project information
* Dependencies
* Build configuration

---

## 5. Basic pom.xml Structure

```xml
<project>
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>demo</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <dependencies>
        <!-- project dependencies -->
    </dependencies>
</project>
```

---

## 6. groupId, artifactId, version (Explained Clearly)

### groupId

> Represents the **organization or package name**.

Example:

```xml
<groupId>com.telusko</groupId>
```

---

### artifactId

> Name of the project.

```xml
<artifactId>jobapp</artifactId>
```

---

### version

> Project version.

* `SNAPSHOT` → under development
* No SNAPSHOT → stable release

---

## 7. Dependencies (CORE MAVEN FEATURE)

### What is a Dependency?

> A dependency is an **external library** your project needs to work.

Example:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

---

### What Happens Internally?

When Maven sees this dependency:

1. Checks local repository
2. If not found → downloads from Maven Central
3. Adds it to classpath

---

## 8. Maven Repositories

### Local Repository

* Located on your system
* Default: `~/.m2/repository`

---

### Central Repository

* Online repository
* URL: [https://repo.maven.apache.org](https://repo.maven.apache.org)

---

## 9. Dependency Scope (IMPORTANT)

| Scope    | Meaning                       |
| -------- | ----------------------------- |
| compile  | Default, available everywhere |
| test     | Only for testing              |
| provided | Provided by server            |

Spring Boot mostly uses **compile** and **test**.

---

## 10. Maven Lifecycle (INTERVIEW FAVORITE)

Maven follows a **build lifecycle**:

1. validate
2. compile
3. test
4. package
5. install
6. deploy

---

### Common Commands

```bash
mvn clean
mvn compile
mvn test
mvn package
```

---

## 11. How Spring Boot Uses Maven

Spring Boot adds:

* `spring-boot-starter-parent`
* Starter dependencies

---

### spring-boot-starter-parent

```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>3.x.x</version>
</parent>
```

It provides:

* Dependency version management
* Default plugin configuration

📌 You don’t manage versions manually.

---

## 12. Spring Boot Starters (Deep Explanation)

### What is a Starter?

> A **starter** is a collection of compatible dependencies bundled together.

Example:

* `spring-boot-starter-web`

Includes:

* Spring MVC
* Tomcat
* Jackson
* Validation

---

## 13. Creating a Spring Boot Project (Course Style)

Ways:

* Spring Initializr
* IDE (IntelliJ / Eclipse)

Key selections:

* Project: Maven
* Language: Java
* Packaging: Jar

---

## 14. What Happens When You Run mvn package

1. Source code compiled
2. Tests executed
3. JAR file created
4. Stored in `target/`

Spring Boot creates an **executable JAR**.

---

## 15. Common Beginner Mistakes

❌ Deleting pom.xml accidentally
❌ Version conflicts
❌ Manually adding JARs
❌ Wrong dependency scope

---

## 16. Interview‑Ready Takeaways

You must be able to explain:

* What Maven is
* Why pom.xml is important
* What starters are
* How dependencies are resolved
* Difference between compile & test scope

---

## End of Maven & Project Setup

👉 **Next file**: `02-spring-core-ioc-di-and-beans.md`
