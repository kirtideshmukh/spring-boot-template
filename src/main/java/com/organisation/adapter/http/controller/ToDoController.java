package com.organisation.adapter.http.controller;

import com.organisation.adapter.http.request.AddToDoRequest;
import com.organisation.adapter.http.response.ToDoResponse;
import com.organisation.entity.ToDo;
import com.organisation.repository.ToDoRepository;
import io.vavr.collection.List;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/todo")
public class ToDoController {

  private ToDoRepository toDoRepository;

  @Autowired
  public ToDoController(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  @PostMapping
  public ResponseEntity<ToDoResponse> createToDo(@RequestBody AddToDoRequest request) {
    ToDo toDo = new ToDo(request.getDescription(), LocalDateTime.now(), request.getDueDate());
    ToDo saved = toDoRepository.save(toDo);
    return ResponseEntity.ok(ToDoResponse.from(toDo));
  }

  @GetMapping
  public ResponseEntity<List<ToDoResponse>> getAllToDos() {
    List<ToDo> toDos = toDoRepository.findAllEntities();
    return ResponseEntity.ok(toDos.map(ToDoResponse::from));
  }
}
