package com.pms.controller;

import com.pms.model.Task;
import com.pms.service.TaskService;
import com.pms.repository.ProjectRepository;
import com.pms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/create")
    public String createForm(@RequestParam String projectId, Model model) {
        model.addAttribute("project", projectRepository.findById(projectId).orElse(null));
        model.addAttribute("users", userRepository.findAll());
        return "task-form";
    }
    
    @PostMapping("/create")
    public String createTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/projects/" + task.getProject().getId();
    }
    
    @PostMapping("/update/{id}")
    public String updateStatus(@PathVariable String id, @RequestParam Task.Status status) {
        Task task = taskService.updateTaskStatus(id, status);
        return "redirect:/projects/" + task.getProject().getId();
    }
}
