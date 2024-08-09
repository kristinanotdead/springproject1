package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Optional<List<Task>>> getAll() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/findTaskById/{id}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/deleteTask/{TaskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long Id) {
        taskService.deleteTask(Id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/task/{id}")
    public void patchMethod(@PathVariable Long id,
                            @RequestBody Task task) {
        if (task.isDone()) {
            taskService.markAsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchMethod(@PathVariable Long id) {
        taskService.markAsDone(id);
    }
}






