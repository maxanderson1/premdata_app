package com.max.premdata.repository;

import com.max.premdata.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachDAO extends JpaRepository<Coach, Long> {
}
