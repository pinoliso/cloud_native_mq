package com.duoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.duoc.models.Message;

public interface  MessageRepository extends JpaRepository<Message, Long> {
    
}
