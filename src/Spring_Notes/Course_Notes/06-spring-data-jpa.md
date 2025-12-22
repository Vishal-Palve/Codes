# Spring Data JPA (Deep, Course-Aligned)

**File:** `06-spring-data-jpa.md`
**Aligned to Telusko course:** ORM → JPA → Hibernate → Entity → Repository → CRUD → JPQL (basics)

---

## 1. Why Spring Data JPA Is Needed (The Real Problem)

Before ORM tools, developers used **JDBC** directly.

### Problems with JDBC

* Too much boilerplate code
* Manual connection handling
* Manual SQL writing
* Error-prone ResultSet mapping
* Difficult to maintain large applications

Spring Data JPA solves these problems by **abstracting database interaction**.

---

## 2. What is ORM? (Very Important)

**ORM (Object Relational Mapping)** is a technique that maps:

* Java objects ↔ Database tables

Meaning:

* Java class → Table
* Object → Row
* Field → Column

📌 ORM allows developers to think in terms of **objects**, not SQL tables.

---

## 3. What is JPA?

**JPA (Java Persistence API)** is a **specification** that defines how ORM should work in Java.

Important clarifications:

* JPA ❌ is NOT an implementation
* JPA ✅ defines rules and annotations

Common JPA implementations:

* Hibernate (used by Spring Boot)

---

## 4. Hibernate (Used Internally)

Hibernate is an **ORM framework** that implements JPA.

Spring Boot uses Hibernate as the default JPA provider.

You write JPA code, Hibernate executes it.

---

## 5. Entity and Table Mapping

### What is an Entity?

An entity is a Java class that represents a database table.

```java
@Entity
public class User {
}
```

---

## 6. `@Entity` Annotation (Deep)

### Purpose

* Marks a class as a JPA entity
* Tells Hibernate to map it to a table

Rules:

* Must have a default constructor
* Must have a primary key

---

## 7. `@Id` and `@GeneratedValue`

### `@Id`

Marks the primary key.

```java
@Id
private Long id;
```

### `@GeneratedValue`

Automatically generates primary key values.

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

Common strategies:

* IDENTITY
* AUTO

---

## 8. Column Mapping Annotations

### `@Column`

Maps a field to a table column.

```java
@Column(name = "user_name")
private String name;
```

Used when column name differs from field name.

---

## 9. Repository Layer (Most Important Part)

### What is a Repository?

A repository handles database operations.

Spring Data JPA provides ready-made repository interfaces.

---

## 10. `JpaRepository` (Core Interface)

```java
public interface UserRepository extends JpaRepository<User, Long> {
}
```

What Spring Data JPA gives you automatically:

* `findAll()`
* `findById()`
* `save()`
* `deleteById()`

📌 No implementation required.

---

## 11. How Spring Creates Repository Implementations

At runtime:

* Spring creates a proxy class
* Generates SQL internally
* Executes queries using Hibernate

This is why you never write repository implementations manually.

---

## 12. CRUD Operations (Basic)

### Create / Update

```java
repository.save(user);
```

### Read All

```java
repository.findAll();
```

### Read By ID

```java
repository.findById(id);
```

### Delete

```java
repository.deleteById(id);
```

---

## 13. Query Methods (Course-Level)

Spring Data JPA allows method names to define queries.

Example:

```java
List<User> findByName(String name);
```

Spring automatically generates the SQL.

---

## 14. JPQL (Basic Understanding)

**JPQL (Java Persistence Query Language)** works with:

* Entity names
* Entity fields

Example:

```java
@Query("SELECT u FROM User u WHERE u.name = :name")
List<User> findUsers(@Param("name") String name);
```

JPQL is database-independent.

---

## 15. application.properties for JPA

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=postgres
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 16. Common Beginner Mistakes

* Forgetting `@Entity`
* No default constructor
* Missing `@Id`
* Writing SQL everywhere

---

## 17. Must-Know Interview Summary

You must be able to explain:

* What ORM is
* Difference between JPA and Hibernate
* What an Entity is
* Purpose of `JpaRepository`
* How CRUD works without SQL

---

## End of Spring Data JPA

**Next file:** `07-validation-and-exception-handling.md`
