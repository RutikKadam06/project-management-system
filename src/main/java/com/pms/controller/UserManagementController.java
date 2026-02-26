package com.pms.controller;

import com.pms.model.User;
import com.pms.model.Project;
import com.pms.model.Task;
import com.pms.repository.UserRepository;
import com.pms.repository.ProjectRepository;
import com.pms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserManagementController {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private TaskRepository taskRepository;
    
    @GetMapping
    public String listUsers(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) return "redirect:/login";
        
        if (currentUser.getRole() != User.Role.SUPER_ADMIN && currentUser.getRole() != User.Role.ADMIN) {
            return "redirect:/dashboard";
        }
        
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("user", currentUser);
        return "users";
    }
    
    @PostMapping("/update-role/{id}")
    public String updateRole(@PathVariable String id, @RequestParam User.Role role, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) return "redirect:/login";
        
        if (currentUser.getRole() != User.Role.SUPER_ADMIN && currentUser.getRole() != User.Role.ADMIN) {
            return "redirect:/dashboard";
        }
        
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setRole(role);
            userRepository.save(user);
        }
        
        return "redirect:/users";
    }
    
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) return "redirect:/login";
        
        if (currentUser.getRole() != User.Role.SUPER_ADMIN && currentUser.getRole() != User.Role.ADMIN) {
            return "redirect:/dashboard";
        }
        
        if (!id.equals(currentUser.getId())) {
            User userToDelete = userRepository.findById(id).orElse(null);
            if (userToDelete != null) {
                List<Project> adminProjects = projectRepository.findByAdmin(userToDelete);
                for (Project project : adminProjects) {
                    project.setAdmin(null);
                    projectRepository.save(project);
                }
                
                List<Project> managerProjects = projectRepository.findByManager(userToDelete);
                for (Project project : managerProjects) {
                    project.setManager(null);
                    projectRepository.save(project);
                }
                
                List<Task> tasks = taskRepository.findByAssignedTo(userToDelete);
                for (Task task : tasks) {
                    task.setAssignedTo(null);
                    taskRepository.save(task);
                }
                
                userRepository.deleteById(id);
            }
        }
        
        return "redirect:/users";
    }
}
