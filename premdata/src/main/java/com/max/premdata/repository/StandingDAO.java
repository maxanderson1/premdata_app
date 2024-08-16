package com.max.premdata.repository;

import com.max.premdata.entity.Standing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandingDAO extends JpaRepository<Standing, Long> {
}
