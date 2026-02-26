package com.pms.controller;

import com.pms.model.Meeting;
import com.pms.model.User;
import com.pms.service.MeetingService;
import com.pms.repository.UserRepository;
import com.pms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/meetings")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;
    
    @GetMapping
    public String meetingsPage(HttpSession session) {
        return "redirect:/dashboard";
    }
    
    @GetMapping("/calendar")
    public String calendarPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        
        model.addAttribute("user", user);
        return "calendar";
    }
    
    @GetMapping("/api/all")
    @ResponseBody
    public ResponseEntity<List<Meeting>> getAllMeetings(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return ResponseEntity.status(401).build();
        
        List<Meeting> meetings;
        if (user.getRole() == User.Role.SUPER_ADMIN || user.getRole() == User.Role.ADMIN) {
            meetings = meetingService.getAllMeetings();
        } else {
            meetings = meetingService.getMeetingsByUser(user);
        }
        return ResponseEntity.ok(meetings);
    }
    
    @PostMapping("/api/create")
    @ResponseBody
    public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return ResponseEntity.status(401).build();
        
        meeting.setOrganizer(user);
        Meeting created = meetingService.createMeeting(meeting);
        return ResponseEntity.ok(created);
    }
    
    @PutMapping("/api/update/{id}")
    @ResponseBody
    public ResponseEntity<Meeting> updateMeeting(@PathVariable String id, @RequestBody Meeting meeting, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return ResponseEntity.status(401).build();
        
        Meeting updated = meetingService.updateMeeting(id, meeting);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/api/delete/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteMeeting(@PathVariable String id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return ResponseEntity.status(401).build();
        
        meetingService.deleteMeeting(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Meeting> getMeeting(@PathVariable String id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return ResponseEntity.status(401).build();
        
        Meeting meeting = meetingService.getMeetingById(id);
        return ResponseEntity.ok(meeting);
    }
}
