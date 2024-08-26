package com.max.premdata.repository;

import com.max.premdata.entity.Score;
import com.max.premdata.entity.ScoreDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDetailsDAO extends JpaRepository<ScoreDetails, Long> {

}
