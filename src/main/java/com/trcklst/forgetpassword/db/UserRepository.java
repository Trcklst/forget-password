package com.trcklst.forgetpassword.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Optional<User> findByIdAndRestPasswordToken(Integer id, String resetPasswordToken);

}
