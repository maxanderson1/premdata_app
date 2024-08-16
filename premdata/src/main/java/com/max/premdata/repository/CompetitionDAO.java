package com.max.premdata.repository;

import com.max.premdata.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionDAO extends JpaRepository<Competition, Long> {
}
