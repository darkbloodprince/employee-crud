# Employee CRUD Application (Spring Boot + Hibernate + Oracle)

## 📌 Overview
This is a Spring Boot CRUD application for managing employees.  
It provides REST APIs to **Create**, **Read**, **Update**, and **Delete** employee records,  
integrated with Hibernate ORM and Oracle Database.  
Includes **JUnit + MockMvc** tests and Postman API collection for testing.

---

## 🚀 Features
- REST API endpoints for employee management
- Spring Boot, Hibernate, Oracle DB integration
- Layered architecture: Controller → Service → Repository
- JUnit and MockMvc testing
- Maven build support

---

## 📂 Project Structure
src/
├── main/java/com/example/employeecrud
│ ├── controller/EmployeeController.java
│ ├── model/Employee.java
│ ├── repository/EmployeeRepository.java
│ ├── service/EmployeeService.java
│ └── EmployeeCrudApplication.java
└── test/java/com/example/employeecrud
└── controller/EmployeeControllerTest.java


---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot**
- **Hibernate / JPA**
- **Oracle Database**
- **JUnit 5**
- **MockMvc**
- **Maven**

---

## 📌 API Endpoints
| Method | Endpoint               | Description         |
|--------|------------------------|---------------------|
| GET    | `/api/employees`        | Get all employees   |
| GET    | `/api/employees/{id}`   | Get employee by ID  |
| POST   | `/api/employees`        | Create employee     |
| PUT    | `/api/employees/{id}`   | Update employee     |
| DELETE | `/api/employees/{id}`   | Delete employee     |

---

## ⚡ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/employee-crud.git
   cd employee-crud
Configure Oracle DB credentials in application.properties.

Build and run:

mvn spring-boot:run
🧪 Testing
Run tests using:

mvn test
You can also import the provided Postman collection for API testing.

📜 License
This project is open-source under the MIT License.
