package com.cgi.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
