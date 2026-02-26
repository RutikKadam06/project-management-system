package com.pms.service;

import com.pms.model.Meeting;
import com.pms.model.User;
import com.pms.model.Notification;
import com.pms.repository.MeetingRepository;
import com.pms.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    
    public Meeting createMeeting(Meeting meeting) {
        Meeting saved = meetingRepository.save(meeting);
        notifyParticipants(saved);
        return saved;
    }
    
    public Meeting updateMeeting(String id, Meeting meeting) {
        meeting.setId(id);
        Meeting updated = meetingRepository.save(meeting);
        notifyParticipants(updated);
        return updated;
    }
    
    public void deleteMeeting(String id) {
        meetingRepository.deleteById(id);
    }
    
    public Meeting getMeetingById(String id) {
        return meetingRepository.findById(id).orElse(null);
    }
    
    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }
    
    public List<Meeting> getMeetingsByUser(User user) {
        return meetingRepository.findByParticipantsContaining(user);
    }
    
    public List<Meeting> getMeetingsByDateRange(LocalDateTime start, LocalDateTime end) {
        return meetingRepository.findByStartTimeBetween(start, end);
    }
    
    private void notifyParticipants(Meeting meeting) {
        if (meeting.getParticipants() != null) {
            for (User participant : meeting.getParticipants()) {
                Notification notification = new Notification();
                notification.setUser(participant);
                notification.setMessage("New meeting scheduled: " + meeting.getTitle() + 
                                      " on " + meeting.getStartTime());
                notificationRepository.save(notification);
            }
        }
    }
}
