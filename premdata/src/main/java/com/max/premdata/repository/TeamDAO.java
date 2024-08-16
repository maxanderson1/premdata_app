package com.max.premdata.repository;

import com.max.premdata.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDAO extends JpaRepository <Team, Long> {
}
