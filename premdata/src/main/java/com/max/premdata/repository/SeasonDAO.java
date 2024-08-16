package com.max.premdata.repository;

import com.max.premdata.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonDAO extends JpaRepository<Season, Long> {

    Season findByYear(@Param("year") String year);
}
