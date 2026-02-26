package com.pms.controller;

import com.pms.model.User;
import com.pms.model.Project;
import com.pms.service.ProjectService;
import com.pms.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class DashboardController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private NotificationRepository notificationRepository;
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        
        model.addAttribute("user", user);
        model.addAttribute("notifications", notificationRepository.findByUserAndIsReadFalse(user));
        
        List<Project> projects;
        if (user.getRole() == User.Role.SUPER_ADMIN || user.getRole() == User.Role.ADMIN) {
            projects = projectService.getAllProjects();
        } else if (user.getRole() == User.Role.MANAGER) {
            projects = projectService.getProjectsByManager(user);
        } else {
            projects = List.of();
        }
        
        model.addAttribute("projects", projects);
        
        // Project status statistics for graph
        Map<Project.Status, Long> statusCount = projects.stream()
            .collect(Collectors.groupingBy(Project::getStatus, Collectors.counting()));
        
        model.addAttribute("pendingCount", statusCount.getOrDefault(Project.Status.PENDING, 0L));
        model.addAttribute("approvedCount", statusCount.getOrDefault(Project.Status.APPROVED, 0L));
        model.addAttribute("inProgressCount", statusCount.getOrDefault(Project.Status.IN_PROGRESS, 0L));
        model.addAttribute("completedCount", statusCount.getOrDefault(Project.Status.COMPLETED, 0L));
        
        return "dashboard";
    }
}
