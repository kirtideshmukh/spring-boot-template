package com.organisation.adapter.http.response;

import com.organisation.entity.ToDo;
import java.time.LocalDate;

public class ToDoResponse {
  private String description;
  private LocalDate dueDate;

  public ToDoResponse(String description, LocalDate dueDate) {
    this.description = description;
    this.dueDate = dueDate;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public static ToDoResponse from(ToDo toDo) {
    return new ToDoResponse(toDo.getDescription(), toDo.getDueDate());
  }
}
