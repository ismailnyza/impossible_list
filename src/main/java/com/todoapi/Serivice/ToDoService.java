package com.todoapi.Serivice;

import com.todoapi.DTO.ToDoItemUpdateDTO;
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

    public ToDoItem createToDoItem(ToDoItem toDoItem) {
        return toDoRepository.save(toDoItem);
    }

    public List<ToDoItem> getAllTodos() {
        return toDoRepository.findAll();
    }

    public Optional<ToDoItem> getTodoById(Integer todoId) {
        return toDoRepository.findById(todoId);
    }

    public void deleteToDoById(Integer todoId) {
        toDoRepository.deleteById(todoId);
    }

    public ToDoItem editTodoById(Integer todoId, ToDoItemUpdateDTO updateDTO) {

        Optional<ToDoItem> optionalToDoItem = toDoRepository.findById(todoId);
        if (!optionalToDoItem.isPresent()) {
//            throw new NoSuchElementException("ToDoItem not found");
            System.out.println("Todo Not Found");

        }
        ToDoItem toDoItem = optionalToDoItem.get();
        if (updateDTO.getTitle() != null) {
            toDoItem.setTitle(updateDTO.getTitle());
        }
        if (updateDTO.getDescription() != null) {
            toDoItem.setDescription(updateDTO.getDescription());
        }
        if (updateDTO.getStatus() != null) {
            toDoItem.setStatus(updateDTO.getStatus());
        }
        if (updateDTO.getPriority() != null) {
            toDoItem.setPriority(updateDTO.getPriority());
        }
        if (updateDTO.getDueDate() != null) {
            toDoItem.setDueDate(updateDTO.getDueDate());
        }

        return toDoRepository.save(toDoItem);
    }
}
