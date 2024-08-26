package com.max.premdata.repository;

import com.max.premdata.entity.Scorer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScorerDAO extends JpaRepository<Scorer, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM scorers WHERE player_id = :playerId")
    public Optional<Scorer> findByPlayerId(@Param("playerId") Long playerId);
}
