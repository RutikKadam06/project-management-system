# Meeting & Calendar Module Documentation

## ✅ Features Implemented

### 1. Interactive Calendar
- **Monthly, Weekly, Daily Views** using FullCalendar.js
- **Drag & Drop** meeting rescheduling
- **Click to Create** meetings on calendar
- **Color-coded** events

### 2. Meeting Management
- ✅ Create meetings
- ✅ Edit meetings
- ✅ Delete meetings
- ✅ View meeting details

### 3. Meeting Fields
- Title (required)
- Description
- Start Date & Time (required)
- Duration in minutes (required)
- End Time (auto-calculated)
- Meeting Link (Zoom/Google Meet)
- Physical Location
- Project Association (optional)
- Participants (required, multi-select)
- Organizer (auto-set to current user)

### 4. Notifications
- ✅ In-app notifications when meeting is scheduled
- ✅ Notifications sent to all participants
- ✅ Notification message includes meeting title and time

### 5. Role-Based Access
- **SUPER_ADMIN & ADMIN**: View all meetings
- **MANAGER**: View meetings they organize or participate in
- All roles can create meetings

---

## 📊 Database Schema (MongoDB)

### Meeting Collection
```javascript
{
  _id: ObjectId,
  title: String (required),
  description: String,
  startTime: DateTime (required),
  endTime: DateTime (required),
  duration: Integer (minutes),
  meetingLink: String (URL),
  location: String,
  organizer: DBRef -> User,
  project: DBRef -> Project,
  participants: [DBRef -> User]
}
```

### Notification Collection
```javascript
{
  _id: ObjectId,
  message: String,
  timestamp: DateTime,
  isRead: Boolean,
  user: DBRef -> User
}
```

---

## 🔌 REST API Endpoints

### Get All Meetings
```
GET /meetings/api/all
Response: List<Meeting>
Access: Authenticated users
```

### Create Meeting
```
POST /meetings/api/create
Body: Meeting JSON
Response: Meeting
Access: Authenticated users
```

### Update Meeting
```
PUT /meetings/api/update/{id}
Body: Meeting JSON
Response: Meeting
Access: Authenticated users
```

### Delete Meeting
```
DELETE /meetings/api/delete/{id}
Response: 200 OK
Access: Authenticated users
```

### Get Meeting by ID
```
GET /meetings/api/{id}
Response: Meeting
Access: Authenticated users
```

---

## 🎨 Frontend Components

### 1. Calendar Page (`/meetings`)
- Full-page calendar view
- Month/Week/Day view switcher
- Click date to create meeting
- Click event to edit meeting

### 2. Meeting Modal
- Form for creating/editing meetings
- Multi-select for participants
- Date-time picker
- URL input for meeting links
- Delete button (edit mode only)

### 3. Calendar Library
**FullCalendar.js v6.1.10**
- CDN: `https://cdn.jsdelivr.net/npm/fullcalendar@6.1.10/`
- Features: Drag & drop, multiple views, event management

---

## 🎨 UI Theme (Corporate Professional)

### Colors Used
- **Primary Navy**: `#1e3a5f` (Calendar events, buttons)
- **Hover Navy**: `#2d5a8c`
- **Background**: `#f8f9fa` (Light gray)
- **White**: `#ffffff` (Cards, modals)
- **Text**: `#2c3e50` (Dark gray)
- **Accent Blue**: `#3498db` (Links, focus states)

### Design Features
- Clean white modal with rounded corners
- Professional form styling
- Smooth transitions and hover effects
- Responsive layout
- High contrast for readability

---

## 📝 Usage Guide

### Creating a Meeting

1. **Navigate to Meetings**
   - Click "Meetings" in sidebar
   - Or go to `/meetings`

2. **Schedule Meeting**
   - Click "+ Schedule Meeting" button
   - OR click on a date in calendar

3. **Fill Meeting Details**
   - Enter title (required)
   - Add description
   - Select start date & time
   - Set duration (default 60 minutes)
   - Add meeting link (Zoom/Meet)
   - Add location if physical
   - Select project (optional)
   - Select participants (hold Ctrl/Cmd for multiple)

4. **Save**
   - Click "Save Meeting"
   - Participants receive notifications
   - Meeting appears on calendar

### Editing a Meeting

1. Click on meeting event in calendar
2. Modal opens with meeting details
3. Modify fields as needed
4. Click "Save Meeting"

### Deleting a Meeting

1. Click on meeting event in calendar
2. Click "Delete" button
3. Confirm deletion

---

## 🔔 Notification System

### When Notifications are Sent
- Meeting created → All participants notified
- Meeting updated → All participants notified

### Notification Format
```
"New meeting scheduled: [Meeting Title] on [Start Time]"
```

### Viewing Notifications
- Dashboard shows unread notifications
- Notification panel at top of dashboard

---

## 🚀 How to Run

### 1. Ensure MongoDB is Running
```bash
netstat -ano | findstr :27017
```

### 2. Start Application
```bash
cd c:\project-management-system
"C:\Program Files\Maven\apache-maven-3.9.12\bin\mvn.cmd" spring-boot:run
```

### 3. Access Meetings
```
http://localhost:8080/meetings
```

---

## 📦 Dependencies Added

### Backend (Already in pom.xml)
- Spring Boot Web
- Spring Data MongoDB
- Thymeleaf

### Frontend (CDN)
- FullCalendar.js v6.1.10 (CSS + JS)

---

## 🔧 Technical Implementation

### Backend Architecture
```
Controller (MeetingController)
    ↓
Service (MeetingService)
    ↓
Repository (MeetingRepository)
    ↓
MongoDB (meetings collection)
```

### Frontend Architecture
```
HTML (meetings.html)
    ↓
FullCalendar.js (Calendar rendering)
    ↓
Fetch API (REST calls)
    ↓
Backend APIs
```

---

## ✨ Key Features

### Calendar Features
- ✅ Multiple view modes (Month/Week/Day)
- ✅ Event click to edit
- ✅ Date click to create
- ✅ Drag & drop (editable)
- ✅ Today button
- ✅ Navigation (prev/next)
- ✅ Event color coding

### Meeting Features
- ✅ Full CRUD operations
- ✅ Multi-participant selection
- ✅ Project association
- ✅ Meeting link support
- ✅ Duration calculation
- ✅ Auto-notification

### Security Features
- ✅ Session-based authentication
- ✅ Role-based access control
- ✅ Organizer tracking
- ✅ Participant validation

---

## 🎯 Future Enhancements (Optional)

1. **Email Notifications**
   - Send email to participants
   - Meeting reminders

2. **Recurring Meetings**
   - Daily/Weekly/Monthly recurrence
   - Edit series or single occurrence

3. **Meeting Attachments**
   - Upload documents
   - Share files with participants

4. **Video Integration**
   - Generate Zoom/Meet links automatically
   - Join meeting button

5. **Calendar Export**
   - Export to iCal format
   - Sync with Google Calendar

6. **Meeting Minutes**
   - Record meeting notes
   - Action items tracking

---

## 📋 Testing Checklist

- [x] Create meeting
- [x] Edit meeting
- [x] Delete meeting
- [x] View calendar
- [x] Switch calendar views
- [x] Select multiple participants
- [x] Add meeting link
- [x] Associate with project
- [x] Receive notifications
- [x] Role-based access

---

## 🎉 Module Complete!

The Meeting & Calendar module is fully functional and integrated with your Project Management System. Users can now schedule meetings, view them on an interactive calendar, and receive notifications.

**Access URL:** http://localhost:8080/meetings
