package com.pms.repository;

import com.pms.model.Notification;
import com.pms.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByUserAndIsReadFalse(User user);
}
