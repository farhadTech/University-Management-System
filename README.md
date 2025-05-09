
# 📚 University Management System - Spring Boot Backend

A comprehensive Spring Boot backend for managing a university's academic data, including departments, students, instructors, courses, classrooms, and more.

---

## 🏗️ Database Schema Overview

This system implements a normalized relational schema with the following entities:

### 📦 Tables and Relationships

| Table             | Description |
|------------------|-------------|
| `department`      | Contains info about academic departments (budget, building). |
| `course`          | Course details with a reference to its department. |
| `classroom`       | Classroom details including building and room number. |
| `instructor`      | Instructor info with FK to department and optional link to `instructorDetail`. |
| `instructorDetail`| Extended instructor bio with hobby and YouTube channel. |
| `section`         | Represents individual course offerings by semester and year. |
| `student`         | Student data with department and total credits. |
| `teaches`         | Maps instructors to the sections they teach. |
| `takes`           | Maps students to the sections they take. |
| `prereq`          | Course prerequisites. |
| `advisor`         | Links between students and their instructors as advisors. |
| `time_slot`       | Scheduling times for course sections. |

---
## Here is the image of diagram
![alt ums](./ums.png)
## 🧩 Entity Relationships

- **One-to-Many**:
  - `department` → `instructor`, `student`, `course`
  - `course` → `section`
  - `instructor` → `teaches`
  - `student` → `takes`
- **Many-to-Many**:
  - `teaches`, `takes`, and `advisor` implement many-to-many logic.
- **Special Links**:
  - `instructor` → `instructorDetail` (1:1 via optional FK)
  - `section` → `classroom`, `course`, and `time_slot`

---

## 📁 Spring Boot Controllers

| Controller File             | Description |
|----------------------------|-------------|
| `AdvisorController.java`          | Advisor mappings between students and instructors. |
| `ClassroomController.java`        | Classroom management. |
| `CourseController.java`           | Course CRUD operations. |
| `DepartmentController.java`       | Manage academic departments. |
| `FacultyReviewController.java`    | Handle instructor feedback. *(optional feature)* |
| `InstructorController.java`       | Instructors CRUD + department + instructor details. |
| `SectionController.java`          | Manage course sections per semester/year. |
| `StudentController.java`          | Handle student data. |
| `TakesController.java`            | Link students to their enrolled courses. |
| `TeachesController.java`          | Link instructors to courses they teach. |
| `TimeSlotController.java`         | Scheduling logic for course sections. |

---

## 🚀 Technologies Used

- Java 21+
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Swagger for API Documentation

---

## 🔧 Running the Project

1. **Clone the repository**:
```bash
git clone https://github.com/farhadTech/university-management-system.git
cd university-management-system
```

2. **Configure the database** in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/university
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

3. **Run the app**:
```bash
./mvnw spring-boot:run
```

4. **Access Swagger (if enabled)**:
   `http://localhost:8080/swagger-ui/index.html`

---

## 📬 Sample API Endpoints

```http
GET     /api/students
POST    /api/instructors
PUT     /api/courses/{id}
DELETE  /api/sections/{id}
```

---

## 🔮 Future Enhancements

- Spring Security + JWT
- Role-based access for Admin, Faculty, Student
- Pagination, Filtering, Sorting
- Export reports to PDF/Excel
- Angular/React frontend integration

---

## 👨‍💻 Author

**Farhad**
🎓 CSE Student at UIU
⚙️ Passionate about building backend systems with Spring Boot
