package com.todoapi.Serivice;

import com.todoapi.model.ToDoItem;
import com.todoapi.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public ToDoItem createToDoItem(ToDoItem toDoItem){
        return toDoRepository.save(toDoItem);
    }

    public List<ToDoItem> getAllTodos(){
        return toDoRepository.findAll();
    }

    public Optional<ToDoItem> getTodoById(Integer todoId){
        return toDoRepository.findById(todoId);
    }

    public void deleteToDoById(Integer todoId){
        toDoRepository.deleteById(todoId);
    }

}
