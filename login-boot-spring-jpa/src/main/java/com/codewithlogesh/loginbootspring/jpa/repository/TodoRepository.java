package com.codewithlogesh.loginbootspring.jpa.repository;

import com.codewithlogesh.loginbootspring.jpa.model.AppUser;
import com.codewithlogesh.loginbootspring.jpa.model.Todo;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
