package com.todoapi.DTO;

import lombok.Data;

@Data
public class ToDoItemUpdateDTO {
    private Long id;
    private String title;
    private String description;
    private String dueDate;
    private String priority;
    private String status;
}
