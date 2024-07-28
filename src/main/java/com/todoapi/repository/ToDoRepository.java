package com.todoapi.repository;

import com.todoapi.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToDoRepository extends JpaRepository<ToDoItem , Integer> {

}
