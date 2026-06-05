# Java & Spring Backend Study Examples

A collection of practical examples, code snippets, and mini-projects covering various Java and Spring backend development topics.

This repository is intended as a learning resource for developers who want to explore backend concepts through simple, focused examples rather than large production applications.

## Goals

- Learn core Java backend concepts
- Explore Spring ecosystem features
- Practice common backend design patterns
- Understand database integration and API development
- Build a reference library of backend examples

## Topics Covered

### Core Java

- Object-Oriented Programming (OOP)
- Collections Framework
- Generics
- Streams API
- Functional Programming
- Concurrency & Multithreading
- Exception Handling
- File I/O
- Reflection

### Spring Boot

- REST APIs
- Configuration Properties
- Profiles
- Validation
- Exception Handling
- Logging
- Testing

### Testing

- JUnit
- Mockito
- Integration Testing
- Testcontainers

### Architecture & Design

- Layered Architecture
- Clean Architecture
- Hexagonal Architecture
- Design Patterns
- Domain-Driven Design (DDD)

### DevOps & Deployment

- Docker
- Docker Compose
- CI/CD Examples

## Repository Structure

```text
.
├── java/
│   ├── collections/
│   ├── streams/
│   ├── concurrency/
│   └── ...
│
├── spring-boot/
│   ├── rest-api/
│   ├── validation/
│   ├── exception-handling/
│   └── ...
│
├── data/
│   ├── jpa/
│   ├── hibernate/
│   └── ...
│
├── security/
│   ├── jwt/
│   ├── authentication/
│   └── ...
│
└── README.md
```

## Example Structure

Each topic should be self-contained and include:

```text
topic-name/
├── src/
├── README.md
├── pom.xml
└── notes.md
```

### Topic README Contents

- Overview
- Problem Statement
- Key Concepts
- Implementation Details
- How to Run
- Expected Output
- References

## Prerequisites

- Java 17+ (or your preferred version)
- Maven or Gradle
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)
- Docker (for container-related examples)

## Running Examples

Clone the repository:

```bash
git clone <repository-url>
cd <repository-name>
```

Navigate to an example:

```bash
cd spring-boot/rest-api
```

Run using Maven:

```bash
mvn spring-boot:run
```

Or execute tests:

```bash
mvn test
```

## Learning Approach

Each example focuses on:

1. A single concept or feature
2. Minimal but complete implementation
3. Clear explanations
4. Best practices where applicable
5. Easy experimentation and modification

## Future Topics

- Microservices
- Spring Cloud
- Distributed Systems
- Caching (Redis)
- Observability
- Kubernetes
- Reactive Programming (WebFlux)
- GraphQL
- Performance Optimization

---

**Happy Learning & Coding! ☕🚀**
