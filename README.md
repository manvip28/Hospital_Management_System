# 🏥 Hospital Management System

A full-stack Hospital Management System built using **Java Spring Boot**, **MySQL**, and **HTML/JavaScript (Bootstrap)** frontend. It supports managing Patients, Doctors, Appointments, and Staff data with CRUD operations and a clean, user-friendly interface.

---

## 💡 Features

- 🧑‍⚕️ Add, update, view, and delete **patients**, **doctors**, and **staff**
- 📅 Schedule and manage **appointments**
- 📋 Dashboard overview with links to each module
- ✅ Form validation and user-friendly alerts
- 🌐 Simple, responsive UI using **Bootstrap**

---

## 🛠️ Technologies Used

- **Backend:** Java, Spring Boot, Spring Data JPA
- **Database:** MySQL
- **Frontend:** HTML, CSS, Bootstrap, Vanilla JavaScript
- **Build Tool:** Maven

---

## ⚙️ Project Structure

```
HospitalManagementSystem/
├── src/main/java/com/hospital/
│   ├── controller/
│   ├── dto/
│   ├── model/
│   ├── repository/
│   ├── service/
│   └── mapper/
├── src/main/resources/
│   ├── static/
│   │   └── [HTML/CSS/JS files]
│   └── application.properties
└── pom.xml
```

---

## 🗃️ Database Setup

1. Create a MySQL database named `hospital_db` (or your preferred name).
2. Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

---

## 🚀 Running the Application

1. **Clone the repository:**

```bash
git clone https://github.com/manvip28/Hospital_Management_System.git
cd Hospital_Management_System
```

2. **Build the project:**

```bash
mvn clean install
```

3. **Run the Spring Boot application:**

```bash
mvn spring-boot:run
```

4. **Access the frontend:**
   Open your browser and go to `http://localhost:8080/dashboard` to access the application.

---

## 🔗 API Endpoints

| Resource | Endpoint | Method | Description |
|----------|----------|---------|-------------|
| Patients | `/patients` | GET/POST/PUT/DELETE | Manage patient data |
| Doctors | `/doctors` | GET/POST/PUT/DELETE | Manage doctor data |
| Appointments | `/appointments` | GET/POST/PUT/DELETE | Manage appointments |
| Staff | `/staff` | GET/POST/PUT/DELETE | Manage staff records |

---

## 🧪 Sample Screenshots

*(Add screenshots of your UI here)*

---

## 🙋‍♀️ Author

**Manvi Pentapati**
* GitHub: [@manvip28](https://github.com/manvip28)
* LinkedIn: [Your LinkedIn Profile]

---

## 📄 License

This project is licensed under the MIT License.
