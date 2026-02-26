package com.pms.controller;

import com.pms.model.Project;
import com.pms.model.User;
import com.pms.service.ProjectService;
import com.pms.service.UserService;
import com.pms.service.TaskService;
import com.pms.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TaskService taskService;
    
    @GetMapping
    public String listProjects(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("user", user);
        return "projects";
    }
    
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("managers", userService.findByRole(User.Role.MANAGER));
        model.addAttribute("clients", clientRepository.findAll());
        return "project-form";
    }
    
    @PostMapping("/create")
    public String createProject(@ModelAttribute Project project, HttpSession session) {
        User admin = (User) session.getAttribute("user");
        project.setAdmin(admin);
        projectService.createProject(project, admin);
        return "redirect:/projects";
    }
    
    @PostMapping("/approve/{id}")
    public String approveProject(@PathVariable String id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        projectService.approveProject(id, user);
        return "redirect:/projects";
    }
    
    @PostMapping("/progress/{id}")
    public String updateProgress(@PathVariable String id, @RequestParam Integer progress, HttpSession session) {
        User user = (User) session.getAttribute("user");
        projectService.updateProgress(id, progress, user);
        return "redirect:/projects";
    }
    
    @GetMapping("/{id}")
    public String viewProject(@PathVariable String id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        model.addAttribute("tasks", taskService.getTasksByProject(project));
        return "project-details";
    }
}
