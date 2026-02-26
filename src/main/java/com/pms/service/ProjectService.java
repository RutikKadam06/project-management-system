package com.pms.service;

import com.pms.model.Project;
import com.pms.model.User;
import com.pms.model.ActivityLog;
import com.pms.model.Notification;
import com.pms.repository.ProjectRepository;
import com.pms.repository.ActivityLogRepository;
import com.pms.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ActivityLogRepository activityLogRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    
    public Project createProject(Project project, User user) {
        Project saved = projectRepository.save(project);
        logActivity("Created project: " + project.getName(), user, saved);
        return saved;
    }
    
    public Project approveProject(String id, User user) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            project.setStatus(Project.Status.APPROVED);
            Project saved = projectRepository.save(project);
            logActivity("Approved project: " + project.getName(), user, saved);
            notifyUser(project.getManager(), "Your project '" + project.getName() + "' has been approved");
            return saved;
        }
        return null;
    }
    
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    
    public List<Project> getProjectsByManager(User manager) {
        return projectRepository.findByManager(manager);
    }
    
    public Project updateProgress(String id, Integer progress, User user) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            project.setProgress(progress);
            if (progress == 100) {
                project.setStatus(Project.Status.COMPLETED);
            }
            Project saved = projectRepository.save(project);
            logActivity("Updated progress to " + progress + "%", user, saved);
            return saved;
        }
        return null;
    }
    
    public Project getProjectById(String id) {
        return projectRepository.findById(id).orElse(null);
    }
    
    private void logActivity(String action, User user, Project project) {
        ActivityLog log = new ActivityLog();
        log.setAction(action);
        log.setUser(user);
        log.setProject(project);
        activityLogRepository.save(log);
    }
    
    private void notifyUser(User user, String message) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notificationRepository.save(notification);
    }
}
