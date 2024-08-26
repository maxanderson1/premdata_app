package com.max.premdata.repository;

import com.max.premdata.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface MatchDAO extends JpaRepository<Match, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM matches WHERE matchday = :matchday")
    public List<Match> getAllByMatchday(@Param(value = "matchday") int matchday);
}
