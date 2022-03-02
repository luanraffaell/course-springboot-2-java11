package com.estudoWeb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudoWeb.course.entities.User;

public interface userRepository extends JpaRepository<User,Long> {

}
