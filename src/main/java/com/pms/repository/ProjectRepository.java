package com.pms.repository;

import com.pms.model.Project;
import com.pms.model.User;
import com.pms.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {
    List<Project> findByManager(User manager);
    List<Project> findByAdmin(User admin);
    List<Project> findByStatus(Project.Status status);
    List<Project> findByClient(Client client);
}
