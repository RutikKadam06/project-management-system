# MongoDB Setup Guide

## Installation Steps

### 1. Download MongoDB
- Visit: https://www.mongodb.com/try/download/community
- Select: Windows
- Version: Latest (7.0 or higher)
- Package: MSI
- Click "Download"

### 2. Install MongoDB
1. Run the downloaded `.msi` file
2. Choose "Complete" installation
3. Install MongoDB as a Service (check the box)
4. Install MongoDB Compass (optional GUI tool)
5. Complete installation

### 3. Verify Installation
Open Command Prompt and run:
```bash
mongod --version
```

### 4. Start MongoDB
MongoDB runs automatically as a Windows service. To verify:
```bash
net start MongoDB
```

### 5. Run the Project
```bash
cd c:\project-management-system
mvnw.cmd spring-boot:run
```

### 6. Access Application
Open browser: http://localhost:8080

## MongoDB Connection Details
- Host: localhost
- Port: 27017
- Database: pms_db (auto-created)
- No username/password required (default)

## Troubleshooting

### MongoDB not starting?
```bash
net start MongoDB
```

### Check if MongoDB is running:
```bash
netstat -ano | findstr :27017
```

### Using MongoDB Compass (GUI)
1. Open MongoDB Compass
2. Connection string: `mongodb://localhost:27017`
3. Click "Connect"
4. View `pms_db` database

## Alternative: MongoDB Atlas (Cloud)
If you prefer cloud database:
1. Visit: https://www.mongodb.com/cloud/atlas
2. Create free account
3. Create cluster
4. Get connection string
5. Update `application.properties`:
```properties
spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/pms_db
```
