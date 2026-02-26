package com.pms.service;

import com.pms.model.Task;
import com.pms.model.Project;
import com.pms.model.User;
import com.pms.model.Notification;
import com.pms.repository.TaskRepository;
import com.pms.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    
    public Task createTask(Task task) {
        Task saved = taskRepository.save(task);
        if (task.getAssignedTo() != null) {
            notifyUser(task.getAssignedTo(), "New task assigned: " + task.getTitle());
        }
        return saved;
    }
    
    public List<Task> getTasksByProject(Project project) {
        return taskRepository.findByProject(project);
    }
    
    public Task updateTaskStatus(String id, Task.Status status) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setStatus(status);
            return taskRepository.save(task);
        }
        return null;
    }
    
    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByAssignedTo(user);
    }
    
    private void notifyUser(User user, String message) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notificationRepository.save(notification);
    }
}
