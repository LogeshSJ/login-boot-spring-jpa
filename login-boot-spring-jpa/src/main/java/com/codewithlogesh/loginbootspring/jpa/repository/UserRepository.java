package com.codewithlogesh.loginbootspring.jpa.repository;

import com.codewithlogesh.loginbootspring.jpa.model.AppUser;
import com.codewithlogesh.loginbootspring.jpa.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> {
    @Query("SELECT u FROM AppUser u WHERE u.username=:username and u.password=:password")
    AppUser findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
