# Project Management System

A comprehensive web-based Project Management System built with Spring Boot, MySQL, and Thymeleaf.

## Features

### Role-Based Access Control
- **Super Admin**: Complete system access, manage clients, view all projects, generate reports
- **Admin**: Create projects, assign managers, approve projects, monitor progress
- **Manager**: Handle assigned projects, create tasks, assign team members, update progress

### Core Functionality
- Secure login with encrypted passwords
- Project creation with detailed information (name, description, deadlines, priority)
- Task and subtask management with role assignments (Team Leader, Developer, Tester)
- Meeting calendar and scheduling
- Project approval workflow
- Real-time progress tracking
- Graphical progress visualization (charts using Chart.js)
- Client management
- Role-specific dashboards
- Activity logs
- Notification system
- Downloadable reports

## Technology Stack

- **Backend**: Spring Boot 3.1.5
- **Frontend**: HTML, CSS, JavaScript, Thymeleaf
- **Database**: MySQL
- **Security**: Spring Security with BCrypt password encryption
- **Charts**: Chart.js
- **Build Tool**: Maven

## Prerequisites

1. Java 17 or higher
2. MySQL Server 8.0 or higher
3. Maven 3.6 or higher

## Setup Instructions

### 1. Database Setup

Start MySQL and create a database (it will be created automatically):
```sql
CREATE DATABASE pms_db;
```

### 2. Configure Database

Edit `src/main/resources/application.properties` and update:
```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Build and Run

#### Using Maven:
```bash
cd project-management-system
mvn clean install
mvn spring-boot:run
```

#### Using Java:
```bash
cd project-management-system
mvn clean package
java -jar target/project-management-system-1.0.0.jar
```

### 4. Access Application

Open browser and navigate to: `http://localhost:8080`

## Default Users

Register users with different roles:
- Super Admin
- Admin
- Manager

## Project Structure

```
project-management-system/
├── src/
│   ├── main/
│   │   ├── java/com/pms/
│   │   │   ├── controller/      # REST Controllers
│   │   │   ├── model/           # Entity Models
│   │   │   ├── repository/      # JPA Repositories
│   │   │   ├── service/         # Business Logic
│   │   │   └── config/          # Security Configuration
│   │   └── resources/
│   │       ├── templates/       # Thymeleaf HTML Templates
│   │       ├── static/
│   │       │   ├── css/         # Stylesheets
│   │       │   └── js/          # JavaScript files
│   │       └── application.properties
└── pom.xml
```

## Key Features Explained

### 1. Authentication & Authorization
- Secure login with session management
- Password encryption using BCrypt
- Role-based access control

### 2. Project Management
- Create projects with client assignment
- Assign managers to projects
- Set priorities and deadlines
- Track progress with percentage completion

### 3. Task Management
- Create tasks within projects
- Assign tasks to team members
- Define task roles (Team Leader, Developer, Tester)
- Update task status (TODO, IN_PROGRESS, COMPLETED)

### 4. Approval Workflow
- Projects require Admin approval before execution
- Status tracking (PENDING, APPROVED, IN_PROGRESS, COMPLETED)

### 5. Dashboard
- Role-specific views
- Project statistics
- Notifications
- Quick access to assigned projects

### 6. Reports & Analytics
- Visual charts (Pie, Bar, Doughnut)
- Project status distribution
- Progress tracking
- Exportable data

### 7. Client Management
- Add and manage client details
- Associate clients with projects
- View client information

### 8. Activity Logs
- Track all user actions
- Monitor project changes
- Audit trail for accountability

### 9. Notifications
- Project approval notifications
- Task assignment alerts
- Meeting reminders

## API Endpoints

- `GET /` - Home (redirects to login)
- `GET /login` - Login page
- `POST /login` - Authenticate user
- `GET /register` - Registration page
- `POST /register` - Register new user
- `GET /dashboard` - User dashboard
- `GET /projects` - List all projects
- `GET /projects/create` - Create project form
- `POST /projects/create` - Save new project
- `POST /projects/approve/{id}` - Approve project
- `GET /projects/{id}` - View project details
- `POST /projects/progress/{id}` - Update progress
- `GET /tasks/create` - Create task form
- `POST /tasks/create` - Save new task
- `GET /clients` - List all clients
- `POST /clients/create` - Add new client
- `GET /reports` - View reports and analytics
- `GET /logout` - Logout user

## Security Features

- Password encryption with BCrypt
- Session-based authentication
- CSRF protection
- Role-based authorization
- Secure password storage

## Database Schema

### Tables:
- `users` - User accounts with roles
- `client` - Client information
- `project` - Project details
- `task` - Task information
- `meeting` - Meeting schedules
- `activity_log` - Activity tracking
- `notification` - User notifications

## Troubleshooting

### Port Already in Use
Change port in `application.properties`:
```properties
server.port=8081
```

### Database Connection Error
- Verify MySQL is running
- Check username/password in application.properties
- Ensure database exists

### Maven Build Fails
- Check Java version: `java -version`
- Update Maven: `mvn -version`
- Clear Maven cache: `mvn clean`

## Future Enhancements

- File upload for project documents
- Email notifications
- Calendar integration
- Gantt chart view
- Time tracking
- Resource allocation
- Mobile responsive design
- REST API for mobile apps
- Export reports to PDF/Excel

## License

This project is for educational purposes.

## Contact

For issues or questions, please create an issue in the repository.
