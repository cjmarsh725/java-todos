package com.lambdaschool.javatodos.repository;

import com.lambdaschool.javatodos.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer>
{
}
