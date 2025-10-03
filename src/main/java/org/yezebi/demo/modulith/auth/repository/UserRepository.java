package org.yezebi.demo.modulith.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yezebi.demo.modulith.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {}
