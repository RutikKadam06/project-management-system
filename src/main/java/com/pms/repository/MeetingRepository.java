package com.pms.repository;

import com.pms.model.Meeting;
import com.pms.model.Project;
import com.pms.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface MeetingRepository extends MongoRepository<Meeting, String> {
    List<Meeting> findByProject(Project project);
    List<Meeting> findByOrganizer(User organizer);
    List<Meeting> findByParticipantsContaining(User participant);
    List<Meeting> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
