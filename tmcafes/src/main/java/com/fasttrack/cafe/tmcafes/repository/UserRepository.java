package com.fasttrack.cafe.tmcafes.repository;

import com.fasttrack.cafe.tmcafes.model.Users;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//JPA CHUAN HOA CRUD
@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    //CRUD
    // JPQL
    Optional<Users> findByUsername(String username) throws DataAccessException;

}
