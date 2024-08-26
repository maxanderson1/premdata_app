package com.max.premdata.repository;

import com.max.premdata.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDAO extends JpaRepository<Score, Long> {

}
