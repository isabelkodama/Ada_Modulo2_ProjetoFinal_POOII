package br.com.ada.pooii.Repository;

import br.com.ada.pooii.Domain.BaseTask;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository<T extends BaseTask> {
    private List<T> tasks = new ArrayList<>();

    public void addTask(T task) {
        tasks.add(task);
    }

    public List<T> getTasks() {
        return new ArrayList<>(tasks);
    }

    public T getTaskIndex(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        }
        System.out.println("O valor inserido não atende ao intervalo da lista.");
        return null;
    }

    public void editarTaskIndex(int index, T novaTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, novaTask);
        } else {
            System.out.println("O valor inserido não atende ao intervalo da lista.");
        }
    }

    public void removerTaskIndex(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
}