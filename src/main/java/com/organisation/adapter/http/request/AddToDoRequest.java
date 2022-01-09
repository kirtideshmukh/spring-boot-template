package com.organisation.adapter.http.request;

import java.time.LocalDate;

public class AddToDoRequest {
  private String description;
  private LocalDate dueDate;

  public AddToDoRequest() {
    // for spring framework only
  }

  public AddToDoRequest(String description, LocalDate dueDate) {
    this.description = description;
    this.dueDate = dueDate;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }
}
