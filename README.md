# 🛡️ Student Management System – JWT Authentication

This project is a **Spring Boot Backend + Frontend** application that demonstrates how to implement **JWT-based authentication** for a Student Management System.  
It supports **user registration, login, and role-based access** (e.g., ADMIN / USER).  

---

## 🚀 Features

- ✅ User Registration & Login with **JWT Authentication**
- ✅ Role-based access control (Admin/User)
- ✅ Secured APIs with Spring Security
- ✅ MySQL Database Integration
- ✅ CORS Enabled (Frontend ↔ Backend communication)
- ✅ REST APIs for Student Management
- ✅ Simple Frontend (HTML, CSS, JS)

---

## 🏗️ Tech Stack

### Backend
- **Spring Boot 3**
- **Spring Security**
- **JWT (JSON Web Token)**
- **MySQL**
- **Maven**

### Frontend
- **HTML / CSS / JavaScript**
- (Can be upgraded later to React/Angular)

---

## ⚙️ Project Structure

JWT-Auth/
│
├── backend/ # Spring Boot backend
│ ├── src/main/java/... # Java source code
│ ├── src/main/resources/ # application.properties
│ └── pom.xml # Maven build file
│
├── frontend/ # Frontend code
│ ├── index.html
│ ├── css/
│ ├── js/
│ └── package.json # (if using npm for frontend)
│
└── README.md # Project Documentation


---

## 🔑 JWT Authentication Flow

1. **User registers** → credentials stored in DB.
2. **User logs in** → Backend generates a JWT token.
3. **Token is sent in Authorization Header** with API requests:
4. 4. **Backend verifies JWT** → Grants access if valid.
5. **Role-based access** → ADMIN/USER routes protected.

