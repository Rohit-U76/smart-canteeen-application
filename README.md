# 🍽️ Smart Canteen Application

## 📌 Project Description
The **Smart Canteen Application** is a web-based backend application developed using **Java, Spring Boot, and Hibernate JPA** to automate canteen operations such as menu management, food ordering, and order tracking.  
This application provides RESTful APIs to support efficient canteen workflows and scalable system design.

---

## 🎯 Objectives
- Automate food ordering and canteen management
- Reduce manual effort and order processing time
- Provide a scalable backend using Spring Boot
- Implement clean layered architecture using Hibernate JPA
- Expose REST APIs for frontend integration

---

## 🛠️ Technologies Used
- **Java**
- **Spring Boot**
- **Hibernate JPA**
- **Spring Data JPA**
- **RESTful APIs**
- **MySQL / PostgreSQL**
- **Maven**
- **Git & GitHub**

---

## ⚙️ Features
- 👤 User registration and authentication
- 📋 View food menu
- 🛒 Place food orders
- 📦 Order tracking
- 🧑‍🍳 Admin food management (CRUD)
- 📊 View order history
- 🔐 Role-based access control

---

## 🧩 Application Modules
### 1. User Module
- Register and login users
- View menu
- Place and track orders

### 2. Admin Module
- Manage food items
- View all orders
- Update order status

### 3. Order Module
- Order creation and processing
- Order history management

---

## 🗄️ Database Design
### Entities
- `User`
- `FoodItem`
- `Order`
- `OrderItem`

### Sample Entity
```java
@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private boolean available;
}
