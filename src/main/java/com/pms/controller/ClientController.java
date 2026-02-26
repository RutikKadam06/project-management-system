package com.pms.controller;

import com.pms.model.Client;
import com.pms.model.Project;
import com.pms.repository.ClientRepository;
import com.pms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }
    
    @GetMapping("/create")
    public String createForm() {
        return "client-form";
    }
    
    @PostMapping("/create")
    public String createClient(@ModelAttribute Client client) {
        clientRepository.save(client);
        return "redirect:/clients";
    }
    
    @PostMapping("/delete/{id}")
    public String deleteClient(@PathVariable String id, Model model) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            List<Project> projects = projectRepository.findByClient(client);
            if (!projects.isEmpty()) {
                for (Project project : projects) {
                    project.setClient(null);
                    projectRepository.save(project);
                }
            }
            clientRepository.deleteById(id);
        }
        return "redirect:/clients";
    }
}
