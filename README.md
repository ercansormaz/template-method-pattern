# Spring Boot Template Method Pattern Example: Email Template API

This project demonstrates the use of the **Template Method Pattern** in a **Spring Boot** application. 
It provides an API to build email content dynamically based on a given category and body. 
The project illustrates how **fixing the algorithm structure in an abstract class while allowing subclasses to customize certain steps** can be implemented in a real-world scenario using Spring DI.

---

## 📌 Overview

The system generates emails in the following structure:

```bash
Header
Body (from request)
Footer
```

Different **email categories** (family, work, friend) have their own **header** and **footer**, while the **algorithm to build the email remains consistent**.

- The **Template Method Pattern** ensures that:
- The skeleton of the algorithm is defined once in an abstract class.
- Subclasses override only the variable parts (header/footer).
- The core algorithm (`buildEmail`) is **final**, preventing subclasses from altering the concatenation logic.

---

## 📂 Project Structure
```bash
dev.ercan.poc.template
│
├─ controller
│   └─ EmailController.java         # Handles HTTP requests
│
├─ service
│   └─ EmailService.java            # Business logic, selects template based on category
│
├─ template
│   ├─ EmailTemplate.java           # Abstract class with final template method
│   ├─ FamilyEmailTemplate.java     # Concrete implementation for family emails
│   ├─ WorkEmailTemplate.java       # Concrete implementation for work emails
│   └─ FriendEmailTemplate.java     # Concrete implementation for friend emails
```

**Key Points:**
- `EmailTemplate` (**abstract class**) defines the **final template method** `buildEmail(String body)`.
  - ✅ This ensures the algorithm skeleton is **fixed** and cannot be overridden by subclasses.
- Concrete classes (`FamilyEmailTemplate`, `WorkEmailTemplate`, `FriendEmailTemplate`) implement only the **variable parts**: `getHeader()` and `getFooter()`.
- `EmailService` uses **Spring DI** to inject all template components as a `Map<String, EmailTemplate>` and selects the appropriate template at runtime.
- `EmailController` handles requests and delegates email building to the service.

---

## 🚀 API Usage

**Endpoint:** `POST /email/build`

**Request Body:**
```json
{
  "category": "work",
  "body": "Test email body"
}
```

**Example cURL:**
```bash
curl --location 'http://localhost:8080/email/build' \
--header 'Content-Type: application/json' \
--data '{
  "category": "work",
  "body": "Test email body"
}'
```

**Response:**
```json
{
  "content": "Dear Colleague,\n\nTest email body\n\nBest regards, Your Company"
}
```

---

## 🛠 How Template Method Pattern is Used

**1. Algorithm Skeleton in Abstract Class**

`EmailTemplate` defines the **final template method** `buildEmail(String body)`, which orchestrates email creation: concatenating header, body, and footer.

**2. Concrete Variations**

Each category (`FamilyEmailTemplate`, `WorkEmailTemplate`, `FriendEmailTemplate`) implements the variable steps (`getHeader()` and `getFooter()`) **without changing the core algorithm**.

**3. Spring Integration**

Spring automatically injects all concrete templates into `EmailService` as a `Map<String, EmailTemplate>`. The service selects the correct template at runtime based on the category.

**4. Separation of Concerns**
- Controller → HTTP request/response
- Service → Business logic (select template, build email)
- Templates → Category-specific formatting

This demonstrates the key principle of the Template Method Pattern: **fixing the algorithm structure while letting subclasses override specific steps**.

---

## 🌟 Benefits
- Clear separation between **algorithm structure** and **customizable parts**.
- Easy to **extend**: adding a new email category only requires a new concrete template class.
- **Spring DI** simplifies component management and promotes cleaner architecture.
- Ensures **algorithm consistency** by marking the template method as `final`.

---

## 📌 Example Categories

| Category | Header          | Footer                     |
|:---------|:----------------|:---------------------------|
| family   | Dear Family,    | Love, Your Family App      |
| work     | Dear Colleague, | Best regards, Your Company |
| friend   | Hey Friend!     | Cheers, Your Buddy App     |

---

## 🛠️ How to Run
#### 1. Clone this repository:
```bash
git clone https://github.com/ercansormaz/template-method-pattern.git
```

#### 2. Navigate to the project folder and build:
```bash
mvn clean install
```

#### 3. Run the application:
```bash
mvn spring-boot:run
```

#### 4. Access the APIs at:
```bash
http://localhost:8080/email/build
```

---

## 📚 Further Reading
You can read a detailed explanation of this project and the Template Method Pattern in the blog post here:  
👉 [Read the Blog Post](https://ercan.dev/blog/notes/spring-boot-template-method-pattern-example)

---

## 🤝 Contributing
Contributions are welcome! Feel free to fork the repo, submit pull requests or open issues.

---

## 📜 License
This project is licensed under the MIT License.
