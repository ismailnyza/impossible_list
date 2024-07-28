package com.todoapi.Controller;

import com.todoapi.Serivice.ToDoService;
import com.todoapi.model.ToDoItem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/todo")
@Tag(name = "To-Do Management", description = "APIs for managing to-do items")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping("/create")
    @Operation(summary = "Create a new to-do item")
    public ResponseEntity<ToDoItem> createToDoItem(@RequestBody ToDoItem toDoItem){
        ToDoItem createdToDoitem = toDoService.createToDoItem(toDoItem);
        return new ResponseEntity<>(createdToDoitem, HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ToDoItem>> getAllTodos(){
        List<ToDoItem> allTodos = toDoService.getAllTodos();
        return new ResponseEntity<>(allTodos , HttpStatus.OK);
    }

    @GetMapping("/get/{todoId}")
    @Operation(summary = "Get a to-do item by ID", description = "Fetches a single to-do item by its ID")
    public ResponseEntity<ToDoItem> getToDoByID(@PathVariable Integer todoId) {
        Optional<ToDoItem> toDoItem = toDoService.getTodoById(todoId);

        if (toDoItem.isPresent()) {
            return new ResponseEntity<>(toDoItem.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/delete/{todoId}")
    @Operation(summary = "Get a to-do item by ID", description = "Delets a single to-do item by its ID")
    public String deleteToDoByID(@PathVariable Integer todoId) {
        toDoService.deleteToDoById(todoId);
        String deletedMessage;
        return deletedMessage = "deleted";
    }

}
