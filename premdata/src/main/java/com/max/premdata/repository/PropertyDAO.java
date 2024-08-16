package com.max.premdata.repository;

import com.max.premdata.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDAO extends JpaRepository<Property, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM properties WHERE key = (:key)")
    public Property findByKey(@Param("key") String key);
}
