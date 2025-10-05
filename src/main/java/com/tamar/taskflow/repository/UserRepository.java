package com.tamar.taskflow.repository;

import com.tamar.taskflow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
