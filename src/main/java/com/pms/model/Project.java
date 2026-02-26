package com.pms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "projects")
public class Project {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate deadline;
    private Priority priority;
    private Status status = Status.PENDING;
    private Integer progress = 0;
    
    @DBRef
    private Client client;
    @DBRef
    private User admin;
    @DBRef
    private User manager;
    @DBRef
    private List<Task> tasks;
    
    public enum Priority { LOW, MEDIUM, HIGH }
    public enum Status { PENDING, APPROVED, IN_PROGRESS, COMPLETED }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public Integer getProgress() { return progress; }
    public void setProgress(Integer progress) { this.progress = progress; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public User getAdmin() { return admin; }
    public void setAdmin(User admin) { this.admin = admin; }
    public User getManager() { return manager; }
    public void setManager(User manager) { this.manager = manager; }
    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}
