# 🚀 Quick Start - Meeting & Calendar Module

## ✅ What's Been Added

### New Features
1. **Interactive Calendar** with Month/Week/Day views
2. **Meeting Scheduling** with full CRUD operations
3. **Participant Management** (multi-select team members)
4. **Meeting Links** (Zoom/Google Meet integration)
5. **Automatic Notifications** to participants
6. **Project Association** (link meetings to projects)

---

## 🎯 How to Use

### Step 1: Start the Application
```bash
cd c:\project-management-system
"C:\Program Files\Maven\apache-maven-3.9.12\bin\mvn.cmd" spring-boot:run
```

### Step 2: Login
```
http://localhost:8080/login
```

### Step 3: Access Meetings
- Click **"Meetings"** in the sidebar
- Or go to: `http://localhost:8080/meetings`

### Step 4: Schedule a Meeting
1. Click **"+ Schedule Meeting"** button
2. Fill in the form:
   - **Title**: Meeting name (required)
   - **Description**: Meeting agenda
   - **Start Date & Time**: When meeting starts
   - **Duration**: How long (in minutes)
   - **Meeting Link**: Zoom/Meet URL
   - **Location**: Physical location (optional)
   - **Project**: Associate with project (optional)
   - **Participants**: Select team members (hold Ctrl for multiple)
3. Click **"Save Meeting"**

### Step 5: View on Calendar
- Meeting appears on calendar
- Click event to edit
- Click date to create new meeting
- Switch views: Month/Week/Day

---

## 📊 Calendar Views

### Month View
- See all meetings for the month
- Click date to create meeting
- Click event to edit

### Week View
- Detailed weekly schedule
- Time slots visible
- Better for planning

### Day View
- Hour-by-hour schedule
- Perfect for busy days
- See all meeting details

---

## 🔔 Notifications

When you schedule a meeting:
1. All participants receive notification
2. Notification shows in dashboard
3. Message includes meeting title and time

---

## 🎨 UI Features

### Professional Design
- Clean white background
- Navy blue accents (#1e3a5f)
- Smooth animations
- Responsive layout

### Calendar Features
- Color-coded events
- Drag & drop (coming soon)
- Today button
- Easy navigation

### Modal Form
- Large, easy-to-use form
- Multi-select participants
- Date-time picker
- URL validation for meeting links

---

## 📝 Example Meeting

```
Title: Sprint Planning Meeting
Description: Plan tasks for next sprint
Start: 2024-02-20 10:00 AM
Duration: 90 minutes
Meeting Link: https://zoom.us/j/123456789
Location: Conference Room A
Project: E-commerce Website
Participants: John Doe, Jane Smith, Bob Johnson
```

---

## 🔧 Technical Details

### Files Added/Modified

**Backend:**
- `Meeting.java` - Enhanced model
- `MeetingRepository.java` - Updated queries
- `MeetingService.java` - NEW business logic
- `MeetingController.java` - NEW REST APIs

**Frontend:**
- `meetings.html` - NEW calendar page
- `dashboard.html` - Added meetings link

**Documentation:**
- `MEETING-MODULE-DOCS.md` - Full documentation

### REST APIs Available

```
GET    /meetings              - Calendar page
GET    /meetings/api/all      - Get all meetings
POST   /meetings/api/create   - Create meeting
PUT    /meetings/api/update/{id} - Update meeting
DELETE /meetings/api/delete/{id} - Delete meeting
GET    /meetings/api/{id}     - Get meeting details
```

---

## ✨ Key Benefits

1. **Better Collaboration**
   - Schedule team meetings easily
   - Everyone gets notified
   - No more missed meetings

2. **Visual Planning**
   - See all meetings at a glance
   - Plan your week/month
   - Avoid scheduling conflicts

3. **Remote Work Ready**
   - Add Zoom/Meet links
   - Share meeting details
   - Join with one click

4. **Project Integration**
   - Link meetings to projects
   - Track project discussions
   - Better project management

---

## 🎉 You're Ready!

The Meeting & Calendar module is fully integrated and ready to use. Start scheduling meetings and improve your team collaboration!

**Access Now:** http://localhost:8080/meetings

---

## 💡 Tips

- Hold **Ctrl** (Windows) or **Cmd** (Mac) to select multiple participants
- Use **Meeting Link** field for Zoom/Google Meet URLs
- **Duration** auto-calculates end time
- Click **Today** button to jump to current date
- Switch views using buttons in top-right corner

---

## 📞 Need Help?

Check the full documentation: `MEETING-MODULE-DOCS.md`
