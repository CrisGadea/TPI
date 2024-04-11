package com.unlam.edu.robotines.repositories;

import com.unlam.edu.robotines.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
