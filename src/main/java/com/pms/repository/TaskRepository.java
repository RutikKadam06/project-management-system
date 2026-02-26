package com.pms.repository;

import com.pms.model.Task;
import com.pms.model.Project;
import com.pms.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByProject(Project project);
    List<Task> findByAssignedTo(User user);
}
