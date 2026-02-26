# 📊 Where Your Data is Stored

## Database Information

**Database Type:** MongoDB (NoSQL)
**Connection:** mongodb://localhost:27017/pms_db
**Database Name:** pms_db
**Port:** 27017

---

## 📁 Collections (Tables)

Your data is stored in these MongoDB collections:

1. **users** - User accounts (SUPER_ADMIN, ADMIN, MANAGER)
2. **clients** - Client information
3. **projects** - Project details
4. **tasks** - Task assignments
5. **meetings** - Meeting schedules
6. **activity_logs** - Activity tracking
7. **notifications** - User notifications

---

## 🔍 How to View Your Data

### Option 1: MongoDB Compass (GUI - Recommended)

1. **Download MongoDB Compass** (if not installed)
   - https://www.mongodb.com/try/download/compass

2. **Open MongoDB Compass**

3. **Connect to Database**
   ```
   Connection String: mongodb://localhost:27017
   ```

4. **View Data**
   - Click on `pms_db` database
   - Click on any collection (users, projects, meetings, etc.)
   - See all your data in a visual interface

---

### Option 2: MongoDB Shell (Command Line)

1. **Open Command Prompt**

2. **Connect to MongoDB**
   ```bash
   mongosh mongodb://localhost:27017/pms_db
   ```

3. **View Collections**
   ```javascript
   show collections
   ```

4. **View Data**
   ```javascript
   // View all users
   db.users.find().pretty()
   
   // View all projects
   db.projects.find().pretty()
   
   // View all meetings
   db.meetings.find().pretty()
   
   // Count documents
   db.users.countDocuments()
   db.projects.countDocuments()
   ```

---

### Option 3: MongoDB Shell Commands

```bash
# Connect to MongoDB
mongosh

# Switch to your database
use pms_db

# List all collections
show collections

# View all users
db.users.find()

# View specific user
db.users.findOne({username: "admin"})

# View all projects
db.projects.find()

# View all meetings
db.meetings.find()

# Count records
db.users.countDocuments()
db.projects.countDocuments()
db.meetings.countDocuments()

# View recent meetings
db.meetings.find().sort({startTime: -1}).limit(5)
```

---

## 📂 Data Location on Disk

MongoDB stores data files in:

**Windows Default Location:**
```
C:\Program Files\MongoDB\Server\[version]\data\
```

**Or check your MongoDB config:**
```
C:\Program Files\MongoDB\Server\[version]\bin\mongod.cfg
```

Look for `dbPath` setting.

---

## 🔧 Quick Access Commands

### Check if MongoDB is Running
```bash
netstat -ano | findstr :27017
```

### Start MongoDB Service
```bash
net start MongoDB
```

### Stop MongoDB Service
```bash
net stop MongoDB
```

---

## 📊 Sample Data Structure

### User Document
```json
{
  "_id": "65abc123...",
  "username": "john.doe",
  "password": "$2a$10$encrypted...",
  "email": "john@example.com",
  "fullName": "John Doe",
  "role": "MANAGER"
}
```

### Project Document
```json
{
  "_id": "65abc456...",
  "name": "E-commerce Website",
  "description": "Build online store",
  "startDate": "2024-02-01",
  "deadline": "2024-06-30",
  "priority": "HIGH",
  "status": "IN_PROGRESS",
  "progress": 45,
  "client": { "$ref": "clients", "$id": "65abc789..." },
  "admin": { "$ref": "users", "$id": "65abc123..." },
  "manager": { "$ref": "users", "$id": "65abc456..." }
}
```

### Meeting Document
```json
{
  "_id": "65abc789...",
  "title": "Sprint Planning",
  "description": "Plan next sprint tasks",
  "startTime": "2024-02-20T10:00:00",
  "endTime": "2024-02-20T11:30:00",
  "duration": 90,
  "meetingLink": "https://zoom.us/j/123456789",
  "location": "Conference Room A",
  "organizer": { "$ref": "users", "$id": "65abc123..." },
  "project": { "$ref": "projects", "$id": "65abc456..." },
  "participants": [
    { "$ref": "users", "$id": "65abc123..." },
    { "$ref": "users", "$id": "65abc456..." }
  ]
}
```

---

## 🛠️ Backup Your Data

### Export Database
```bash
mongodump --db pms_db --out C:\backup\mongodb
```

### Import Database
```bash
mongorestore --db pms_db C:\backup\mongodb\pms_db
```

### Export Collection to JSON
```bash
mongoexport --db pms_db --collection users --out users.json
```

### Import Collection from JSON
```bash
mongoimport --db pms_db --collection users --file users.json
```

---

## 📈 View Data in Application

Your data is also visible in the application:

1. **Users** - Register page creates users
2. **Projects** - `/projects` page
3. **Tasks** - Project details page
4. **Meetings** - `/meetings` calendar page
5. **Clients** - `/clients` page
6. **Reports** - `/reports` page
7. **Notifications** - Dashboard

---

## 🔐 Data Security

- **Passwords:** Encrypted with BCrypt
- **Sessions:** Stored in memory
- **Database:** Local MongoDB (no external access by default)

---

## 💡 Quick Tips

1. **MongoDB Compass** is the easiest way to view data
2. Data persists even after restarting the application
3. Each collection has an `_id` field (unique identifier)
4. References between collections use `DBRef`
5. Dates are stored in ISO format

---

## 📞 Need to Access Data?

**Easiest Method:**
1. Download MongoDB Compass
2. Connect to: `mongodb://localhost:27017`
3. Open `pms_db` database
4. Browse your collections visually

**Download Compass:**
https://www.mongodb.com/try/download/compass

---

**Your data is safe and stored locally in MongoDB on your computer!** 🎉
