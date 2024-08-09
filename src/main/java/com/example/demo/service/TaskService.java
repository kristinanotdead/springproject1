package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<List<Task>> getAllTasks() {
        return Optional.of((List<Task>) taskRepository.findAll());
    }

    public Optional<Task> getTaskById(long id) {
        return taskRepository.findById(id);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task employee) {
        return taskRepository.save(employee);
    }

    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    public void markAsDone(long id) {
        taskRepository.markAsDone(id);
    }

}

