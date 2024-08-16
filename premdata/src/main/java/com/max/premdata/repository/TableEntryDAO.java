package com.max.premdata.repository;

import com.max.premdata.entity.TableEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableEntryDAO extends JpaRepository<TableEntry, Long> {
}
