package com.todo.app.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo.app.dao.UserDao;


@Repository
public interface UserItemRepository extends JpaRepository<UserDao, Long> {
	
	@Query("SELECT u.username FROM UserDao u")
    List<String> findAllNames();
}
