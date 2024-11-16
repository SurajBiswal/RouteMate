package com.suraj.cabService.RouteMate.repositories;

import com.suraj.cabService.RouteMate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
