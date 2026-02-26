package com.pms.controller;

import com.pms.service.ProjectService;
import com.pms.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ProjectService projectService;
    
    @GetMapping
    public String reports(Model model) {
        List<Project> projects = projectService.getAllProjects();
        
        Map<Project.Status, Long> statusCount = projects.stream()
            .collect(Collectors.groupingBy(Project::getStatus, Collectors.counting()));
        
        model.addAttribute("projects", projects);
        model.addAttribute("statusCount", statusCount);
        return "reports";
    }
}
