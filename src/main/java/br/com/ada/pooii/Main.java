package br.com.ada.pooii;

import br.com.ada.pooii.Controller.TaskController;
import br.com.ada.pooii.Domain.BaseTask;
import br.com.ada.pooii.Repository.TaskRepository;
import br.com.ada.pooii.Service.TaskService;
import br.com.ada.pooii.View.TaskView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskRepository<BaseTask> taskRepository = new TaskRepository<>();

        TaskView taskView = new TaskView(new Scanner(System.in));

        TaskService taskService = new TaskService(taskRepository, taskView);

        TaskController taskController = new TaskController(taskService, taskView);

        taskController.iniciar();
    }
}
