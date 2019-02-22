package com.lambdaschool.javatodos.repository;

import com.lambdaschool.javatodos.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>
{
}
