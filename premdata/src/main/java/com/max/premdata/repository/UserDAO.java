package com.max.premdata.repository;

import com.max.premdata.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<Users, Long> {


}
