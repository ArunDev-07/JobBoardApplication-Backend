# Job Board Application - Backend

Backend service for a full-stack **Job Board Application** built with **Spring Boot** and **MySQL**.

This API handles:

- job management
- admin login
- keyword search
- filtering
- pagination
- job applications
- applicant retrieval

---

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.5**
- **Spring Web MVC**
- **Spring Data JPA**
- **Spring Validation**
- **MySQL**
- **Lombok**
- **Maven**

---

## Features

### Job Management
- Add a single job
- Add multiple jobs
- Update existing jobs
- Delete jobs
- Get all jobs
- Get a single job by ID

### Search and Filtering
- Search jobs by keyword
- Filter jobs by location and category
- Paginate jobs using Spring `Pageable`

### Admin
- Admin login with email and password

### Applications
- Apply to a job
- Store applicant details
- View all job applications
- View one application by ID

---

## Project Structure

```bash
JobBoardApplication/
├── src/
│   ├── main/
│   │   ├── java/com/example/JobBoardApplication/
│   │   │   ├── Controller/
│   │   │   ├── Model/
│   │   │   ├── Repository/
│   │   │   └── Service/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
