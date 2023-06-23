package com.cgi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer>{


}
