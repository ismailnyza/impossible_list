package com.todoapi.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ToDoItemDTO {
    private Long id;
    private String title;
    private String description;
    private String dueDate;
    private String priority;
    private String status;
}
